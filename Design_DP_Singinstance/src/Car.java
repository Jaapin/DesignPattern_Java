public class Car {

	// ----------------------懒汉---------------------------------------//

	/*
	 * private static Car instance = new Car();
	 * 
	 * private Car () {
	 * 
	 * }
	 * 
	 * public static Car getInstance() { return instance; }
	 */

	// -------------------------static-------------------------------------//
	/*
	 * private static Car instance = null;
	 * 
	 * static{ instance = new Car(); }
	 * 
	 * private Car() {
	 * 
	 * }
	 * 
	 * public static Car getInstance() { return instance; }
	 */

	// --------------------------InstanceHolder-------------------------------------//
	// 延后加载时机

	/*
	 * private Car (){
	 * 
	 * }
	 * 
	 * private static class InstanceHolder { private static final Car instance =
	 * new Car(); }
	 * 
	 * public static Car getInstance() { return InstanceHolder.instance; }
	 */

	// -----------------------------单重锁-------------------------------------------//

	private static Car instance = null;
	private static int count = 0;

	private Car() {
		System.out.println("Singleton construtor " + (++count) +" times");
	}

	public static Car getInstance() {
		if (instance == null) {
			instance = new Car();
		}
		return instance;
	}

	// -----------------------------synchronized-------------------------------------------------//

	/*
	 * private static Car instance = null; private static int count;
	 * 
	 * private Car() { System.out.println("Singleton construtor " + (++count) +
	 * " times"); }
	 * 
	 * public synchronized static Car getInstance() { if (instance == null) {
	 * instance = new Car(); } return instance; }
	 */

	// ---------------------------------双重校验锁---------------------------------------------//

	/*
	 * private static Car instance = null; private static int count;
	 * 
	 * private Car() { System.out.println("Singleton construtor " + (++count) +
	 * " times"); }
	 * 
	 * public static Car getInstance() { if (instance == null) { synchronized
	 * (Car.class) { if (instance == null) { instance = new Car(); } } } return
	 * instance; }
	 */

}
