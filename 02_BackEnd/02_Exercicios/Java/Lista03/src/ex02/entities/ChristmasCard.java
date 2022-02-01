package ex02.entities;

public class ChristmasCard extends WebCard {
    public ChristmasCard(String addressee){
        super(addressee);
    }

    public void showMessage(){
        System.out.printf("Merry Christmas, %s!%n", this.getAddressee());
    }
}
