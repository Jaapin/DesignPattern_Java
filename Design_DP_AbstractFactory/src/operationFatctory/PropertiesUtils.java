package operationFatctory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
	
	public static String getValue(String key){
		Properties properties = new Properties();
		InputStream in = PropertiesUtils.class.getClassLoader().getResourceAsStream("config.properties");
		// 使用properties对象加载输入流
		try {
			properties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //获取key对应的value值
		
		return properties.getProperty(key);
	}
}
