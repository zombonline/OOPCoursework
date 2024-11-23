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
    	return id;}
}

public class EnterTheData {
	public static void run(Scanner scan){
		static Scanner scanner = new Scanner(System.in);
	    private static ArrayList<Entry> data = new ArrayList<Entry>();
	    int idCounter;
	    private static boolean running = true;

	    public static void main(String[] args) {
	        displayOptions();
	        while(running)
	        {
	            switch (getInput("Please enter a command: ").toLowerCase())
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
	    public static String getInput(String m)
	    {
	        System.out.print(m);
	        return scanner.nextLine();
	    }
	    public static void addEntry()
	    {
	        String input = getInput("Please enter data in the following format 'firstname lastname age': ");
	        String[] parts = input.split(" ");
	        Entry newEntry = new Entry(parts[0], parts[1], Integer.parseInt(parts[2]), generateUniqueIDString());
	        data.add(newEntry);
	        System.out.println(newEntry.getFirstName() + " " + newEntry.getLastName() + " added successfully.");
	    }
	    public static void removeEntry()
	    {
	        String input = getInput("Please enter the unique ID of the entry you would like to remove: ");
	        for(int i = 0; i < data.size(); i++)
	        {
	            Entry entry = data.get(i);
	            if(entry.getID().equals(input))
	            {
	                System.out.println(entry.getFirstName() + " " + entry.getLastName() + " added successfully.");
	                data.remove(entry);
	            }
	        }
	    }
	    public static void listEntries()
	    {
	        for(int i = 0; i < data.size(); i++)
	        {
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
	        return String.format("%04d", idCounter);
	    }
	}
}
