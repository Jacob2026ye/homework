public class Feedback {
   private String firstName;
    private String lastName;
    private String email;
    private String completeFeedback;
    private String viewID;
    private boolean longFeedback;

    public Feedback(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getCompleteFeedback() {
        return completeFeedback;
    }   
    public String getViewID() {
        return viewID;
    }   
    public boolean getLongFeedback() {
        return longFeedback;
    }   
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }   
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }  
     public void setEmail(String email) {
        this.email = email;
    }  
     public void setCompleteFeedback(String completeFeedback) {
        this.completeFeedback = completeFeedback;
    }   
    public void setViewID(String viewID) {
        this.viewID = viewID;
    }  
     public void setLongFeedback(boolean longFeedback) {
        this.longFeedback = longFeedback;
    }
    public void  analyseFeedback(boolean isCocatenation ,String sent1,String sent2,String sent3,String  sent4,String sent5)
    {
        if (isCocatenation=true) {
            this.completeFeedback = feedbackUsingConcatenation(sent1, sent2, sent3, sent4, sent5);
            this.longFeedback =checkFeedbackLength(this.completeFeedback);
            this.viewID = createReviewID(this.firstName, this.lastName,this.completeFeedback); 

        }if (isCocatenation=false) 
            {
           this.completeFeedback = feedbackUsingStringBuilder(sent1, sent2, sent3, sent4, sent5);
            this.longFeedback =checkFeedbackLength(this.completeFeedback);
            this.viewID = createReviewID(this.firstName, this.lastName,this.completeFeedback);

            
        }
}

public String feedbackUsingConcatenation(String sent1,String sent2,String sent3,String  sent4,String sent5)
    {
        String concatenatedFeedback="";

        concatenatedFeedback+=sent1;
        concatenatedFeedback+=sent2;
        concatenatedFeedback+=sent3;
        concatenatedFeedback+=sent4;    
        concatenatedFeedback+=sent5;

        return concatenatedFeedback;
    }
    public String feedbackUsingStringBuilder(String sent1,String sent2,String sent3,String  sent4,String sent5)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(sent1).append(" ").append(sent2).append(" ").append(sent3).append(" ").append(sent4).append(" ").append(sent5);
        return sb.toString();
    }


    public boolean checkFeedbackLength(String completeFeedback) {
     
      this.longFeedback = completeFeedback.length() > 500;
        return this.longFeedback;
    }
    public String createReviewID(String firstName, String lastName, String completeFeedback) {
        String reviewID = ((firstName+lastName).toUpperCase() .substring(2,6 )+completeFeedback.substring(10,15).toLowerCase()+completeFeedback.length()+"_"+System.currentTimeMillis()).replace(" ", ""); 
        return reviewID;
    }
 
    public static void main(String[] args){
    String sent1="I was very satisfied with the service.";
    String sent2="The e-Bike is quite comfortable to ride.";
    String sent3="The battery life of the e-Bilke is impressive.";
    String sent4="The customer support was helpful and responsive.";
    String sent5="I would recommend this e-Bilke to my friends and family.";
    
    Feedback feedback = new Feedback("John","Doe","john.doe@example.com");

    feedback.analyseFeedback(true,sent1,sent2,sent3,sent4,sent5);

    System.out.println("User:"+feedback.getFirstName()+""+feedback.getLastName());
    System.out.println("Email:"+feedback.getEmail());
    System.out.println("Review ID:"+feedback.getViewID());
    System.out.println("Is long feedback?"+feedback.getLongFeedback());
    System.out.println("Complete Feedback:\n"+feedback.getCompleteFeedback());
}
}

 