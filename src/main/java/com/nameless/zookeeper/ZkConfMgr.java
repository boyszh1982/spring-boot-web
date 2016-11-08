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

/**
 * 利用Zk实现配置管理
 * @author Administrator
 *
 */
public class ZkConfMgr {
	
	public static String url = "127.0.0.1:2181";
	
	private final static String root = "/root";
	private final static String urlnode = root+"/url";
	private final static String usernamenode = root+"/username";
	private final static String passwordnode = root+"/password";
	
	private final static String scheme = "digest";
	private final static String auth_password = "password";
	
	/* 其他scheme访问digest中的node需要在客户端赋权
	[zk: localhost:2181(CONNECTED) 33] ls /root
	Authentication is not valid : /root
	[zk: localhost:2181(CONNECTED) 34] addauth digest password
	*/
	
	private final static CountDownLatch latch = new CountDownLatch(1);
	
	public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
		
		//ZooKeeper zk = new ZooKeeper(url, 5000, new ConfWatcher());
		ZooKeeper zk = new ZooKeeper(url, 5000, new Watcher(){
			@Override
			public void process(WatchedEvent event) {
				
				if( KeeperState.SyncConnected == event.getState() ){
					latch.countDown();
					System.out.println("latch count is "+latch.getCount());
				}
				
				if(event.getType() == EventType.NodeDataChanged){
					System.out.println("NodeDataChanged ...... "+event.getPath());
					try{
						//只能用这种方法获取变更后的值么？
						ZooKeeper zk_inner = new ZooKeeper(url,5000,new Watcher(){
							@Override
							public void process(WatchedEvent arg0) {
								// TODO Auto-generated method stub
								
							}
						});
						zk_inner.addAuthInfo(scheme, auth_password.getBytes("UTF-8"));
						String data = new String(zk_inner.getData(event.getPath(), true, null),"UTF-8");
						System.out.println(event.getPath()+" >>>>>> "+data);
						zk_inner.close();
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		});
		
		System.out.println("latch count is "+latch.getCount());
		System.out.println("before await ...... "+new java.util.Date());
		latch.await();
		// 如果 latch.countDown() 没有被成功执行并且 latch.getCount()!=0 时，await()以后的内容是不会呗执行的。
		System.out.println("after await ...... "+new java.util.Date());
		System.out.println("latch count is "+latch.getCount());
		
		/* 此处改为用CountDownLatch 实现
		while(ZooKeeper.States.CONNECTED != zk.getState()){
			Thread.sleep(3000);
		}
		*/
		
		//登录认证
		zk.addAuthInfo(scheme, auth_password.getBytes("UTF-8"));
		//删除节点，-1是什么意思？
		/*zk.delete(urlnode, -1);
		zk.delete(usernamenode, -1);
		zk.delete(passwordnode, -1);
		zk.delete(root, -1);*/
		
		//如果不存在ROOT则...  , true表述需要watch
		if(zk.exists(root, true) == null ){
			//Ids.几种参数的含义？,CreateMode.几种参数的含义？
			zk.create(root, "root".getBytes("UTF-8"), Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
		}
		
		if(zk.exists(urlnode, true) == null ){
			zk.create(urlnode, "127.0.0.1:2181".getBytes("UTF-8"), Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
		}
		
		if(zk.exists(usernamenode, true) == null){
			zk.create(usernamenode, "admin".getBytes("UTF-8"), Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
		}
		
		if(zk.exists(passwordnode, true) == null){
			zk.create(passwordnode, "admin123".getBytes("UTF-8"), Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
		}
		
		while(true){
			// null 是什么 Stat 是什么？
			String rootData = new String(zk.getData(root, true, null),"UTF-8");
			String urlnodeData = new String(zk.getData(urlnode, true, null),"UTF-8");
			String usernamenodeData = new String(zk.getData(usernamenode, true, null),"UTF-8");
			String passwordnodeData = new String(zk.getData(passwordnode, true, null),"UTF-8");
			
			System.out.println("rootData ...... "+rootData);
			System.out.println("urlnodeData ...... "+urlnodeData);
			System.out.println("usernamenodeData ...... "+usernamenodeData);
			System.out.println("passwordnodeData ...... "+passwordnodeData);
			
			if(rootData!= null && rootData.equals("exit...")){
				break ;
			}
			
			Thread.sleep(10*1000L);
		}
		
		
		
		zk.close();
	}
}

/**
 * ConfWatcher 放到ZkConfMgr类中，变为内部类怎么使用？
 * @author Administrator
 *
 */
class ConfWatcher implements Watcher {

	/**
	 * 方法中如何获取节点的数据？
	 */
	@Override
	public void process(WatchedEvent event) {
		
		if(event.getType() == EventType.NodeCreated){
			System.out.println("NodeCreated ...... "+event.getPath());
		}
		
		if(event.getType() == EventType.NodeDeleted){
			System.out.println("NodeDeleted ...... "+event.getPath());
		}
		
		if(event.getType() == EventType.NodeDataChanged){
			System.out.println("NodeDataChanged ...... "+event.getPath());
		}
		
		if(event.getType() == EventType.NodeChildrenChanged){
			System.out.println("NodeChildrenChanged ...... "+event.getPath());
		}
	}
	
}

