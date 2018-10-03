package operationFatctory;

public class IosFactory implements IFactory {

	@Override
	public SystemInterface getSystemInterface() {
		// TODO Auto-generated method stub
		return new IoSystem();
	}

	@Override
	public DisplayInterface getDisplayInterface() {
		// TODO Auto-generated method stub
		return null;
	}

}
