package myproject;

import javax.websocket.Endpoint;

public class JerseyConfig extends ResourceConfig{
      public JerseyConfig(){
    	  register(Endpoint.class);
      }

	private void register(Class<Endpoint> class1) {
		// TODO Auto-generated method stub
		
	}
}
