package Section9_1;

abstract class Person{
	private String name;
	private int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
    
	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public abstract String print();
}

class Teacher extends Person{
	public Teacher(String name, int age)
	{
		super(name,age);
	}
	
	public String print(){
		return "��ʦ����������"+super.getName()+" ����:"+super.getAge()+" ְҵ:Teacher" ;
	};
}

class Worker extends Person{
	public Worker(String name, int age)
	{
		super(name,age);
	}
	
	public String print(){
		return "���ˡ���������"+super.getName()+" ����:"+super.getAge()+" ְҵ:Worker" ;
	};
}



public class section9_1 {

	public static void main(String[] args) {
		Teacher a=new Teacher("����",50);
		Worker b=new Worker("����",30);
		
		System.out.println(a.print());
		System.out.println(b.print());

	}

}
