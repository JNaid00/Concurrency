import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

// Name: Jesse Naidoo
// Student Number: u21433102

public class Bakery implements Lock
{
	private volatile boolean [] flag;
	private volatile int [] label;
	public Bakery(int n){
		this.flag = new boolean[n];
		this.label = new int[n];
		for (int i = 0; i < flag.length; i++) {
			flag[i] = false;
			this.label[i] = 0;
		}
	}
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

	@Override
	public void lock() {
		String name = Thread.currentThread().getName();
		name = name.replaceAll("\\D", "");
		int i = Integer.parseInt(name);
		this.flag[i] = true;
		this.label[i] = max() + 1;
		for (int k = 0; k < this.label.length; k++) {
            while ((k != i) && flag[k] && ((label[k] < label[i]) || ((label[k] == label[i]) && k < i))) {
            }
        }

	}

	
	private int max() {
		int max = -1;
		for (int i = 0; i < label.length; i++) {
			if (max < label[i]){
				max = label[i];
			}
		}
		return max;
	}
	@Override
	public void unlock() {
		String name = Thread.currentThread().getName();
		name = name.replaceAll("\\D", "");
		int i = Integer.parseInt(name);
		this.flag[i] = false;
		
	}

}
