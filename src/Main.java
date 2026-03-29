public class Main {
     public static void main(String[] args) {
        
        ERyder defaultBike = new ERyder();
        System.out.println("=== Default Constructor Bike ===");
        defaultBike.printBikeDetails();

        
        ERyder paramBike = new ERyder(7, 85, true, 256.8);
        System.out.println("=== Parameterized Constructor Bike ===");
        paramBike.ride();
        paramBike.printBikeDetails();


        
        AdminPanel adminPanel = new AdminPanel();
        adminPanel.userManagementOptions();
    

  
    }

    }


