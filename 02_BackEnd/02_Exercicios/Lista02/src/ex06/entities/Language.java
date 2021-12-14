package ex06.entities;

public class Language {
    private String name;
    private float version;

    public Language(){
        this.name = "Java";
        this.version = 1;
    }

    public Language(float version){
        this();
        this.version = version;
    }

    public Language(String name){
        this();
        this.name = name;
    }

    public Language(String name, float version){
        this(name);
        this.version = version;
    }

    public String getName(){
        return this.name;
    }

    public float getVersion(){
        return this.version;
    }

    public String toString(){
        return String.format("Language: %s - Version: %.2f%n", this.getName(), this.getVersion());
    }
}
