public class EBike {
     private String bikeId;
    private int batteryLevel;
    private boolean isAvailable;
    private double distanceTraveled;

    
    public EBike() {
        this.bikeId = "Unknown";
        this.batteryLevel = 0;
        this.isAvailable = false;
        this.distanceTraveled = 0.0;
    }

   
    public EBike(String bikeId, int batteryLevel, boolean isAvailable, double distanceTraveled) {
        this.bikeId = bikeId;
        setBatteryLevel(batteryLevel); 
        this.isAvailable = isAvailable;
        this.distanceTraveled = distanceTraveled;
    }

    
    public void ride() {
        if (isAvailable && batteryLevel > 0) {
            System.out.println("The bike is available.");
        } else {
            System.out.println("The bike is not available.");
        }
    }

    
    public void printBikeDetails() {
        System.out.println("Bike ID: " + bikeId);
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
        System.out.println("Distance Traveled: " + distanceTraveled + " km");
    }

   
    public String getBikeId() {
        return bikeId;
    }

    public void setBikeId(String bikeId) {
        this.bikeId = bikeId;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

 
    public void setBatteryLevel(int batteryLevel) {
        if (batteryLevel >= 0 && batteryLevel <= 100) {
            this.batteryLevel = batteryLevel;
        } else {
            System.out.println("Error: Battery level must be between 0 and 100.");
           
        }
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(double distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

  
    public static void main(String[] args) {
        EBike bike1 = new EBike("BK001", 75, true, 120.5);
        bike1.ride();
        bike1.printBikeDetails();

        
        bike1.setBatteryLevel(110); 
        bike1.setBatteryLevel(-5); 
        bike1.setBatteryLevel(30);  
    }

}
