package com.jike.testcurator;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorEventType;

import org.apache.curator.retry.RetryUntilElapsed;
import org.apache.zookeeper.data.Stat;

public class Checkexits {
	//超时时间
public static void main(String[] args) throws Exception {
	ExecutorService es=Executors.newFixedThreadPool(5);
	//RetryPolicy retryPolicy=new ExponentialBackoffRetry(1000, 3) ;
	//RetryPolicy retryPolicy=new RetryNTimes(5, 1000);
	RetryPolicy retryPolicy=new RetryUntilElapsed(5000, 1000);
	//CuratorFramework client=CuratorFrameworkFactory.newClient("172.16.191.145",5000,5000, retryPolicy);
	CuratorFramework client=CuratorFrameworkFactory.builder().
			connectString("172.16.191.147:2181").
			sessionTimeoutMs(5000).
			connectionTimeoutMs(5000).
			retryPolicy(retryPolicy).build();
	client.start();
	//异步调用不需要返回值
	client.checkExists().inBackground(new BackgroundCallback() {
		
		public void processResult(CuratorFramework arg0, CuratorEvent arg1) throws Exception {
			// TODO Auto-generated method stub
			Stat stat=arg1.getStat();
			System.out.println(stat);
			
//			CuratorEventType t=arg1.getType();
//			int r=arg1.getResultCode();//异步操作执行成功返回0  失败返回非0
//			Object o=arg1.getContext();//上下文可传入任何类型的Object
//		   
//			arg1.getPath();
//		     arg1.getChildren();
//		     arg1.getData();
		}
	},"123",es).forPath("/jike");
   
   Thread.sleep(Integer.MAX_VALUE);
}
}
