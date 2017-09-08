package com.generic.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**泛型测试
 * @author fengchao
 *
 */
public class GenericTest {

	private String password;
	
	/**泛型推导
	 * @return
	 */
	public static <K,V> HashMap<K, V> getHashMap(){
		HashMap<K, V> map=new HashMap<>();
		return map;
	}
	/**customer super
	 * @param list
	 */
	public static void add(List<? super GenericTest> list){
		GenerticSon son=new GenerticSon();
		list.add(son);
//		GenerticSon ss=list.get(0);
	}
	/**provider extends
	 * @param list
	 * @return
	 */
	public static <T> T get(List<? extends T> list){
		T t=list.get(0);
		return t;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static void main(String[] args) {

		HashMap<String, Object> map=GenericTest.getHashMap();
		System.out.println(map.size());
		List<GenericTest> list=new ArrayList<>();
		GenericTest.add(list);
		System.out.println(list.get(0).getClass());
		System.out.println(GenericTest.get(list).getClass());
	}
}
class GenerticSon extends GenericTest{
	
	private String name="fc";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}