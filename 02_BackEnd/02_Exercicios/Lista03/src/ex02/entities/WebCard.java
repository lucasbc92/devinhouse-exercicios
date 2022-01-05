package ex02.entities;

public abstract class WebCard {
    private String addressee;

    public WebCard(String addressee){
        this.addressee = addressee;
    }

    public String getAddressee(){
        return this.addressee;
    }

    public abstract void showMessage();
}
