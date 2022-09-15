import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;


// Name:
// Student Number:

public class Filter implements Lock
{
	private volatile int [] level;
	private volatile int [] victim;

	public void lockInterruptibly() throws InterruptedException
	{
		throw new UnsupportedOperationException();
	}

	public boolean tryLock()
	{
		throw new UnsupportedOperationException();
	}

	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException
	{
		throw new UnsupportedOperationException();
	}

	public Condition newCondition()
	{
		throw new UnsupportedOperationException();
	}

	public Filter(int n) {
		this.level = new int[n];
		this.victim = new int[n];
		for (int i = 0; i < n; i++) {
			this.level[i] = 0;
		}
	}
	@Override
	public void lock() {
		String name = Thread.currentThread().getName();
		name = name.replaceAll("\\D", "");
		int me = Integer.parseInt(name);

		for (int i = 1; i < level.length; i++) {
			level[me] = i;
			victim[i] = me;
			for (int k = 0; k < this.level.length; k++) {
                while ((k != me) && (level[k] >= i && victim[i] == me)) {
                }
            }
		}
		
	}

	// private boolean kExist(int me, int i) {
	// 	for (int k = 0; k < level.length; k++) {
	// 		if (k != me && this.level[k] >= i){
	// 			return true;
	// 		}
	// 	}
	// 	return false;
	// }

	@Override
	public void unlock() {
		String name = Thread.currentThread().getName();
		name = name.replaceAll("\\D", "");
		int me = Integer.parseInt(name);
		this.level[me] = 0;
	}

}
