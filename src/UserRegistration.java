import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserRegistration {
    public static final double VIP_DISCOUNT_UNDER_18_BIRTHDAY = 25.0;
    public static final double VIP_DISCOUNT_UNDER_18=20.0;
    public static final double VIP_BASE_FEE=100.0;
    private String fullName;
    private String emailAddress;
    private String dateOfBirth;
    private long cardNumber;
    private String cardProvider;
    private String cardExpiryDate;
    private double feeToCharge;
    private int cvv;
    private String userType;
    private boolean  emailValid;
    private boolean minorAndBirthday;
    private boolean  minor;
    private boolean ageValid;
    private boolean cardNumberValid;
    private boolean cardStillValid;
    private boolean  validCVV;
    private Scanner scanner = new Scanner(System.in);
    
    public String getFullName() {
        return fullName;
    }
    
    
    public String getEmailAddress() {
        return emailAddress;
           }
    public boolean getEmailValid() {
        return emailValid;
    }   
    public void setEmailValid(boolean emailValid) {
        this.emailValid = emailValid;
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
    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }   
    public String getCardProvider() {
        return cardProvider;
    }   
    public void setCardProvider(String cardProvider) {
        this.cardProvider = cardProvider;
    }   
    public String getCardExpiryDate() {
        return cardExpiryDate;
    }   
    public void setCardExpiryDate(String cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }
    public int getCvv() {
        return cvv;
    }   
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }   
    public String getEmail() {
        return emailAddress;
    }
    public String getFullName(String fullName) {
        this.fullName = fullName;
        return fullName;
    }   
    public String getEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return emailAddress;
    }   
    public String getDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return dateOfBirth;
    }   
    public long getCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
        return cardNumber;
    }   
    public String getCardProvider(String cardProvider) {
        this.cardProvider = cardProvider;
        return cardProvider;
    }   
    public String getCardExpiryDate(String cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
        return cardExpiryDate;
    }   
    public int getCvv(int cvv) {
        this.cvv = cvv;
        return cvv;
    }   
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }       
    public String setEmail(String emailAddress) {
        this.emailAddress = emailAddress;
        return emailAddress;
    }   
   public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }       
    public String getuserType(String userType) {
        this.userType = userType;
        return userType;
    }     
    public  String setUserType(String userType){
        this.userType = userType;
        return userType;
    }

   
        
    
  public void registration(){
        System.out.println("Welcome to the ERyder Registration.");
        System.out.println("Here are your two options:");
        System.out.println("1. Register as a Regular User");
        System.out.println("2. Register as a VIP User");
        System.out.print("Please enter your choice (1 or 2): ");

        int choice = scanner.nextInt();
        UserRegistration user= new UserRegistration();
        if (choice == 1) {
            user.setUserType("Regular User");
        } else if (choice == 2) {
            user.setUserType("VIP User");
        } else {
            System.out.println("Invalid choice. Please restart the registration process.");
            scanner.close();
            return;
        }
        
        System.out.println("注册成功！您的用户类型是：" + choice);
        scanner.close();
        
    System.out.print("Full Name: ");
        fullName = scanner.nextLine();
        System.out.print("Email: ");
        emailAddress = scanner.nextLine();
        emailValid = analyseEmail(emailAddress);

        System.out.print("DOB (YYYY-MM-DD): ");
        dateOfBirth = scanner.nextLine();
        ageValid = analyseAge(LocalDate.parse(dateOfBirth));

        System.out.print("Card Number: ");
        cardNumber = scanner.nextLong();
        cardNumberValid = analyseCardNumber(cardNumber);
        scanner.nextLine();

        System.out.print("Card Expiry (MM/YY): ");
        cardExpiryDate = scanner.nextLine();
        cardStillValid = analyseCardExpiryDate(cardExpiryDate);

        System.out.print("CVV: ");
        cvv = scanner.nextInt();
        validCVV = analyseCVV(cvv);
      
        finalCheckpoint();
        scanner.close();
}
    
    
  
    
    public boolean analyseEmail(String email) {
       boolean hasAt =  email.contains("@");
        boolean hasDot = email.contains(".");
        if(hasAt &&hasDot){
            System.out.println("Email is valid.");
            return true;
        }else{
            System.out.println("Invalid email address. Going back to the start of the registration");
            registration();
            return false;
        }
    }
     private boolean analyseAge(LocalDate dob) {
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(dob, currentDate).getYears();
        boolean isBirthday = (dob.getMonth() == currentDate.getMonth()) 
                          && (dob.getDayOfMonth() == currentDate.getDayOfMonth());

        
        if (age <= 12 || age > 120) {
            System.out.println("Looks like you are either too young or already dead. Sorry, you can't be our user. Have a nice day");
            System.exit(0);
        }

        
        if (userType.equals("VIP User")) {
            if (isBirthday && age <= 18 && age > 12) {
                System.out.println("Happy Birthday!");
                System.out.println("You get 25% discount on the VIP subscription fee for being born today and being under 18!");
                minorAndBirthday = true;
            } else if (!isBirthday && age <= 18 && age > 12) {
                System.out.println("You get 20% discount on the VIP subscription fee for being under 18!");
                minor = true;
            }
        }
        return true;
    }

   private boolean analyseCardNumber(long cardNum) {
        String num = String.valueOf(cardNum);
        if (num.startsWith("4") && (num.length() == 13 || num.length() == 15)) {
            cardProvider = "VISA";
            cardNumberValid = true;
        } else if (num.length() == 16 && (num.substring(0,2).matches("5[1-5]") || num.substring(0,4).matches("222[1-9]|22[3-9]\\d|2[3-6]\\d{2}|27[0-1]\\d|2720"))) {
            cardProvider = "MasterCard";
            cardNumberValid = true;
        } else if (num.length() == 15 && (num.startsWith("34") || num.startsWith("37"))) {
            cardProvider = "American Express";
            cardNumberValid = true;
        } else {
            cardNumberValid = false;
        }
        System.out.println(cardNumberValid ? "Card valid (" + cardProvider + ")" : "Card invalid");
        return cardNumberValid;
    }

    // 5. 卡有效期验证
    private boolean analyseCardExpiryDate(String expiry) {
        int month = Integer.parseInt(expiry.substring(0,2));
        int year = 2000 + Integer.parseInt(expiry.substring(3,5));
        cardStillValid = LocalDate.of(year, month, 1).isAfter(LocalDate.now());
        System.out.println(cardStillValid ? "Card not expired" : "Card expired");
        return cardStillValid;
    }

    // 6. CVV验证
    private boolean analyseCVV(int cvv) {
        validCVV = (cardProvider.equals("American Express") && String.valueOf(cvv).length() == 4) 
                || (!cardProvider.equals("American Express") && String.valueOf(cvv).length() == 3);
        System.out.println(validCVV ? "CVV valid" : "CVV invalid");
        return validCVV;
    }

    // 7. 最终校验
    private void finalCheckpoint() {
        if (emailValid && ageValid && cardNumberValid && cardStillValid && validCVV) {
            // 计算费用
            feeToCharge = VIP_BASE_FEE;
            if (minorAndBirthday) feeToCharge *= (1 - VIP_DISCOUNT_UNDER_18_BIRTHDAY/100);
            else if (minor) feeToCharge *= (1 - VIP_DISCOUNT_UNDER_18/100);
            
            // 输出结果
            System.out.println("\nRegistration Success!");
            System.out.println("Fee charged: $" + feeToCharge);
            System.out.println("Card last 4 digits: " + String.valueOf(cardNumber).substring(String.valueOf(cardNumber).length()-4));
        } else {
            System.out.println("Registration Failed");
        }
    }

    // 主方法测试
    public static void main(String[] args) {
        new UserRegistration().registration();
    }

   

}
