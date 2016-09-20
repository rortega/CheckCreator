
public class LambdaMain {

	
	public static void main(String args[]){
		
		Runnable task = () ->{
			System.out.println("Hello " + Thread.currentThread().getName());
			
		};
		Thread thread = new Thread(task);
		task.run();
		thread.start();
		
		
		
	}
	
	
}
