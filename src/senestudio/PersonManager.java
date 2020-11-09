package senestudio;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class PersonManager implements Serializable {
	public static final long serialVersionUID = -4560685726154991881L;
	private List<Person> personsList = new ArrayList<>();
	private boolean listSaved = true;
	
	public PersonManager() {
	}
	
//	public void setPersonsList(List<Person> personsList) {
//		this.personsList = personsList;
//	}
	
	public boolean isListSaved() {
		return listSaved;
	}
	
	public void setListSaved(boolean listSaved) {
		this.listSaved = listSaved;
	}
	
	public void addPerson(Person person) {
		this.personsList.add(person);
	}
	
	public void createPerson() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Podaj swoje imę:");
		String name = scanner.nextLine();
		System.out.println("Podaj swój wiek:");
		int age = scanner.nextInt();
		
		addPerson(new Person(name, age));	// myślałem, że tu cast będzie potrzebny z int na double, ale nie...
		
		setListSaved(false);
	}
	
	public double getAgeAverage() {
		return personsList.stream()
				.mapToDouble(Person::getAge)
				.average()
				.orElse(0);
	}
	
	public void printGroupNames() {
		System.out.println("\nOsoby zapisane: ");
		personsList.stream()
				.map(Person::getName)
				.collect(Collectors.toList()).forEach(System.out::println);
//		System.out.println(names);
	}
	
	public void printAgeAverage() {
		double average = getAgeAverage();
		System.out.printf("\nŚrednia wieku to: %.2f", average);
	}
}
