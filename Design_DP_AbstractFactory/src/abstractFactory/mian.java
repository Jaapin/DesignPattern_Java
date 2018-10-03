package abstractFactory;



public class mian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*DefaultFactory f = new DefaultFactory();
		f.createAk47().shot();
		f.createCar().run();*/
		
		
		/*MagicFactory f = new MagicFactory();
		f.createAple().getName();
		f.createBoom().boom();*/
		
		
		DefaultFactory f = new DefaultFactory();
		Apple apple = (Apple)f.createFood();
		apple.getName();
		
	
		
		AK47 ak47 = (AK47)f.createWeaPon();
		ak47.shot();
		
		
		
	}

}
