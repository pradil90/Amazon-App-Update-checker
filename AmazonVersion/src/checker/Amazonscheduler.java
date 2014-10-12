package checker;


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Amazonscheduler {
	Timer timer;
 
	public Amazonscheduler(int seconds) {
		Date date=new Date();
		final Date datefinal=date;
		timer = new Timer();
		timer.schedule(new Amazonreminder(),datefinal, seconds * 1000);

	}
 
	class Amazonreminder extends TimerTask {
		public void run() {
			Date date1=new Date();
			System.out.format("Task triggered at" + date1 +"..!%n");
			Amazon.tasker();
			Date date2=new Date();
			System.out.format("Timer Task Finished at" + date2 +"..!%n");
//			timer.cancel(); // Terminate the timer thread
		}
	}
 
	public static void main(String args[]) {
		new Amazonscheduler(180);
		System.out.format("Task scheduled....Monitoring set to every 3 minutes%n");
	}
}