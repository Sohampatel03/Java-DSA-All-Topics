import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class project {
    String name;
    Date startDate;
    Date endDate;
    double budget;

    public Destination(String name, Date startDate, Date endDate, double budget) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
    }
}

public class TravelPlanner {
    private List<Destination> destinations;
    private Scanner scanner;

    public TravelPlanner() {
        destinations = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addDestination() {
        System.out.println("Enter destination name:");
        String name = scanner.nextLine();
        System.out.println("Enter start date (YYYY-MM-DD):");
        Date startDate = getDateFromUser();
        System.out.println("Enter end date (YYYY-MM-DD):");
        Date endDate = getDateFromUser();
        System.out.println("Enter budget:");
        double budget = scanner.nextDouble();

        Destination destination = new Destination(name, startDate, endDate, budget);
        destinations.add(destination);
        System.out.println("Destination added successfully!");
    }

    private Date getDateFromUser() {
        Date date = null;
        while (date == null) {
            try {
                String dateString = scanner.nextLine();
                date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format:");
            }
        }
        return date;
    }

    public void generateTravelPlan() {
        System.out.println("Your travel plan:");
        for (Destination destination : destinations) {
            System.out.println("Destination: " + destination.name);
            System.out.println("Start Date: " + destination.startDate);
            System.out.println("End Date: " + destination.endDate);
            System.out.println("Budget: $" + destination.budget);
            System.out.println("Weather: " + getWeather(destination.name)); // Fetch weather info
            System.out.println("-----------------------------");
        }
    }

    // Placeholder method to simulate fetching weather data
    private String getWeather(String destinationName) {
        // In a real application, you would call a weather API to get actual weather information
        // This is just a placeholder to demonstrate the concept
        return "Sunny"; 
    }

    public static void main(String[] args) {
        TravelPlanner planner = new TravelPlanner();
        planner.addDestination();
        planner.generateTravelPlan();
    }
}
