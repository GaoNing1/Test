package com.bug;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.spi.JsonbProvider;

import org.eclipse.yasson.JsonBindingProvider;

public class App {
	public static void main(String[] args) {
	// 创建一个可重用固定线程数的线程池
		ExecutorService pool = Executors.newFixedThreadPool(2);
	//创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
		Thread t = new MyThread();
		pool.execute(t);
		pool.shutdown();

	}
}

class MyThread extends Thread {
	@Override
	public void run() {

		try {

			URL url = new URL("http://date.jsontest.com");

			URLConnection connection = url.openConnection();

			//获取输入流

		InputStreamReader isr = new InputStreamReader(connection.getInputStream(), "UTF-8");
			
			BufferedReader bf = new BufferedReader(isr);

			// 写在一个文件中
			FileOutputStream fos = new FileOutputStream("/Users/gaoning/123");

			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);

			String json;
			StringBuffer sb=new StringBuffer();
			while ((json = bf.readLine()) != null) {
				System.out.println(json);
				sb.append(json);
				bw.write(json);
			}
			bw.flush();
			bw.close();
			System.out.println(sb.toString());
			String jsontext=sb.toString();
			JsonbProvider jp=JsonBindingProvider.provider();
			JsonbBuilder jb=jp.create();
			Jsonb jsoub=jb.build();
			Data d=jsoub.fromJson(jsontext,Data.class);
			System.out.println(d.toString());
			osw.close();
			fos.close();
			bf.close();
			isr.close();
			System.out.println("写入成功");
		
				} catch (Exception e) {

			e.printStackTrace();
		}
		super.run();
	}
}
