package org.javacore.io.serializable;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;

/**
 * <p>
 * 
 * <pre>
 * Java序列化和反序列化的小例子
 * </pre>
 * 
 * 只有实现了Serializable和Externalizable接口的类的对象才能被序列化。
 * Externalizable接口继承自Serializable接口，实现Externalizable接口的类完全由自身来控制序列化的行为，而仅实现Serializable接口的类可以
 * 采用默认的序列化方式 。
 * </p>
 * 
 * @author taomk
 * @since 2016-8-2 11:05
 */
@SuppressWarnings("restriction")
public class SerializableT {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		AObjcet aObjcet = new AObjcet();
		long beginTime = System.currentTimeMillis();

		ByteOutputStream byteOutput = new ByteOutputStream();
		ObjectOutputStream objectOutput = new ObjectOutputStream(byteOutput);
		objectOutput.writeObject(aObjcet);
		objectOutput.close();
		byteOutput.close();
		byte[] bytes = byteOutput.toByteArray();
		System.out.println("Java序列化耗时：" + (System.currentTimeMillis() - beginTime) + "ms");
		System.out.println("Java序列化后的字节大小为：" + bytes.length);

		beginTime = System.currentTimeMillis();
		ByteArrayInputStream byteInput = new ByteArrayInputStream(bytes);
		ObjectInputStream objectInput = new ObjectInputStream(byteInput);
		Object returnObj = objectInput.readObject();
		objectInput.close();
		byteInput.close();
		System.out.println("Java反序列化耗时：" + (System.currentTimeMillis() - beginTime) + "ms");
		System.out.println(returnObj);

	}
}

class AObjcet implements Serializable {
	private static final long serialVersionUID = 1L;
	private String a = "bysocket";
	private String b = "likes";
	private String c = "java";
	private String d = "world";

	private int i = 100;
	private int j = 10;
	private long m = 100L;

	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	public long getM() {
		return m;
	}
	public void setM(long m) {
		this.m = m;
	}
	public boolean isA() {
		return isA;
	}
	public void setA(boolean isA) {
		this.isA = isA;
	}
	public boolean isB() {
		return isB;
	}
	public void setB(boolean isB) {
		this.isB = isB;
	}
	public boolean isC() {
		return isC;
	}
	public void setC(boolean isC) {
		this.isC = isC;
	}
	public BObject getaObject() {
		return aObject;
	}
	public void setaObject(BObject aObject) {
		this.aObject = aObject;
	}
	public BObject getbObject() {
		return bObject;
	}
	public void setbObject(BObject bObject) {
		this.bObject = bObject;
	}
	public BObject getcObject() {
		return cObject;
	}
	public void setcObject(BObject cObject) {
		this.cObject = cObject;
	}
	public BObject getdObject() {
		return dObject;
	}
	public void setdObject(BObject dObject) {
		this.dObject = dObject;
	}
	private boolean isA = true;
	private boolean isB = false;
	private boolean isC = false;

	private BObject aObject = new BObject();
	private BObject bObject = new BObject();
	private BObject cObject = new BObject();
	private BObject dObject = new BObject();

}

class BObject implements Serializable {

	private static final long serialVersionUID = 5288024953058909344L;

}
