public class Main {
     public static void main(String[] args) {
        
        ERyder defaultBike = new ERyder();
        System.out.println("=== Default Constructor Bike ===");
        defaultBike.printBikeDetails();

        
        ERyder paramBike = new ERyder(7, 85, true, 256.8);
        System.out.println("=== Parameterized Constructor Bike ===");
        paramBike.ride();
        paramBike.printBikeDetails();


        
        AdminPanel adminPanel = new AdminPanel(null);
        adminPanel.userManagementOptions();
    
      
        // 初始化自行车服务
        BikesService bike = new BikesService("BIKE001", true, "Downtown");

    
        bike.reserveBike("user2@example.com"); 
        bike.removeTrip(); 

        // 启动管理员面板
        AdminPanel admin = new AdminPanel(bike);
        admin.showAdminMenu();
 
  
    }

    }


