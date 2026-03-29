import java.time.LocalDateTime;

public class Bike {
    private String bikeID;
    private boolean isAvailable;
    private int batteryLevel;
    private LocalDateTime lastUsedTime;
    private String location;


    public Bike(String bikeID, String location) {
        this.bikeID = bikeID;
        this.isAvailable = true;
        this.batteryLevel = 100;
        this.lastUsedTime = LocalDateTime.now();
        this.location = location;
    }

    public String getBikeID() {
        return bikeID;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public LocalDateTime getLastUsedTime() {
        return lastUsedTime;
    }

    public String getLocation() {
        return location;
    }
    public  boolean setIsAvailable(){
        return isAvailable;
    }
    public LocalDateTime setLastUsedTime(){
        return lastUsedTime;
    }
    @Override
    public String toString() {
        return "Bike ID: " + bikeID +
                "\nAvailable: " + isAvailable +
                "\nBattery Level: " + batteryLevel + "%" +
                "\nLast Used Time: " + lastUsedTime +
                "\nLocation: " + location;
    }
}

   
    
