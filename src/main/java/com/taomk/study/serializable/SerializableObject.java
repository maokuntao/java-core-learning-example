/**
 * 
 */
package com.taomk.study.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * serializable
 * 
 * <i>https://www.cnblogs.com/szlbm/p/5504166.html</i>
 * 
 * @author taomaokun
 *
 */
public class SerializableObject implements Serializable {

	/**
	 * default serialize number
	 */
	private static final long serialVersionUID = 1L;

	private String commonStr;
	private transient String transientStr;
	private static String staticStr = "test";

	public SerializableObject(String commonStr, String transientStr) {
		super();
		this.commonStr = commonStr;
		this.transientStr = transientStr;
	}

	public String getCommonStr() {
		return commonStr;
	}

	public String getTransientStr() {
		return transientStr;
	}

	public static String getStaticStr() {
		return staticStr;
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		// 序列化过程
		File outputFile = new File("serializableObject.bin");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile));
		oos.writeObject(new SerializableObject("commonStr", "transientStr"));
		oos.close();

		// 反序列化过程
		InputStream is = new FileInputStream(outputFile);
		ObjectInputStream ois = new ObjectInputStream(is);
		SerializableObject deSerializableObj = (SerializableObject) ois.readObject();
		System.out.println(deSerializableObj.getCommonStr());
		System.out.println(deSerializableObj.getTransientStr());
		System.out.println(deSerializableObj.staticStr);

		ois.close();

	}
}
