package Functions;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class countdown{
	public static void main( String[] args )
	  {
	    TimerTask timer = new TimerTask(){
	    	public void run(){}
	    };
	    
	   	Timer t = new Timer();
	    Random rand = new Random();
	    long x = 0;
	    long y = 0;
	    x = rand.nextLong();
	    y = rand.nextLong();

	    if(x >= 5000 && x <= 900000){
	    	//Start in x Sekunden dann Ablauf alle y Sekunden
		    t.schedule(timer,x, y);
	    }
	  }

}
