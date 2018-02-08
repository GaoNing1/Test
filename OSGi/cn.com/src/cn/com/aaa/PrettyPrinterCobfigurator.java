package cn.com.aaa;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;



import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;


import cn.com.provider.Multicastlmpl;
/**
 * 1.注册服务实现 managedService
 * update对ConfigurationAdmin服务的调用持续保存新的配置数据，
 * 并向ManagedService注册的服务PID 
 * 发送一个更新org.sample.PrettyPrinterConfigurator，
 * 这恰好是PrettyPrinterConfigurator类。


 * @author gaoning
 *
 */
public class PrettyPrinterCobfigurator implements ManagedService {
	private static final Logger log = Logger.getLogger(Multicastlmpl.class.getName());
	private AtomicLong longGen = new AtomicLong(0);
	ConfigurationAdmin confAdmin;

	public PrettyPrinterCobfigurator(ConfigurationAdmin confAdmin) {
		this.confAdmin = confAdmin;
	}

	@Override
	public void updated(Dictionary<String, ?> properties) throws ConfigurationException {
		// TODO Auto-generated method stub
		System.out.println("========PrettyPrinterCobfigurator.updated========");
		System.out.println(properties);
		if (properties == null) {
			Configuration config;
			try {
				//响应网关获取configuration。再update
				config = confAdmin.getConfiguration("org.sample.PrettyPrinterConfigurator");
				Dictionary<String, Object> props = config.getProperties();
				if (props == null) {
					props = new Hashtable<String, Object>();
				}
				props.put("msgId", longGen.incrementAndGet());
				props.put("msgType", "0");
				props.put("msgContent", "");

				config.update(props);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.log(Level.SEVERE, "", e);
			}
		}
	}

}
