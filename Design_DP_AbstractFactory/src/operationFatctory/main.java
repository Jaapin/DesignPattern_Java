package operationFatctory;

/**
 * 需求:对上层调用者提供统一的调用接口： 底层根据不同的配置文件调用不同的实现。
 * 
 * @author Administrator
 * 
 */
public class main {

	public static void main(String[] args) {
		
		SystemApi.getCpuInfo();
		DisplayApi.getScreenDir();
		DisplayApi.setDisplayMode();
	}

}
