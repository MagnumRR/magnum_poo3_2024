package Exemplo01;

public class MyRunnable implements Runnable{

	public void run() {
		for (int i = 0;i<5;i++) {
			System.out.println(Thread.currentThread().getName()+" - ordem: "+i);
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main (String[] args) {
		MyRunnable myRunnable = new MyRunnable();
		Thread th01 = new Thread(myRunnable);
		Thread th02 = new Thread(myRunnable);
	
		th01.start();
		th02.start();
	}
	
	
	
	
}
