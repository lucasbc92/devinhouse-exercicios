package ex01.entities;

public class PersonBook {
    protected String name;
    protected long age;
    protected int heightCm;

    public PersonBook(String name, long age, int heightCm){
        this.name = name;
        this.age = age;
        this.heightCm = heightCm;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

     public long getAge(){
        return this.age;
    }

    public void doBirthday(){
        this.age++;
    }

    public int getHeight(){
        return this.heightCm;
    }

    public void setHeight(int heightCm){
        this.heightCm = heightCm;
    }

    public String toString(){
        String pluralYear = "";
        if(this.getAge() > 1) {
            pluralYear = "s";
        }
        return String.format("Name: %s%nAge: %d year%s old%nHeight: %dcm%n", 
            this.getName(),
            this.getAge(),
            pluralYear,
            this.getHeight()
        );
    }
}
