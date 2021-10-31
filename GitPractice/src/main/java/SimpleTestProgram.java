import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SimpleTestProgram {

	public static void main(String[] args) {

		try {
			int sum =0;
			ExecutorService service = Executors.newFixedThreadPool(10);
//			ExecutorService service = Executors.newCachedThreadPool();
			List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
			for(int i=0; i<10; i++) {
				Future<Integer> value = service.submit(new Task1());
				futureList.add(value);
			}
			
			for(Future<Integer> value: futureList) {
				sum = sum + value.get();
			}
			System.out.println("Total Sum: "+sum);
			System.out.println("Main Thread: "+Thread.currentThread().getName());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	static class Task implements Runnable{

		public void run() {
			System.out.println("Current Thread: "+Thread.currentThread().getName());
			
		}
	}
	
	static class Task1 implements Callable<Integer>{

		public Integer call() throws Exception {
			return new Random().nextInt();
		}

		
	}
	
}
