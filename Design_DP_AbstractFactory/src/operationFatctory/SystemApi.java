package operationFatctory;

public class SystemApi {

	private static SystemManager systemManager = new SystemManager();
	
	public static void getCpuInfo() {
		systemManager.getCpuInfo();
	}
}
