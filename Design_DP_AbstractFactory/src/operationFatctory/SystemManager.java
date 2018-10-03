package operationFatctory;

public class SystemManager {
	
/*	private IFactory getFactory(){
		String type = PropertiesUtils.getValue("productName");
		IFactory factory;
		if(type.equals("android")){
			factory = new AndroidFactory();
		}else if(type.equals("ios")){
			factory = new IosFactory();
		}else {
			factory = new AndroidFactory();
		}
		return factory;
	}
	
	public void getCpuInfo() {
		getFactory().getSystemInterface().getCpuInfo();
	}*/
	
	
	private SystemInterface getSystemInterFace(){
		String type = PropertiesUtils.getValue("productName");
		if(type.equals("android")){
			return new AndroidSystem();
		}else {
			return new IoSystem();
		}
	}
	
	public void getCpuInfo() {
		getSystemInterFace().getCpuInfo();
	}
}
