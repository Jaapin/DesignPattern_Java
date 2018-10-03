package operationFatctory;

//这里可以有更多的接口实现
public class AndroidService implements DisplayInterface {

	@Override
	public int getScreenDir() {
		return 0;
	}

	@Override
	public void setDisplayMode() {
		System.out.println("android:setDisplayMode");
	}

}
