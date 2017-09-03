package com.nio.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Testnio {
	public static void main(String[] args){
		StringBuilder builder=new StringBuilder();
		FileInputStream file;
		try {
			file = new FileInputStream("sql.txt");
			@SuppressWarnings("resource")
			BufferedReader reader=new BufferedReader(new InputStreamReader(file));
			String str=reader.readLine();
			while(str!=null){
				builder.append(str);
				builder.append("\n");
				str=reader.readLine();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addFile(builder);
	}
	static void addFile(StringBuilder str){
		final int size=1024*1024;        //缓冲区大小
		FileOutputStream out;
		try {
			out = new FileOutputStream("a.txt");         //输出流
			FileChannel chanle=out.getChannel();
			ByteBuffer buffer=ByteBuffer.allocate(size);
			int position=0;   //标记字节数组上次取值结束的位置
			byte buf[]=str.toString().getBytes();
			int arraysize=buf.length;      //文件的字节大小
			while(arraysize>size){       //数据大于换从区大小，则循环利用缓冲区写入
				buffer.clear();
				for (int i = 0; i < size; i++) {   //循环取值直到填满缓冲区
					buffer.put(buf[position]);
					position++;
					arraysize--;
				}
				buffer.flip();
				chanle.write(buffer);      //将缓冲区的数据写入通道
			}
			if(arraysize>0){              //如果数据小于缓冲区大小，则直接写入
				buffer.clear();
				for (int i = 0; i < arraysize; i++) {
					buffer.put(buf[position]);
					position++;
				}
				buffer.flip();
				long start=System.nanoTime();
				chanle.write(buffer);
				System.out.println(System.nanoTime()-start);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
