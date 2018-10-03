package abstractFactory;

/**
 * 弊端：
 * 产生新的产品的品种的时候，太麻烦，所有接口都需要实现一遍
 * @author Administrator
 *
 */
public abstract class AbstractFactory {
	public abstract Food createFood();

	public abstract Weapon createWeaPon();

	public abstract Viechele createViechele();
}
