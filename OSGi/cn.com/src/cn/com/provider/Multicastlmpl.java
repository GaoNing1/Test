package cn.com.provider;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;

public class Multicastlmpl implements BundleActivator,ServiceListener {
	

	@Override
	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Starting to listen for service events.");
        context.addServiceListener(this);
		
	}

	@Override
	public void stop(BundleContext context) throws Exception {
	
		 context.removeServiceListener(this);
	        System.out.println("Stopped listening for service events.");
	}

	@Override
	public void serviceChanged(ServiceEvent event) {
		// TODO Auto-generated method stub
		String[] objectClass = (String[])
	            event.getServiceReference().getProperty("objectClass");

	        if (event.getType() == ServiceEvent.REGISTERED)
	        {
	            System.out.println(
	                "Ex1: Service of type " + objectClass[0] + " registered.");
	        }
	        else if (event.getType() == ServiceEvent.UNREGISTERING)
	        {
	            System.out.println(
	                "Ex1: Service of type " + objectClass[0] + " unregistered.");
	        }
	        else if (event.getType() == ServiceEvent.MODIFIED)
	        {
	            System.out.println(
	                "Ex1: Service of type " + objectClass[0] + " modified.");
	        }
		
	}
	}


