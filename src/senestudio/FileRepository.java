package senestudio;

import java.io.*;

public class FileRepository {
	private final String FILE_NAME = "grupa.bin";
	
	public FileRepository() {
	}
	
	public void saveGroup(PersonManager people) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
			
			oos.writeObject(people);
			oos.flush();
			oos.close();
			
			people.setListSaved(true);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public PersonManager loadGroup() throws IOException, ClassNotFoundException {
//		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME));
			return (PersonManager) ois.readObject();
			
//		} catch (IOException | ClassNotFoundException e) {
//			System.out.println("Nastąpił błąd podczas ładowania grupy z pliku...");
//			e.printStackTrace();
//		}
		
//		return null;
	}
}
