import java.util.ArrayList;

public class BikeDatabase {
  public static ArrayList<Bike> bikes = new ArrayList<Bike>();

    static {
        bikes.add(new Bike("B001", "A"));
        bikes.add(new Bike("B002", "B"));
        bikes.add(new Bike("B003", "A"));
    }
}
