import java.util.ArrayList;
import java.util.Scanner;

class Entry {

    private String firstName, lastName;
    private int age;
    private String id;

    public Entry(String firstName, String lastName, int age, String id)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.id = id;
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

    public String getID() {
    	return id;
    }
}

public class EnterTheData {
	private static ArrayList<Entry> data = new ArrayList<Entry>();
    private static int idCounter;
    private static boolean running = true;
    private static Scanner scanner;
	public static void run(Scanner scan){
		//Set up a new session.
		running = true;
		idCounter = 0;
		data.clear();
		scanner = scan;
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
    	System.out.println("Please enter data in the following format 'firstname lastname age': ");
        String[] parts = scanner.nextLine().split(" ");
        Entry newEntry = new Entry(parts[0], parts[1], Integer.parseInt(parts[2]), generateUniqueIDString());
        data.add(newEntry);
        System.out.println(newEntry.getFirstName() + " " + newEntry.getLastName() + " added successfully.");
    }
    public static void removeEntry()
    {
    	System.out.println("Please enter the unique ID of the entry you would like to remove: ");
        String input = scanner.nextLine();
		for(int i = 0; i < data.size(); i++)
        {
            Entry entry = data.get(i);
            if(entry.getID().equals(input))
            {
                System.out.println(entry.getFirstName() + " " + entry.getLastName() + " removed successfully.");
                data.remove(entry);
            }
        }
    }
    public static void listEntries()
    {
        for(int i = 0; i < data.size(); i++)
        {
        	System.out.println("Entries currently in the database: ");
            Entry entry = data.get(i);
            String entryString = entry.getLastName() + ", " + entry.getFirstName() + " " + entry.getAge() + " (ID: " + entry.getID() + ")";
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
