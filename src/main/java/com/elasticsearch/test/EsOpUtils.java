package com.elasticsearch.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.GetRequestBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryAction;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.metrics.avg.AvgAggregationBuilder;

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
	/**批量添加文档
	 * @param builder
	 * @param msg
	 */
	public static BulkResponse pushDataList(TransportClient client,Map<String,Object> msg) {
		BulkRequestBuilder bulkRequestBuilder=client.prepareBulk();
		IndexRequestBuilder index1=client.prepareIndex("users", "user");
		Map<String,Object> map=new HashMap<String, Object>();
	    map.put("name", "fc6");
	    map.put("password", "123456");
		index1.setSource(msg,map);
		bulkRequestBuilder.add(index1);
		return bulkRequestBuilder.get();
	}
	
	public static BulkResponse pushDataOther(TransportClient client,Map<String,Object> msg) {
		BulkRequestBuilder bulkRequestBuilder=client.prepareBulk();
		IndexRequestBuilder index1=client.prepareIndex("users", "user");
		IndexRequestBuilder index2=client.prepareIndex("users", "score");
		Map<String,Object> map=new HashMap<String, Object>();
	    map.put("name", "fc3");
	    map.put("password", "123456");
		index1.setSource(msg);
		index2.setSource(map);
		bulkRequestBuilder.add(index1);
		//TODO 批量添加的时候原先没有这个type,添加不成功？
		bulkRequestBuilder.add(index2);
		return bulkRequestBuilder.get();
	}
	
	/**获取指定索引的指定文档
	 * @param client
	 * @param indexName
	 * @param type
	 * @param id
	 * @return
	 */
	public static String getData(TransportClient client,String indexName,String type,String id) {
		GetRequestBuilder request=client.prepareGet(indexName, type, id).setOperationThreaded(false);
		GetResponse response=request.get();  //是否线程安全
		return response.getSourceAsString();
	}
	/**删除数据
	 * @param client
	 * @return 删除数据的个数
	 */
	public static long deleteData(TransportClient client) {
		BulkByScrollResponse response=DeleteByQueryAction.INSTANCE.newRequestBuilder(client).filter(QueryBuilders.matchQuery("name", "fc")).source("users").get();
		return response.getDeleted();
	}
	
	public static void query(TransportClient client) {
	   QueryBuilder builder=QueryBuilders.termQuery("name", "fc");
	   SearchRequestBuilder request=client.prepareSearch("test").setQuery(builder);
	   AvgAggregationBuilder avgaggreation= AggregationBuilders.avg("avg-number").field("number");
	   request.addAggregation(avgaggreation);
	   System.out.println(request);
	   request.get();
	}
	
	public static List<String> getDataList(TransportClient client,String indexName,String type){
		SearchResponse response=client.prepareSearch(indexName).setSearchType(type).get();
		List<String> rets=new ArrayList<>();
		response.getHits().forEach(hits->{rets.add(hits.getSourceAsString());});
		return rets;
	}
}
