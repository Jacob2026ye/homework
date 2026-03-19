public class ERyder {
    private int bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;
    private String LINKED_ACCOUNT;
    private String LINKED_PAYMENT_METHOD;
    private double totalFare;
    

    public ERyder() {
        // Default constructor
        this.bikeID = 0;
        this.batteryLevel = 0;
        this.isAvailable = false;   
        this.kmDriven = 0.0;
    }

     public ERyder(int bikeID, int batteryLevel, boolean isAvailable, double kmDriven) {
        this.bikeID = bikeID;
        this.batteryLevel = batteryLevel;
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
     }



         public ERyder(int bikeID,int batteryLevel,boolean isAvailable,double kmDriven,String LINKED_ACCOUNT,String LINKED_PAYMENT_METHOD) {
        this.bikeID = bikeID;
        this.batteryLevel = batteryLevel;
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
        
          
        }
    public void ride(){
        if (isAvailable && batteryLevel > 0) {
            System.out.println("Riding the bike...");
            // Simulate riding the bike and updating battery level and km driven
            batteryLevel -= 10; // Decrease battery level by 10% for each ride
            kmDriven += 5.0; // Increase km driven by 5 km for each ride
            if (batteryLevel <= 0) {
                isAvailable = false; // Bike becomes unavailable if battery is depleted
                System.out.println("Battery depleted. Please recharge the bike.");
            }
        } else {
            System.out.println("Bike is not available for riding.");
        }
    }

    
    public void printBikeDetails(){
        System.out.println("\n=== Bike Details ===");
        System.out.println("Bike ID: " + bikeID);
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
        System.out.println("Total KM Driven: " + kmDriven + " km");
        System.out.println("====================");
    }
    
    public void printRideDetails(int useageInMinutes){
        System.out.println("Linked Account: " + LINKED_ACCOUNT);
        System.out.println("Linked Phone Number: " + LINKED_PAYMENT_METHOD);
        System.out.println("bikeID: " + bikeID  );
        System.out.println("Usage Time: " + useageInMinutes + " minutes");
        System.out.println("total fare:"+ calculateFare(useageInMinutes) + " dollars"  );
       
      

    }
    private static final double BASE_FARE = 2.0; // example base fare
    private static final double PER_MINUTE_RATE = 0.5; // example per minute rate

    private double calculateFare(int usageInMinutes) {
       totalFare = BASE_FARE + (PER_MINUTE_RATE * usageInMinutes);
       return totalFare;
    }
    
    public int getBikeID() {
        return bikeID;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public double getKmDriven() {
        return kmDriven;
    }
}
