package com.poc;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ReverseCoverter {

	List<Employee> list = null;

	public ReverseCoverter(List<Employee> list) {
		super();
		this.list = list;
	}

	void mask() {
		try {

			ExecutorService asd = Executors.newFixedThreadPool(30);
			int i = 0;
			while (i < list.size()) {
				asd.submit(new InsertReverseKey(list.get(i)));
				i++;
			}
			// asd.shutdown();
			// while(!asd.isShutdown()) {
			// SQLNet message from Client Wait Events are seen. Hence commenting it.
			// Thread.currentThread().sleep(1000);
			// }
			asd.shutdown();
			try {
				asd.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} catch (Exception E) {
			E.printStackTrace();
		}

	}
}

class InsertReverseKey implements Runnable {
	Employee emp = null;

	public void run() {
		try {
			StringBuilder sb = new StringBuilder(emp.getName());
			emp.setName(sb.reverse().toString());

		} catch (Exception E) {
			E.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " Completed.");
	}

	public InsertReverseKey(Employee emp) {
		super();
		this.emp = emp;
	}

}
