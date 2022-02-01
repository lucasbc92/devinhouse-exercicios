package ex07.entities;

public class SpecialStudent extends Student {

    public SpecialStudent(String registration, int credits) throws Exception{
        super(registration, credits);
        if(credits > 10){
            credits = 10;
        }
        this.code = "AE";
        this.credits = credits;
    }
}
