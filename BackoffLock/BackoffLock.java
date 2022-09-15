import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class BackoffLock implements Lock {

	private AtomicBoolean state = new AtomicBoolean(false);
	private static final int MIN_DELAY = 1;
	private static final int MAX_DELAY = 100;
	private volatile int count = 0;
	@Override
	public void lock() {
		long W = MIN_DELAY;
		while (true) {
			while (state.get())
				Thread.yield();
			if (!state.getAndSet(true))
				return;
			long w = (long) (Math.random() * (MAX_DELAY - MIN_DELAY) + MIN_DELAY);
			W = Math.min(2 * W, MAX_DELAY);
			try {
				Thread.sleep(w);
			} 
			catch (InterruptedException e) {
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
