package Functions;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import Interface.Phraseface;

public class Countdown{
	
	public static void CountdownGo()
	  {

		    Random rand = new Random();
		    long x = 20;

		    //MIN = 5000        MAX = 9000000
//		    x = rand.nextInt(8950000) + 5000;

			
		  do{
	    	    System.out.print("\n x= " + x);
		    	x--;
			    if(x==0)
			    {
			    	Phraseface pf = new Phraseface();
			    	pf.createFace();		    	
			    	break;
			    }
			    
			}while(true);
	  }

}
