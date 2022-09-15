
public class MyThread extends Thread {
	private Scrumboard obj;
	private PertersonLock lock;
	private Thread t = null;
	private String name;
	public MyThread(Scrumboard a,PertersonLock lock , String name) {
		this.obj = a;
		this.lock = lock;
		this.name = name;
		// setName(name);
	}

	public MyThread(Scrumboard s, String string) {
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			lock.lock();
			try {

				String next = obj.getNext();
				System.out.println(this.getName() + " Task: " + next);
				obj.addComplete(next);
			} finally {
				lock.unlock();
			}
		}
	}

	public void start() {
		if (t == null){
			t = new Thread(this, name);
			t.run();
		}
	}

}
