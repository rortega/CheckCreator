package TestTimingProfile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TimeTest {
	
	
	
	
	
	
	public static void timeContains(Collection<Integer> integers, int collectionSize){
		
		
		for(int i = 0; i < collectionSize; i++){
			
			integers.add(i);
		}
		
		long startTime = System.currentTimeMillis();
		
		for(int i = 0; i < collectionSize ; i++) {
			
			integers.contains(i);
			
			
		}
		
		long totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Total time for" + collectionSize + " elements:" + totalTime);
		
	}
	
	
	
	
	
  public static void main(String a[]){
	  
	  
	  

	  TimeTest.timeContains(new HashSet(),   500000);
	  TimeTest.timeContains(new ArrayList(), 500000);
	  
	  
  }
	
	
	
	
	

}
