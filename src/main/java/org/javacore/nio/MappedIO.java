package org.javacore.nio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

/**
 * <p>
 * 
 * <pre>
 * MappedByteBuffer与Old IO的性能对比
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-3 10:25
 */
public class MappedIO {

	private static int numOfInts = 4 * 1000 * 1000;
	private static int numOfUbuffInts = 200 * 1000;

	static String targetFile = "/Users/Dev/github/java-core-learning-example/src/main/resources/io/file/copy/channel/data5.txt";

	private abstract static class Tester {
		private String name;

		public Tester(String name) {
			this.name = name;
		}

		// 打印测试时间
		public void runTests() {
			System.out.print(name + ": ");
			try {
				long start = System.nanoTime();
				test();
				double duration = System.nanoTime() - start;
				System.out.format("%.2f\n", duration / 1.0e9);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public abstract void test() throws IOException;
	}

	private static Tester[] tests = {

			// 传统IO流写入数据
			new Tester("Stream Write") {
				@Override
				public void test() throws IOException {
					DataOutputStream dos = new DataOutputStream(
							new BufferedOutputStream(new FileOutputStream(new File(targetFile))));
					for (int i = 0; i < numOfInts; i++)
						dos.writeInt(i);
					dos.close();
				}
			},

			// Mapper方式写入
			new Tester("Mapped Write") {
				@SuppressWarnings("resource")
				@Override
				public void test() throws IOException {
					FileChannel fc = new RandomAccessFile(targetFile, "rw").getChannel();
					IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
					for (int i = 0; i < numOfInts; i++)
						ib.put(i);
					fc.close();
				}
			},
			// 传统IO流读取
			new Tester("Stream Read") {
				@Override
				public void test() throws IOException {
					DataInputStream dis = new DataInputStream(
							new BufferedInputStream(new FileInputStream(new File(targetFile))));
					for (int i = 0; i < numOfInts; i++)
						dis.readInt();
					dis.close();
				}
			},
			// Mappd方式读取
			new Tester("Mapped Read") {
				@SuppressWarnings("resource")
				@Override
				public void test() throws IOException {
					FileChannel fc = new FileInputStream(new File(targetFile)).getChannel();
					IntBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()).asIntBuffer();
					while (ib.hasRemaining())
						ib.get();
					fc.close();
				}
			},
			// 传统IO流读写
			new Tester("Stream Read/Write") {
				@Override
				public void test() throws IOException {
					RandomAccessFile raf = new RandomAccessFile(new File(targetFile), "rw");
					raf.writeInt(1);
					for (int i = 0; i < numOfUbuffInts; i++) {
						raf.seek(raf.length() - 4);
						raf.writeInt(raf.readInt());
					}
					raf.close();
				}
			},
			// Mapped方式读写
			new Tester("Mapped Read/Write") {
				@SuppressWarnings("resource")
				@Override
				public void test() throws IOException {
					FileChannel fc = new RandomAccessFile(new File(targetFile), "rw").getChannel();
					IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
					ib.put(0);
					for (int i = 1; i < numOfUbuffInts; i++)
						ib.put(ib.get(i - 1));
					fc.close();
				}
			} };

	public static void main(String[] args) {
		for (Tester tester : tests)
			tester.runTests();
	}
}
