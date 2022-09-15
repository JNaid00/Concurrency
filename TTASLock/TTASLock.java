import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class TTASLock implements Lock{

	private AtomicBoolean state = new AtomicBoolean(false);
	private volatile int count = 0;
	@Override
	public void lock() {
		while (true) {
			while (state.get()) {}
			if (state.getAndSet(true) == false){
				return;
			}
		}
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean tryLock() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void unlock() {
		// TODO Auto-generated method stub
		state.set(false);
		count++;
	}	

	@Override
	public Condition newCondition() {
		// TODO Auto-generated method stub
		return null;
	}
	public int getCount(){
		return count;
	}
}
