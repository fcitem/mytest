package com.jvm;

import java.util.ArrayList;
import java.util.List;

public class TestDump {

	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		//加上jvm启动参数-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=d://dump
		while(true){
			list.add("xcvnxcvbcxkvjdfgdfgddddddddddddddddddddddddddddddddddd");
		}
	}
}
