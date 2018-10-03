package operationFatctory;

public class DisplayManager {

	private IFactory getFactory() {
		String type = PropertiesUtils.getValue("productName");
		IFactory factory;
		if (type.equals("android")) {
			factory = new AndroidFactory();
		} else if (type.equals("ios")) {
			factory = new IosFactory();
		} else {
			factory = new AndroidFactory();
		}
		return factory;
	}

	// 不区分的接口
	public int getScreenDir() {
		return new DisplayImpl().getScreenDir();
	}

	public void setDisplayMode() {
		getFactory().getDisplayInterface().setDisplayMode();
	}

}
