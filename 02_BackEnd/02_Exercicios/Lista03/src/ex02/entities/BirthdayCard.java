package ex02.entities;

public class BirthdayCard extends WebCard {
    public BirthdayCard(String addressee){
        super(addressee);
    }

    public void showMessage(){
        System.out.printf("Happy Birthday, %s!%n", this.getAddressee());
    }
}
