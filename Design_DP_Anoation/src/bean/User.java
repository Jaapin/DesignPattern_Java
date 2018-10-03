package bean;

import java.math.BigDecimal;
import java.util.Date;

import annotation.Excel;

public class User {

	@Excel(name = "姓名", width = 20)
	private String name;

	@Excel(name = "年龄", width = 30)
	private String age;

	@Excel(skip = true)
	private String password;

	@Excel(name = "yy")
	private Date date;

	@Excel(name = "金额")
	private BigDecimal money;

	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getAge() {
		return age;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	
	public BigDecimal getMoney() {
		return money;
	}
}