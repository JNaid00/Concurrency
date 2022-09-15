public class Main {
	public static void main(String[] args) {
		Scrumboard s = new Scrumboard();
		PertersonLock lock = new PertersonLock();
		Thread t1 = new MyThread(s,lock, "0");
		Thread t2 = new MyThread(s,lock, "1");
		t1.start();
		t2.start();
		
		// while (s.getTodo().size() > 0){
		// 	System.out.print("");
		// }	

		// System.out.println("Contents of Completed: " + s.getCompleted());
	}
}
