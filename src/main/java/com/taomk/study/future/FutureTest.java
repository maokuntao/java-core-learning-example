/**
 * 
 */
package com.taomk.study.future;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.google.common.collect.Lists;

/**
 * @author taomaokun
 *
 */
public class FutureTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int loopCount = 10;
		int maxNum = 1000 * 1000 * 10;
		ArrayList<BigInteger> resultList = Lists.newArrayListWithCapacity(loopCount);
		ArrayList<Future<BigInteger>> resultFutureList = Lists.newArrayListWithCapacity(loopCount);
		ExecutorService executorService = Executors.newCachedThreadPool();

		// 普通串行方式执行
		long startMillis0 = System.currentTimeMillis();
		for (int i = 0; i < loopCount; i++) {
			resultList.add(Calc.sum(maxNum));
		}
		for (int i = 0; i < loopCount; i++) {
			System.out.println("result item " + i + ":" + resultList.get(i));
		}
		long startMillis1 = System.currentTimeMillis();
		System.out.println("common loop, costMillis:" + (startMillis1 - startMillis0));

		// Future模式执行
		for (int i = 0; i < loopCount; i++) {
			resultFutureList.add(executorService.submit(new Calc(maxNum)));
		}
		for (int i = 0; i < loopCount; i++) {
			System.out.println("result item " + i + ":" + resultFutureList.get(i).get());
		}
		long startMillis2 = System.currentTimeMillis();
		System.out.println("future model, costMillis:" + (startMillis2 - startMillis1));

		System.exit(1);
	}

	public static class Calc implements Callable<BigInteger> {

		int num;

		Calc(int maxNum) {
			this.num = maxNum;
		}

		public static BigInteger sum(int num) {
			BigInteger sum = new BigInteger("0");
			for (int i = 0; i <= num; i++) {
				sum = sum.add(new BigInteger(i + ""));
			}
			return sum;
		}

		@Override
		public BigInteger call() {
			return sum(num);

		}
	}
}
