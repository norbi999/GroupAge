package senestudio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    
//        Person michal = new Person("Michał", 42);
//        Person robert = new Person("Robert", 24);
        
        FileRepository fileRepository = new FileRepository();
        
        System.out.println("Witaj w aplikacji Średnia Wieku; wersja 0.01");
        System.out.println("Próbuję załadować grupę z pliku...");
    
        PersonManager group = null;
        try {
            group = fileRepository.loadGroup();
            System.out.println("Plik załadowany poprawnie.");
        } catch (IOException e) {
            System.out.println("Nie odnaleziono pliku. Zakładam nową bazę.");
            group = new PersonManager();
            
//            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    
        System.out.println();
    
        assert group != null;   // to mi wyskoczyło z IntelliJ-a i okazuje się że samo 'assert' jest już w Javie od zarania dziejów - trzeba tylko "uruchomić" komendą Java -ea
        group.setListSaved(true);
//        group.addPerson(michal);
//        group.addPerson(robert);
//        group.addPerson(new Person("ALA", 11));
        
        Scanner scanner = new Scanner(System.in);
        boolean cont = true;
        while (cont) {
            System.out.println("Wybierz, co chcesz teraz zrobić:");
//            System.out.println("1) Załaduj grupę z pliku");
            System.out.println("1) Pokaż średnią wieku grupy");
            System.out.println("2) Pokaż listę osób w grupie");
            System.out.println("3) Dodaj osobę do grupy");
            System.out.println("4) Zapisz grupę do pliku");
            if (!group.isListSaved())
                System.out.println("  -- grupa zmodyfikowana ale nie zapisana do pliku!");
            System.out.println("0) Zakończ program");
            
            switch (scanner.nextInt()) {
//                case 1 -> group.setPersonsList(fileRepository.loadGroup());
                case 1:
                    group.printAgeAverage();
                    break;
                case 2:
                    group.printGroupNames();
                    break;
                case 3:
                    group.createPerson();
                    break;
                case 4:
                    fileRepository.saveGroup(group);
                    break;
                case 0:
                    cont = false;
                    break;
            }
    
            System.out.println("-------");
            
            
        }
    
        System.out.println("Dziękuję za skorzystanie programu :D");
        
        
//        FileRepository fr = new FileRepository();
//        fr.saveGroup(group);
        
//        PersonManager group = fr.loadGroup();
        
//        group.printAverage();
//        group.printGroupNames();
    

    
    }
}
