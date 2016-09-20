import java.util.concurrent.Executor;


public class MainClass implements Executor{

	
	
	int[][] anArray = new int[1][];
	
	int[] elementOne = {1,2,3,4,5};
	
	
	
	
	
	public static void main(String[] args){
		
		
		
		System.out.println("hello");
		new MainClass().test();
	
		
		MainClass anExecutor = new MainClass();
		
		Executor executor = anExecutor;
		executor.execute(new MyRunnable());
		
		
		
		
	}
	
	public void test(){
		
		anArray[0] = elementOne;
		System.out.println(anArray);
	}

	@Override
	public void execute(Runnable arg0) {
		// TODO Auto-generated method stub
		
		System.out.println("Im being executed");
		new Thread(arg0).start();
		
		
	}
	
	
}
