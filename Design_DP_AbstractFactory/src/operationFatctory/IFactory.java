package operationFatctory;


//如果类别比较多，但是稳定可以采用抽象工厂
//如果工厂类别少，采用简单工厂
public interface IFactory {
	public SystemInterface getSystemInterface();
	public DisplayInterface getDisplayInterface();
}
