package com.elasticsearch.test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

public class App {
	
	TransportClient client;
	
	@Before
	public void init() throws UnknownHostException {
		Settings settings=Settings.builder().build();
		client=new PreBuiltTransportClient(settings).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("120.78.222.34"),9300));
	}

	public static void main( String[] args ) throws UnknownHostException
    {
        Settings settings=Settings.builder().build();
        //使用TransportClient与 ElasticSearch建立连接
        TransportClient client=new PreBuiltTransportClient(settings).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("120.78.222.34"),9300));
        //创建索引
        IndexRequestBuilder builder=EsOpUtils.createIndex(client, "users", "user","1");
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("name", "fc");
        map.put("password", "123456");
        EsOpUtils.pushData(builder,map);
    }
	
	@Test
	public void createIndex() {
		 IndexRequestBuilder builder=EsOpUtils.createIndex(client, "users", "user","1");
	     Map<String,Object> map=new HashMap<String, Object>();
	     map.put("name", "fc");
	     map.put("password", "123456");
	     EsOpUtils.pushData(builder,map);
	}
	
	@Test
	public void testGet() {
		String ret=EsOpUtils.getData(client, "users", "user","1");
		System.out.println(ret);
	}
	
	@Test
	public void testGetByIndex() {
		List<String> ret=EsOpUtils.getDataList(client, "users", "user");
		System.out.println(ret);
	}
}
