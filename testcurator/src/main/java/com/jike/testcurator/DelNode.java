package com.jike.testcurator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;
import org.apache.curator.retry.RetryUntilElapsed;

public class DelNode {
	// 超时时间
	public static void main(String[] args) throws Exception {
		// RetryPolicy retryPolicy=new ExponentialBackoffRetry(1000, 3) ;
		// RetryPolicy retryPolicy=new RetryNTimes(5, 1000);
		RetryPolicy retryPolicy = new RetryUntilElapsed(5000, 1000);
		// CuratorFramework
		// client=CuratorFrameworkFactory.newClient("172.16.191.145",5000,5000,
		// retryPolicy);
		CuratorFramework client = CuratorFrameworkFactory.builder().connectString("172.16.191.146:2181")
				.sessionTimeoutMs(5000).connectionTimeoutMs(5000).retryPolicy(retryPolicy).build();
		client.start();
		client.delete().guaranteed().deletingChildrenIfNeeded().withVersion(-1).forPath("/jike20");
		Thread.sleep(Integer.MAX_VALUE);

	}
}
