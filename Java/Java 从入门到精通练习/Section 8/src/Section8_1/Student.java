package Section8_1;
import Section8_1.Person;

public class Student extends Person
{
	double math;
	double english;
	public Student(String name, String addr, String sex, int age, double math, double english) {
		super(name, addr, sex, age);
		this.math = math;
		this.english = english;
	}

	public String talk() {                //��д�ķ������ͱ���һ��
		return "���ǣ�" + this.name + "�����꣺" +
		        this.age + "��, �Ա�" + this.sex+ ", ��ס��"+
		        this.addr+ ", ��ѧ �� "+ this.math + ", Ӣ� "+ this.english;
	}
}
