package org.javacore.io;

import java.io.File;
import java.io.FilenameFilter;
/**
 * <p>
 *	 <pre>
 * 		类名过滤器的使用
 * 	</pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-2 14:30
 */
public class FilenameFilterT {

	public static void main(String[] args) {
		// IO包路径
		String dir = "/Users/Dev/github/java-core-learning-example/src/main/java/org/javacore/io/";
		File file = new File(dir);
		// 创建过滤器文件
		MyFilter filter = new MyFilter("y.java");
		// 过滤
		String files[] = file.list(filter);
		
		// 打印
		for (String name : files) {
			System.out.println(name);
		}
	}
	
	/**
	 *	内部类实现过滤器文件接口
	 */
	static class MyFilter implements FilenameFilter {
		
		private String type;
		
		public MyFilter (String type) {
			this.type = type;
		}

		@Override
		public boolean accept(File dir, String name) {
			return name.endsWith(type);// 以Type结尾
		}
		
	}
}
