package ex02.entities;

public class ValentinesDayCard extends WebCard{
    public ValentinesDayCard(String addressee){
        super(addressee);
    }

    public void showMessage(){
        System.out.printf("Happy Valentine's Day, %s!%n", this.getAddressee());
    }
}
