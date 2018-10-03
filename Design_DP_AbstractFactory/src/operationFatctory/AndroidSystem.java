package operationFatctory;

public class AndroidSystem implements SystemInterface{

	@Override
	public void getCpuInfo() {
		System.out.println("Android:getCpuInfo");
	}

}
