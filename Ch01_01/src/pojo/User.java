package pojo;

public class User {
	private int id;
	private String name;
	private int age;
	private int temp;
	public User(int id,String name,int age)
	{
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public String toString()
	{
		return "User[Ñ§ºÅ£º"+id+",ĞÕÃû:"+name+",ÄêÁä£º"+age+"]";
	}
	
	
	
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	

}
