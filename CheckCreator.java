import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;



public class CheckCreator {

	         //[Number of Checks] [start position] [routing number] [account number]");
	
	private int numberOfChecks = 10;
	private int startPos = 100;
	private int routingNum = 314088637;
	private int accountNum = 18931707;
	
	public static void main(String[] args){	
		printUsage();
		CheckCreator p = new CheckCreator();
		p.initArgs(args);
		p.printChecks();
	}
	private void printChecks(){	
		
		        File path = new File(".\\");
				BufferedImage image;				
				try {
			    image = ImageIO.read(new File(path, "SampleCheck.png"));
				BufferedImage micrText = ImageIO.read(new File(path, "MICR.png"));	
				BufferedImage combined = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);

				Graphics g = combined.getGraphics();
				g.drawImage(image, 0, 0, null);
					
				 putNumberOnGraphics( micrText, g, Integer.toString(routingNum), 73 );
				 putNumberOnGraphics( micrText, g, Integer.toString(accountNum), 312 );
	
			   for(int i = startPos;i < (startPos +numberOfChecks); i++ ){
				String checkNumber = String.valueOf(i);
				putNumberOnGraphics( micrText, g, checkNumber, 627 );//checkNumber
				File outputPath = new File (".\\");
				ImageIO.write(combined, "PNG", new File(outputPath, checkNumber + ".png"));
				System.out.println("Check number "+Integer.toString(i)+" was created at location " + outputPath.getAbsolutePath()+ checkNumber+".png" );
			  
			   }
			    
				} 
				catch(javax.imageio.IIOException e){
					System.out.println("Please make sure the file SampleCheck.png and MICR.png are in the location as the .jar file");
					
					System.out.println(e.toString() + "\n\r");
					this.printUsage();
					
				}
				catch (Exception e) {
					System.out.println(e.toString());
				}
		
	}
	public void putNumberOnGraphics(BufferedImage micrText, Graphics g, String number, int yPos ){		
		int[] location = {0,23,50,75,97,118,149,169,192,218};
		for(int i = 0; i < number.length() ; i ++){	
			int sum = 24*i;	
			int value = Integer.parseInt(number.substring(i, i+1));
			g.drawImage(micrText.getSubimage(location[value], 0, 20, 24), yPos+sum, 447, null);
			}	 	
	}
	private void initArgs(String[] args){
		//[Number of Checks] [start position] [routing number] [account number]");	
		try{
		     if(args.length >= 1){
		    	 this.numberOfChecks = Integer.parseInt(args[0]);
		     }
		     if(args.length >= 2){
		    	 this.startPos = Integer.parseInt(args[1]);
		     }
		     if(args.length >= 3){
		    	 this.routingNum = Integer.parseInt(args[2]);
		     }
		     if(args.length >= 4){
		    	 this.accountNum = Integer.parseInt(args[3]);
		     }
		}catch(Exception e){
			printUsage();	
		}
	}
	private static void printUsage() {
		System.err.println("Check Creator");
		System.err.println("Usage: java -jar CheckCreator.jar [Number of Checks] [start position] [routing number] [account number]");
		
	}
}
