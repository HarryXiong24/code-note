
public class Person {
	private String name;
	private int age;
	private String like;
	
	public Person(String name,int age,String like)
	{
		this.name=name;
		this.age=age;
		this.like=like;
	}
	
	public void show()
	{
		System.out.println("����:"+this.name+"����:"+this.age+"����:"+this.like);
	}
	
	public static void main(String[] args) {
		Person person=new Person("С��",18,"����");
		person.show();
	}

	
}


