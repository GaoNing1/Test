package cn.tedu.provider;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

public class Multicastlmpl implements BundleActivator ,ServiceListener{
	// Bundle's context.
    private BundleContext m_context = null;
    // The service reference being used.
    private ServiceReference m_ref = null;
    // The service object being used.
    private DictionaryService m_dictionary = null;

	@Override
	public void serviceChanged(ServiceEvent event) {
		 String[] objectClass =
  (String[]) event.getServiceReference().getProperty("objectClass");

	        
	        if (event.getType() == ServiceEvent.REGISTERED)
	        {
	            if (m_ref == null)
	            {
	               
	                m_ref = event.getServiceReference();
	                m_dictionary = (DictionaryService) m_context.getService(m_ref);
	            }
	        }
	     
	        else if (event.getType() == ServiceEvent.UNREGISTERING)
	        {
	            if (event.getServiceReference() == m_ref)
	            {
	                
	                m_context.ungetService(m_ref);
	                m_ref = null;
	                m_dictionary = null;

	                // Query to see if we can get another service.
	                ServiceReference[] refs = null;
	                try
	                {
	                    refs = m_context.getServiceReferences(
	                        DictionaryService.class.getName(), "(Language=*)");
	                }
	                catch (InvalidSyntaxException ex)
	                {
	                    // This will never happen.
	                }
	                if (refs != null)
	                {
	                    // Get a reference to the first service object.
	                    m_ref = refs[0];
	                    m_dictionary = (DictionaryService) m_context.getService(m_ref);
	                }
	            }
	        }
	    }
	

	@Override
	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		 m_context = context;
	        synchronized (this)
	        {
	            // Listen for events pertaining to dictionary services.
	           
	        	 ServiceReference[] refs = m_context.getServiceReferences(
	                     DictionaryService.class.getName(), "(Language=*)");


	           if (refs != null)
	            {
	                m_ref = refs[0];
	                m_dictionary = (DictionaryService) m_context.getService(m_ref);
	            }
	        }

	        try
	        {
	            System.out.println("Enter a blank line to exit.");
	            String word = "";
	            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	            // Loop endlessly.
	            while (true)
	            {
	                // Ask the user to enter a word.
	                System.out.print("Enter word: ");
	                word = in.readLine();

	                // If the user entered a blank line, then
	                // exit the loop.
	                if (word.length() == 0)
	                {
	                    break;
	                }
	                // If there is no dictionary, then say so.
	                else if (m_dictionary == null)
	                {
	                    System.out.println("No dictionary available.");
	                }
	                // Otherwise print whether the word is correct or not.
	                else if (m_dictionary.checkWord(word))
	                {
	                    System.out.println("Correct.");
	                }
	                else
	                {
	                    System.out.println("Incorrect.");
	                }
	            }
	        } catch (Exception ex) { }	
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void start(BundleContext context) throws Exception {
//		// TODO Auto-generated method stub
//		 System.out.println("Starting to listen for service events.");
//	        context.addServiceListener(this);
//	}
//
//	@Override
//	public void stop(BundleContext context) throws Exception {
//		// TODO Auto-generated method stub
//	
//		context.removeServiceListener(this);
//        System.out.println("Stopped listening for service events.");
//	}
//
//	@Override
//	public void serviceChanged(ServiceEvent event) {
//		// TODO Auto-generated method stub
//		 String[] objectClass = (String[])
//		            event.getServiceReference().getProperty("objectClass");
//
//		        if (event.getType() == ServiceEvent.REGISTERED)
//		        {
//		            System.out.println(
//		                "Ex1: Service of type " + objectClass[0] + " registered.");
//		        }
//		        else if (event.getType() == ServiceEvent.UNREGISTERING)
//		        {
//		            System.out.println(
//		                "Ex1: Service of type " + objectClass[0] + " unregistered.");
//		        }
//		        else if (event.getType() == ServiceEvent.MODIFIED)
//		        {
//		            System.out.println(
//		                "Ex1: Service of type " + objectClass[0] + " modified.");
//		        }
//	}

}
