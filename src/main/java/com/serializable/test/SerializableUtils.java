package com.serializable.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-8
 * <p>Version: 1.0
 */
public class SerializableUtils {

    /**序列化
     * @param obj
     * @return
     */
    public static String serialize(TestObject obj) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            return Base64.getEncoder().encodeToString(bos.toByteArray());
        } catch (Exception e) {
            throw new RuntimeException("serialize Object error", e);
        }
    }
    /**反序列化
     * @param sessionStr
     * @return
     */
    public static TestObject deserialize(String serializStr) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(Base64.getDecoder().decode(serializStr.getBytes()));
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (TestObject)ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException("deserialize Object error", e);
        }
    }
    public static void main(String[] args) {
		TestObject object=new TestObject("fc","123456","高新区");
		TestObject obj=SerializableUtils.deserialize(serialize(object));
		System.out.println(obj);
	}
}
class TestObject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private transient String password;
	
	public TestObject(String name, String password, String addresss) {
		super();
		this.name = name;
		this.password = password;
		this.addresss = addresss;
	}
	private String addresss;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddresss() {
		return addresss;
	}
	public void setAddresss(String addresss) {
		this.addresss = addresss;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getName()+" "+this.getPassword()+" "+this.getAddresss();
	}
}
