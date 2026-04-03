import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BikesService {
  private Stack<ERyderLog> systemLogs = new Stack<>();
    private Queue<BikeRequest> bikeRequest = new ArrayDeque<>();
    private String bikeID;
    private boolean isAvailable;
    private String location;

   
    public BikesService(String bikeID, boolean isAvailable, String location) {
        this.bikeID = bikeID;
        this.isAvailable = isAvailable;
        this.location = location;
    }

  
    public void addLog(String logId, String eventDesc) {
        ERyderLog log = new ERyderLog(logId, eventDesc, LocalDateTime.now());
        systemLogs.push(log);
    }

 
    public void viewSystemLogs() {
        if (systemLogs.isEmpty()) {
            System.out.println("No system logs available.");
            return;
        }
        System.out.println("=== System Logs ===");
 
        for (ERyderLog log : systemLogs) {
            System.out.println(log.toString());
        }
    }

 
    public void addBikeRequest(String userEmail, String location) {
        BikeRequest request = new BikeRequest(userEmail, location, LocalDateTime.now());
        bikeRequest.offer(request);
        System.out.println("Request added to queue.");
    }

  
    public void viewBikeRequests() {
        if (bikeRequest.isEmpty()) {
            System.out.println("No pending bike requests.");
            return;
        }
        System.out.println("=== Pending Bike Requests ===");
        for (BikeRequest request : bikeRequest) {
            System.out.println(request.toString());
        }
    }

 
    public BikeRequest updateQueue() {
        if (bikeRequest.isEmpty()) {
            System.out.println("No pending requests to process.");
            return null;
        }
   
        BikeRequest nextRequest = bikeRequest.poll();
        System.out.println("Assigned request to user: " + nextRequest.getUserEmail());
        return nextRequest;
    }

    public boolean reserveBike(String userEmail) {
        if (isAvailable) {
            isAvailable = false;
            String logId = "BR" + bikeID.substring(bikeID.length() - 3); 
            String eventDesc = String.format("Bike with %s was rented by %s from %s",
                    bikeID, userEmail, location);
            addLog(logId, eventDesc);
            return true;
        } else {
            addBikeRequest(userEmail, location);
            return false;
        }
    }



    public void removeTrip() {
   
        String logId = "TE" + bikeID.substring(bikeID.length() - 3);
        String eventDesc = String.format("Trip ended for bike %s at %s", bikeID, location);
        addLog(logId, eventDesc);

        isAvailable = true;

        if (!bikeRequest.isEmpty()) {
            BikeRequest nextUser = updateQueue();
            System.out.println("Bike assigned to next user: " + nextUser.getUserEmail());
        }
    }

   
    public String getBikeID() { return bikeID; }
    public boolean isAvailable() { return isAvailable; }
    public String getLocation() { return location; }
}
