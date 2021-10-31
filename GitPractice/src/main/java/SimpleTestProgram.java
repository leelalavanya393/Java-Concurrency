import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleTestProgram {

	public static void main(String[] args) {

		try {
//			ExecutorService service = Executors.newFixedThreadPool(10);
			ExecutorService service = Executors.newCachedThreadPool();
			
			for(int i=0; i<100; i++) {
				service.execute(new Task());
			}
			System.out.println("Main Thread1: "+Thread.currentThread().getName());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	static class Task implements Runnable{

		public void run() {
			System.out.println("Current Thread: "+Thread.currentThread().getName());
			
		}
		
	}
}
