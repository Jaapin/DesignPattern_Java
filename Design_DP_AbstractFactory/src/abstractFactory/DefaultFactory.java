package abstractFactory;



public class DefaultFactory extends AbstractFactory{
	/*public Car createCar() {
		return new Car();
	}
	
	public AK47 createAk47(){
		return new AK47();
	}*/

	@Override
	public Food createFood() {
		// TODO Auto-generated method stub
		return new Apple();
	}

	@Override
	public Weapon createWeaPon() {
		// TODO Auto-generated method stub
		return new AK47();
	}

	@Override
	public Viechele createViechele() {
		// TODO Auto-generated method stub
		return new Car();
	}
}
