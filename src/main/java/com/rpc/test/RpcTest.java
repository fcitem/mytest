package com.rpc.test;

import java.net.InetSocketAddress;
import java.util.concurrent.CountDownLatch;

public class RpcTest {

	public static void main(String[] args) throws InterruptedException {
	 CountDownLatch startlatch=new CountDownLatch(1);
	 new Thread(new RemoteServerStart(startlatch)).start();
	 startlatch.await();         //保证服务端启动完成
     HelloService service = RpcClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 8088));
     System.out.println(service.sayHello("test"));
	}
}
class RemoteServerStart implements Runnable{
	CountDownLatch latch;
	public RemoteServerStart(CountDownLatch latch) {
		this.latch=latch;
	}
	public void run() {
		try {
            Server serviceServer = new ServiceProvider(8088);          //服务端开启
            serviceServer.register(HelloService.class, HelloServiceImpl.class);
            this.latch.countDown();
            serviceServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
