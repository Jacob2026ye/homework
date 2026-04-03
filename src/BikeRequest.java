import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BikeRequest {
 private String userEmail;
    
    private String location;

    private LocalDateTime requestTime;

    
    public BikeRequest(String userEmail, String location, LocalDateTime requestTime) {
        this.userEmail = userEmail;
        this.location = location;
        this.requestTime = requestTime;
    }


    public String getUserEmail() {
        return userEmail;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getRequestTime() {
        return requestTime;
    }

    /**
     * 输出请求信息：用户邮箱、位置、请求时间
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        String formattedTime = requestTime.format(formatter);
        return String.format("User: %s | Location: %s | Request Time: %s",
                userEmail, location, formattedTime);
    }

}
