package senestudio;

import java.io.Serializable;

public class Person implements Serializable {
	private String name;
	private double age;		// tutaj zrobiłem double żeby lepiej się średnią wieku liczyło
	
	
	public Person(String name, double age) {
		this.name = name;
		this.age = age;
	}
	
	public double getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
}
