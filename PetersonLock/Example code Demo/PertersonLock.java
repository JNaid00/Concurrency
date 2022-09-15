import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class PertersonLock implements Lock {
	private volatile boolean[] flag = new boolean[2];
	private volatile int victim;

	@Override
	public void lock() {
		int i = Integer.parseInt(Thread.currentThread().getName());
		int j = 1 - i;
		flag[i] = true;
		victim = i;
		// System.out.println(flag[j]);
		while (flag[j] && victim == i) {}
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		
		// TODO Auto-generated method stub
	}

	@Override
	public boolean tryLock() {
		return false;
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void unlock() {
		int i = Integer.parseInt(Thread.currentThread().getName());
		flag[i] = false;
	}

	@Override
	public Condition newCondition() {
		// TODO Auto-generated method stub
		return null;
	}

}
