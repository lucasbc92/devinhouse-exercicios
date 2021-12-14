package ex07.entities;

public class Student {
    protected String code;
    protected String registration;
    protected int credits;

    public Student(String registration, int credits) throws Exception{
        if(!registration.matches("\\d{5}")){
            throw new Exception("Invalid registration.");
        }
        if(credits < 0){
            throw new Exception("Credits number must be non-negative.");
        }
        this.code = "AR";
        this.registration = registration;
        this.credits = credits;
    }
    
    public String getCode(){
        return this.code;
    }

    public String getRegistration(){
        return this.registration;
    }

    public int getCredits(){
        return this.credits;
    }

    public String toString(){
        return String.format("Student (%s%s) - Credits: %d", this.getCode(), this.getRegistration(), this.getCredits());
    }
}
