public class main {

	public static void main(String[] args) {

		// Car car1 = Car.getInstance();
		/*
		 * Car car2 = Car.getInstance(); if(car1.equals(car2)){
		 * System.out.println("is the same car!"); }
		 */

		/*Runnable taskRunnable = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				String threadName = Thread.currentThread().getName();
				Car car1 = Car.getInstance();
				//System.out.println("threadName: " + threadName + "\t => "
				//		+ car1.hashCode());
			}
		};

		for (int i = 0; i < 3000; i++) {
			new Thread(taskRunnable, "" + i).start();
		}*/
		
		

		
		for (int i = 0; i < 2000; i++) {
			//是为了现象更明显
			System.gc();
			new Thread(new Runnable() {

				@Override
				public void run() {
					Car car1 = Car.getInstance();
					//System.out.println("car:" + car1.hashCode());
				}
			}).start();
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
