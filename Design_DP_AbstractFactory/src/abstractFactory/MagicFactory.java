package abstractFactory;

public class MagicFactory {
	public Boom createBoom() {
		return new Boom();
	}
	
	public Apple createAple(){
		return new Apple();
	}
}
