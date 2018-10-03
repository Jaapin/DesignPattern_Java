
public class AbstractFactory {
	public Car createCar() {
		return new Car();
	}
	
	public AK47 createAk47(){
		return new AK47();
	}
}
