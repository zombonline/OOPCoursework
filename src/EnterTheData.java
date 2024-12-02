import java.util.Scanner;
import java.util.HashMap;
class Entry {

    private String firstName, lastName;
    private int age;

    public Entry(String firstName, String lastName, int age)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }


}

public class EnterTheData {
	private static HashMap<String, Entry> data = new HashMap<>();
    private static int idCounter;
    private static boolean running = true;
    private static Scanner scanner;
	public static void run(Scanner scan){
		//Set up a new session.
		running = true;
		idCounter = 0;
		data.clear();
		scanner = scan;
		System.out.println("Welcome.");
		displayOptions();
		
        while(running)
        {
        	System.out.print("Please enter a command: ");
            switch (scanner.nextLine().toString())
            {
                case "a":
                    addEntry();
                    break;
                case "r":
                    removeEntry();
                    break;
                case "l":
                    listEntries();
                    break;
                case "q":
                    quit();
                    break;
                default:
                    displayOptions();
                    break;
            } 
        }
	}
	public static void displayOptions()
    {
        System.out.println("a - Add record");
        System.out.println("r - Remove record");
        System.out.println("l - List records");
        System.out.println("q - Quit");
    }
    public static void addEntry()
    {
    	System.out.print("Please enter data in the following format 'firstname lastname age': ");
        String[] parts = scanner.nextLine().split(" ");
        Entry newEntry = new Entry(parts[0], parts[1], Integer.parseInt(parts[2]));
        data.put(generateUniqueIDString(), newEntry);
        System.out.println(newEntry.getFirstName() + " " + newEntry.getLastName() + " added successfully.");
    }
    public static void removeEntry()
    {
    	System.out.print("Please enter the unique ID of the entry you would like to remove: ");
        String input = scanner.nextLine();
		if(data.containsKey(input)) {
			System.out.println(data.get(input).getFirstName() + " " + data.get(input).getLastName() + " removed succesfully.");
			data.remove(input);
		}
		else {
			System.out.println("No entry under this ID.");
		}
    }
    public static void listEntries()
    {
    	if(data.size() == 0) {
    		System.out.println("Database is currently empty.");
    		return;
    	}
    	System.out.println("Entries currently in the database: ");
    	for (String key : data.keySet()) {
    		Entry entry = data.get(key);
            String entryString = entry.getLastName() + ", " + entry.getFirstName() + " " + entry.getAge() + " (ID: " + key + ")";
    	    System.out.println(entryString);
    	}
    }
    public static void quit()
    {
        System.out.println("Thank you, quitting...");
        running = false;
    }
    public static String generateUniqueIDString()
    {
        idCounter++;
        return Integer.toString(idCounter);
    }
}
