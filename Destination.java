import java.util.Date;

public class Destination {
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
