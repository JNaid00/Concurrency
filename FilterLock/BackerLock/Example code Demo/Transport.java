public class Transport extends Thread {
    private Venue destination;
	private Thread t = null;

	public Transport(Venue dest){
		destination = dest;
	}

	@Override
	public void run()
	{
		String name = Thread.currentThread().getName();
		for (int i = 0; i < 5; i++) {
			destination.dropOff(name,i);
		}
	}

	public void start(){
		if (t == null){
			t = new Thread(this, getName());
			t.start();
		}
	}
}
