import java.time.LocalDate;

public class ActiveRental {
    private String rentalID;
    private String userEmail;
    private LocalDate tripStartTime;
    private String bikeID;
    public ActiveRental(String rentalID, String userEmail, LocalDate tripStartTime) {
        this.rentalID = rentalID;
        this.userEmail = userEmail;
        this.tripStartTime = tripStartTime;
    }
    public String getRentalID() {
        return rentalID;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public LocalDate getTripStartTime() {
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
