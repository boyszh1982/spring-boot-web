package com.nameless.zookeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class ZooKeeperWatch {

	public static void main1(String[] args) throws IOException, InterruptedException, KeeperException {
		
		final CountDownLatch latch = new CountDownLatch(1);
		
		ZooKeeper zk = new ZooKeeper("127.0.0.1:2181",5000,new Watcher(){

			@Override
			public void process(WatchedEvent event) {
				
				if(event.getState() == KeeperState.SyncConnected) {
					latch.countDown();
				}
				
				if(event.getType() == EventType.NodeDeleted ){
					System.out.println(event.getPath() + " is deleted !");
				}
				
			}
			
		});
		
		latch.await();
		
		//String nodePath = zk.create("/helloworld", "hello".getBytes() , Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
		
		//Thread.sleep(10*1000L);
		
		
		
	}

}
