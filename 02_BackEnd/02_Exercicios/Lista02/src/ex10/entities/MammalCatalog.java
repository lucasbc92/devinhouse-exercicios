package ex10.entities;

import java.util.ArrayList;
import java.util.List;

public class MammalCatalog {
    private List<Mammal> mammals;
    private int batCount;
    private int catCount;
    private int dogCount;

    public MammalCatalog() {
        this.mammals = new ArrayList<Mammal>();
        this.batCount = 0;
        this.catCount = 0;
        this.dogCount = 0;
    }

    public List<Mammal> getMammals() {
        return this.mammals;
    }

    public int getBatCount(){
        return this.batCount;
    }

    public int getCatCount(){
        return this.catCount;
    }

    public int getDogCount(){
        return this.dogCount;
    }

    public String list(){
        String list = "";
        if(this.getMammals().isEmpty()){
            return String.format("The catalog is empty!%n");
        } else {
            for(int i = 0; i < this.getMammals().size(); i++){
                list += String.format("[%d] - %s%n", (i+1), this.getMammals().get(i).introduce());
            }
            return list;
        }
    }

    public String account(){
        return String.format("The catalog has:%n\t%d Bats%n\t%d Cats%n\t%d Dogs", this.getBatCount(), this.getCatCount(), this.getDogCount());
    }

    public void addBat(Bat bat){
        this.getMammals().add(bat);
        ++this.batCount;
    }

    public void addCat(Cat cat){
        this.getMammals().add(cat);
        ++this.catCount;
    }
    
    public void addDog(Dog dog){
        this.getMammals().add(dog);
        ++this.dogCount;
    }
}
