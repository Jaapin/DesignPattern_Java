package com.dp.dynamicProxy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Properties;
import java.lang.reflect.Constructor;
import java.lang.Class;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import com.dp.dynamicProxy.Speaker;

public class Proxy {

	/**
	 * 官方提供的方法
	 * 
	 * @param loader
	 * @param interfaces
	 * @return
	 */
	public static Object newInstanceProxy(ClassLoader loader, Class interfaces) {

		return null;

	}

	/**
	 * 自己實現
	 * 
	 * @return
	 * @throws Exception 
	 */
	public static Object newSpeakerInstanceProxy() throws Exception {
		System.out.println("[0]:start");

		String rn = "\r\n";
		String source = "package com.dp.dynamicProxy;"
				+ rn
				+

				"public class SpeakerTimeProxy implements Speaker {"
				+ rn
				+

				"	Speaker speaker;"
				+ rn
				+

				"	public SpeakerTimeProxy(Speaker sp) {"
				+ rn
				+ "		super();"	
				+ rn
				+ "		this.speaker = sp;"
				+ rn
				+ "	}"
				+ rn
				+

				"	public void speak() {"
				+ rn
				+ "		long start = System.currentTimeMillis();"
				+ rn
				+

				"		speaker.speak();"
				+ rn
				+

				"		long end = System.currentTimeMillis();"
				+ rn
				+ "		System.out.println(\"speakMathod: costTime:\" + (end - start));"
				+ rn + "	}" + rn +

				"}";
		
		String fileName = System.getProperty("user.dir")
				+ "\\src\\com\\dp\\dynamicProxy\\SpeakerTimeProxy.java";
		File srcFile = new File(fileName);
		FileWriter fWriter = null;
		try {
			fWriter = new FileWriter(srcFile);
			fWriter.write(source);
			fWriter.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fWriter != null) {
				try {
					fWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				fWriter = null;
			}
		}

		System.out.println("[1]:create Proxy Java file finsh!");

		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(
				null, null, null);

		Iterable<? extends JavaFileObject> compilationUnits1 = fileManager
				.getJavaFileObjectsFromFiles(Arrays.asList(srcFile));
		compiler.getTask(null, fileManager, null, null, null, compilationUnits1)
				.call();

		Iterable<? extends JavaFileObject> compilationUnits2 = fileManager
				.getJavaFileObjects(srcFile); // use alternative method
		// reuse the same file manager to allow caching of jar files
		compiler.getTask(null, fileManager, null, null, null, compilationUnits2)
				.call();

		try {
			fileManager.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("[2]:create Proxy Class file finsh!");
		
		URL[] urls = new URL[] { new URL("file:/" + System.getProperty("user.dir") + "/src") };
		URLClassLoader loader = new URLClassLoader(urls);
		Class clazz = loader.loadClass("com.dp.dynamicProxy.SpeakerTimeProxy");
		
		System.out.println("[3]:load Class ["+clazz+"] to memory finsh!");
		
		Constructor constructor = clazz.getDeclaredConstructor(Speaker.class);
		
		Object object =constructor.newInstance(new MicPhone());
		
		System.out.println("[4]:create Proxy Object finsh!");
		
		System.out.println("[5]:end");
		
		return object;

	}

}
