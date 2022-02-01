package aula06;

public class Filtro {
    private final int ML_AGUA = 5;

    public int filtrarCafe(){
        System.out.println("Filtrando café...");
        return ML_AGUA;
    }

    public int getMlAgua() {
        return this.ML_AGUA;
    }
}
