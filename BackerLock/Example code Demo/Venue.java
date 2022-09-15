import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;

public class Venue {
    Lock lock;

	public Venue(){
		lock = new Bakery(5);
	}
	public void dropOff(String name, int i){
		lock.lock();
		int time = ThreadLocalRandom.current().nextInt(200, 1000);
		try {
			Thread.sleep(time);
			System.out.println("BUS " + name + " is dropping off: LOAD " + i);
			
		}
		catch(Exception e){

		}
		finally {
			lock.unlock();
			System.out.println("BUS " + name + " has left: LOAD " + i);
		}
		
	}
}
