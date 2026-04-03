import java.time.LocalDate;
import java.time.LocalDateTime;

public class ActiveRental {
    private String rentalID;
    private String userEmail;
    private LocalDateTime tripStartTime;
    private String bikeID;
    public ActiveRental(String rentalID, String userEmail, LocalDateTime tripStartTime2) {
        this.rentalID = rentalID;
        this.userEmail = userEmail;
        this.tripStartTime = tripStartTime2;
    }
    public String getRentalID() {
        return rentalID;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public LocalDateTime getTripStartTime() {
        return tripStartTime;
    }
    public String  getBikeID(){
        return bikeID;

    }
    @Override
    public String toString() {
        return "Rental ID: " + rentalID +
                "\nUser Email: " + userEmail +
                "\nTrip Start Time: " + tripStartTime;
    }
    


}
