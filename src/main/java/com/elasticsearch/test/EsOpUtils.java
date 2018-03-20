package com.elasticsearch.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;

import com.alibaba.fastjson.JSON;

public class EsOpUtils {

	/**创建索引
	 * @param client  连接
	 * @param indexName 索引名
	 * @param type  文档类型
	 * @param id   id
	 * @return
	 */
	public static IndexRequestBuilder createIndex(TransportClient client,String indexName,String type,String id) {
		return client.prepareIndex(indexName,type,id);
	}
	/**向索引中添加文档记录
	 * @param builder
	 * @param msg
	 * @return
	 */
	public static IndexResponse pushData(IndexRequestBuilder builder,Map<String,Object> msg) {
		String str=JSON.toJSONString(msg);
		return builder.setSource(str.getBytes(),XContentType.JSON).get();
	}
	
	/**获取指定索引的指定文档
	 * @param client
	 * @param indexName
	 * @param type
	 * @param id
	 * @return
	 */
	public static String getData(TransportClient client,String indexName,String type,String id) {
		GetResponse response=client.prepareGet(indexName, type, id)
				.setOperationThreaded(false).get();  //是否线程安全
		return response.getSourceAsString();
	}
	public static List<String> getDataList(TransportClient client,String indexName,String type){
		SearchResponse response=client.prepareSearch(indexName).setSearchType(type).get();
		List<String> rets=new ArrayList<>();
		response.getHits().forEach(hits->{rets.add(hits.getSourceAsString());});
		return rets;
	}
}
