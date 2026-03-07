public class Main {
     public static void main(String[] args) {
        
        EBike defaultBike = new EBike();
        System.out.println("=== Default Constructor Bike ===");
        defaultBike.printBikeDetails();

        
        EBike paramBike = new EBike("BK007", 85, true, 256.8);
        System.out.println("=== Parameterized Constructor Bike ===");
        paramBike.ride();
        paramBike.printBikeDetails();
    }

}
