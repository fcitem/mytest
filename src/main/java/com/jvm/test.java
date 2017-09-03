package com.jvm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class test {

	public static void main(String[] args) {
		String str=new StringBuilder("fc").append("test").toString();
		System.out.println(str.intern()==str);
		//����java�ǹؼ��ֳ������ж��Ѿ����ڣ�
		String str2=new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern());
		
		String str3="hello";              //str3��ջ���棬hello���ַ�������������
		System.out.println(str3.intern()==str3);
		
		String str4=new String("world");     ////str4��ջ���棬world��new ����Ķ�����
		System.out.println(str4.intern()==str4);
		
		String s="sdfsdf///sjkdnfjksdnfjksdn//fjksdnf\\jkdsn";
		Pattern p=Pattern.compile("[/|\\\\]+");
		Matcher m=p.matcher(s);
		System.out.println(m.replaceAll("/"));
		
		try(FileInputStream in=new FileInputStream("a.txt");
				){
			System.out.println();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
