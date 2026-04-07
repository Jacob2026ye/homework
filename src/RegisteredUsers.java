public class RegisteredUsers {
private String fullName;
    private String emailAddress;
    private String dateOfBirth;
    private long cardNumber;
    private String cardExpiryDate;
    private String cardProvider;
    private int cvv;
    private String userType;
    private String[] lastThreeTrips;
    
    public RegisteredUsers(String fullName, String emailAddress, String dateOfBirth, String cardNumber2,
                            String cardExpiryDate, String cardProvider, String cvv2, String userType, String[] lastThreeTrips) {
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
        this.cardNumber = Long.parseLong(cardNumber2);
        this.cardExpiryDate = cardExpiryDate;
        this.cardProvider = cardProvider;
        this.cvv = Integer.parseInt(cvv2);
        this.userType = userType;
        this.lastThreeTrips = lastThreeTrips;
    }

    public RegisteredUsers(String fullName2, String emailAddress2, String dateOfBirth2, long cardNumber2,
            String cardExpiryDate2, String cardProvider2, int cvv2, String userType2, String[] lastThreeTrips2) {
        this.fullName = fullName2;
        this.emailAddress = emailAddress2;
        this.dateOfBirth = dateOfBirth2;
        this.cardNumber = cardNumber2;
        this.cardExpiryDate = cardExpiryDate2;
        this.cardProvider = cardProvider2;
        this.cvv = cvv2;
        this.userType = userType2;
        this.lastThreeTrips = lastThreeTrips2;
    }

    public RegisteredUsers(String fullName, String emailAddress) {
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.dateOfBirth = "";
        this.cardNumber = 0L;
        this.cardExpiryDate = "";
        this.cardProvider = "";
        this.cvv = 0;
        this.userType = "Regular";
        this.lastThreeTrips = new String[0];
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber2) {
        this.cardNumber = cardNumber2;
    }

    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    public void setCardExpiryDate(String cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }

    public String getCardProvider() {
        return cardProvider;
    }

    public void setCardProvider(String cardProvider) {
        this.cardProvider = cardProvider;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(String cvv2) {
        this.cvv = Integer.parseInt(cvv2);
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String[] getLastThreeTrips() {
        return lastThreeTrips;
    }

    public void setLastThreeTrips(String[] lastThreeTrips) {
        this.lastThreeTrips = lastThreeTrips;
    }
      public double calculateFare(double baseFare) {
        return baseFare;
      }
        public void displayUserType() {
        
    }
   public class RegularUser extends RegisteredUsers {

   
    public RegularUser(String fullName, String emailAddress) {
        super(fullName, emailAddress, emailAddress, emailAddress, emailAddress, emailAddress, emailAddress, emailAddress, lastThreeTrips);
    }

  
    @Override
    public double calculateFare(double baseFare) {
        return baseFare;
    }

    @Override
    public void displayUserType() {
        System.out.println("Regular User");
    }
}
public class VIPUser extends RegisteredUsers {

    public VIPUser(String fullName, String emailAddress) {
        super(fullName, emailAddress);
    }

    @Override
    public double calculateFare(double baseFare) {
        return baseFare * 0.8;
    }

    @Override
    public void displayUserType() {
        System.out.println("VIP User");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Full Name: ").append(fullName).append("\n");
        sb.append("Email Address: ").append(emailAddress).append("\n");
        sb.append("Date of Birth: ").append(dateOfBirth).append("\n");
        sb.append("Card Number: ").append(cardNumber).append("\n");
        sb.append("Card Expiry Date: ").append(cardExpiryDate).append("\n");
        sb.append("Card Provider: ").append(cardProvider).append("\n");
        sb.append("CVV: ").append(cvv).append("\n");
        sb.append("User Type: ").append(userType).append("\n");
        sb.append("Last Three Trips:\n");
        for (String trip : lastThreeTrips) {
            sb.append("- ").append(trip).append("\n");
        }
        return sb.toString();
    }

    public void setCvv(String cvv2) {
       
        throw new UnsupportedOperationException("Unimplemented method 'setCvv'");
    }

}
}
