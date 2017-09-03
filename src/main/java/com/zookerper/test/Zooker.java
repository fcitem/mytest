package com.zookerper.test;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class Zooker {
	// 会话超时时间，设置为与系统默认时间一致
	private static final int SESSION_TIMEOUT=30000;
	// 创建 ZooKeeper 实例
	ZooKeeper zk;
	Watcher wh;
	public Zooker() {
		// TODO Auto-generated constructor stub
		// 创建 Watcher 实例
		wh=new Watcher(){
		  public void process(org.apache.zookeeper.WatchedEvent event)
		  {
		         System.out.println(event.toString());
		  }
		};
		try {
			zk=new ZooKeeper("192.168.0.37",SESSION_TIMEOUT,wh);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @author fengchao
	 * @data 2017年4月20日
	 * @注释 创建znode节点
	 * @param node 创建的节点名称
	 * @param desc 该节点对应的字符串描述符
	 */
	public void createZkNode(String node,String desc){
		try {
			zk.create("/"+node,desc.getBytes(),Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @author fengchao
	 * @data 2017年4月20日
	 * @注释 修改节点
	 * @param node 创建的节点名称
	 * @param desc 该节点对应的字符串描述符
	 */
	public void updateZkNode(String node,String desc){
		try {
			zk.setData("/"+node,desc.getBytes(),-1);
		} catch (KeeperException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @author fengchao
	 * @data 2017年4月20日
	 * @注释 获取节点信息
	 */
	public String getZkNode(String node){
		byte[] ret=null;
		try {
			ret =zk.getData("/"+node,false,null);
		} catch (KeeperException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new String(ret);
	}
	/**
	 * @author fengchao
	 * @data 2017年4月20日
	 * @注释 删除节点
	 */
	public void deleteZkNode(String node){
		try {
			zk.delete("/"+node, -1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (KeeperException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @author fengchao
	 * @data 2017年4月20日
	 * @注释 查看节点是否存在
	 */
	public Stat zkNodeExists(String node){
		Stat rest=null;
		try {
			rest=zk.exists("/"+node, false);
		} catch (KeeperException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return rest;
	}
	/**
	 * @author fengchao
	 * @data 2017年4月20日
	 * @注释 关闭
	 */
	public void zkClose(){
		try {
			zk.close();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Zooker zook=new Zooker();
		zook.createZkNode("fctest2","fc2");
//		zook.deleteZkNode("fctest");
		System.out.println(zook.getZkNode("fctest2"));
	}
}
