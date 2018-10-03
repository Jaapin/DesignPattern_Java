package operationFatctory;

public class AndroidFactory implements IFactory {

	@Override
	public SystemInterface getSystemInterface() {
		// TODO Auto-generated method stub
		return new AndroidSystem();
	}

	@Override
	public DisplayInterface getDisplayInterface() {
		// TODO Auto-generated method stub
		return new AndroidService();
	}

}
