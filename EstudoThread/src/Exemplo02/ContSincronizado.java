package Exemplo02;

public class ContSincronizado {
	private int cont;
	
	public ContSincronizado() {
		this.cont = 0;
	}
	
	public synchronized void increment () {
		cont++;
	}
	
	public synchronized int getCont() {
		return cont;
	}
	
	public static void main (String[] args) {
		ContSincronizado con = new ContSincronizado();
		Thread th01 = new Thread(()->{
			for (int i = 0;i < 5;i++) {
				con.increment();
				System.out.println(Thread.currentThread().getName()+" - ordem:"+con.getCont());
				try {
					Thread.sleep(2000);
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread th02 = new Thread(()->{
			for (int i = 0;i < 5;i++) {
				con.increment();
				System.out.println(Thread.currentThread().getName()+" - ordem:"+con.getCont());
				try {
					Thread.sleep(2000);
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		th01.start();
		th02.start();
	}

}
