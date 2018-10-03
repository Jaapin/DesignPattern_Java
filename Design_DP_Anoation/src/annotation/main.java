package annotation;
import java.awt.List;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import bean.User;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Import Excel start");
		
		ArrayList<User> list = new ArrayList<User>();
		
		for (int i = 0; i < 100; i++) {
			User user0 = new User();
			user0.setName("小米"+i);
			user0.setAge(i+"");
			user0.setDate(new Date());
			user0.setMoney(new BigDecimal(Math.round(Math.random()*100+200)));
			list.add(user0);
		}
	
		
		ExcelDataFormatter edf = new ExcelDataFormatter();
		new ExcelUtils<User>(new User()).writeToFiles(list, edf, "D:\\11.xlsx");
		System.out.println("Import Excel end");
	}

}

