
public class Person {
	
	private String mName;
	
	public Person (String name){
		this.mName = name;
	}
	
	public String drive(String des) {
		String resString = mName+"¿ª³µÈ¥"+des;
		System.out.println(resString);
		return resString;
	}
	
}
