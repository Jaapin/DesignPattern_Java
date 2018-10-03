package operationFatctory;

public class DisplayApi {

	private static DisplayManager displayManager = new DisplayManager();

	public static int getScreenDir() {
		return displayManager.getScreenDir();
	}

	public static void setDisplayMode() {
		displayManager.setDisplayMode();
	}
}
