//package cn.tedu.provider;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//import org.osgi.framework.BundleActivator;
//import org.osgi.framework.BundleContext;
//import org.osgi.framework.ServiceReference;
//
//
//
//public class Activator implements BundleActivator{
//
//	@Override
//	public void start(BundleContext context) throws Exception {
//		 ServiceReference[] refs = context.getServiceReferences(
//		            DictionaryService.class.getName(), "(Language=*)");
//
//		        if (refs != null)
//		        {
//		            try
//		            {
//		                System.out.println("Enter a blank line to exit.");
//		                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		                String word = "";
//
//		                // Loop endlessly.
//		                while (true)
//		                {
//		                    // Ask the user to enter a word.
//		                    System.out.print("Enter word: ");
//		                    word = in.readLine();
//
//		                    // If the user entered a blank line, then
//		                    // exit the loop.
//		                    if (word.length() == 0)
//		                    {
//		                        break;
//		                    }
//
//		                    // First, get a dictionary service and then check
//		                    // if the word is correct.
//		                    DictionaryService dictionary =
//		                        (DictionaryService) context.getService(refs[0]);
//		                    if (dictionary.checkWord(word))
//		                    {
//		                        System.out.println("Correct.");
//		                    }
//		                    else
//		                    {
//		                        System.out.println("Incorrect.");
//		                    }
//
//		                    // Unget the dictionary service.
//		                    context.ungetService(refs[0]);
//		                }
//		            } catch (IOException ex) { }
//		        }
//		        else
//		        {
//		            System.out.println("Couldn't find any dictionary service...");
//		        }}
//
//	@Override
//	public void stop(BundleContext context) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//	
//
//}
