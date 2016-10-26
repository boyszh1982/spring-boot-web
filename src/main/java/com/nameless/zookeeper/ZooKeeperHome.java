package com.nameless.zookeeper;

import org.I0Itec.zkclient.ZkClient;

public class ZooKeeperHome {

	public static void main2(String[] args) {
		/**
		 * 在招商系统中ZooKeeper的应用流程
		 * redis的服务地址为 w10669.wdds.redis.com:10669 （域名会改为IP，且多个）
		 * zookeeper 的znode为/10669,
		 * 这个znode的值会由运维人员来修改，一旦这个值发生变化，zookeeper会发现，并调用
		 * RedisConfigMonitorObserver.update方法
		 */
		String serverStr = "127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183";
		demo("127.0.0.1:2183,127.0.0.1:2184");
		demo("127.0.0.1:2182");
		demo("127.0.0.1:2181");
	}
	public static void demo(String serverStr) {
		 ZkClient zkClient = new ZkClient(serverStr);
         String node = "/app2";
         if (!zkClient.exists(node)) {
        	 System.out.println(serverStr+" not exists "+node + " , create new one .");
             zkClient.createPersistent(node, "hello zk");
         }
         //zkClient.delete(node);
         System.out.println(serverStr+" exists "+node+"="+zkClient.readData(node));
	}
}
