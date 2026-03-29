import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class BikeRental {
    private boolean isRegisteredUser;
    private String emailAddress;
    private String location;
    private LocalDateTime tripStartTime;
    private String bikeID;
    private boolean locationValid;
    private ActiveRental activeRental;
    private UserRegistration userRegistration;
    private LinkedList<ActiveRental> activeRentalsList;

     public BikeRental() {
        
    LinkedList<ActiveRental> activeRentalsList = new LinkedList<ActiveRental>();
     userRegistration = new UserRegistration();
     }
   
   
    public void simulateApplicationInput(){
        System.out.println("This is a simulation of the e-bike rental process.");
        Scanner scanner =new Scanner(System.in);
        System.out.println("Is registered user?(true/false): ");
        isRegisteredUser = scanner.nextBoolean();   

        System.out.println("Enter email address: ");
        String emailAddress = scanner.next();

        System.out.println("Enter location: ");
        String location = scanner.next();

        System.out.println("Simulating the analysis of the rental request..."); 
        analyserRequest(isRegisteredUser,emailAddress,location);
        if(!locationValid){
            System.out.println("Location invalid,prppcess aborted,");
            return;
            }
        reservebike(bikeID);
        System.out.println("Displaying the active rentals...");
        viewActiveRentals();
        System.out.println("Simulating the end of the trip...");
        removeTrip(bikeID);
        System.out.println("Displaying the active entals after trip end...");
        viewActiveRentals();
        
        
    
    }



    private void removeTrip(String id) {
      for (int i = 0; i < activeRentalsList.size(); i++) {
            ActiveRental ar = activeRentalsList.get(i);
            if (ar.getBikeID().equals(id)) {
                activeRentalsList.remove(i);
                break;
            }
        }

        ArrayList<Bike> bikes = BikeDatabase.bikes;
        for (int i = 0; i < bikes.size(); i++) {
            Bike bike = bikes.get(i);
            if (bike.getBikeID().equals(id)) {
                bike.setIsAvailable();
                break;
            }
        }
    }
    


    private void viewActiveRentals() {
        if (activeRentalsList.isEmpty()) {
            System.out.println("No active rentals at the moment.");
        } else {
            for (ActiveRental rental : activeRentalsList) {
                System.out.println(rental);
            }
        }
    }



    private void reservebike(String id) {
          if (bikeID != null) {
        // 遍历 BikeDatabase 里的 bikes ArrayList
        ArrayList<Bike> bikes = BikeDatabase.bikes;
        for (Bike bike : bikes) {
            // 匹配 bikeID
            if (bike.getBikeID().equals(bikeID)) {
                // 存储当前日期时间到 tripStartTime
                tripStartTime = LocalDateTime.now();
                
                // 把 bike 设为不可用（调用 setIsAvailable(false)）
                bike.setIsAvailable();
                
                // 设置 lastUsedTime 为 tripStartTime
                bike.setLastUsedTime();
                
                // 输出指定提示语
                System.out.println("Reserving the bike with the " + bikeID + ". Please following the on-screen instructions to locate the bike and start your pleasant journey.");
                
        
                
                // 添加到 activeRentalsList
                activeRentalsList.add(activeRental);
                
                // 跳出循环
                break;
            }
        }
    } else {
        // bikeID 为 null 时的提示
        System.out.println("Sorry, we're unable to reserve a bike at this time. Please try again later.");
    }
    }


    private String analyserRequest(boolean isRegisteredUser, String emailAddress, String location2) {
      if(isRegisteredUser=true){
        System.out.println("Welcome back,"+emailAddress);
     }
     else{
        System.out.println("You're not our registered user.");
          userRegistration.registration();
     }  
      return validateLocation(location);
    }
  
  private String validateLocation(String location) {
    
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getLocation().equals(location) && bike.isAvailable()) {
                System.out.println("A bike is available at the location you requested.");
                locationValid = true;
                return bike.getBikeID();
            }
        }
        System.out.println("Sorry, no bikes are available at the location you requested. Please try again later.");
        locationValid = false;
        return null;
    }

}


