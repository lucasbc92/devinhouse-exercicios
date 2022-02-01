package aula06;

public class Cafeteira {
    private boolean isLigada;
    private int mlAgua;
    private int gCafe;
    private Filtro filtro = new Filtro();
    private Moedor moedor = new Moedor();

    public Cafeteira(int maxQtdAgua, int maxQtdCafe){
        this.isLigada = false;
        this.mlAgua = maxQtdAgua;
        this.gCafe = maxQtdCafe;
    }

    private boolean podeFazerCafe(){
        return this.isLigada && this.hasAgua() && this.hasCafe();
    }

    private boolean hasAgua(){
        return this.mlAgua > 0;
    }

    public void colocarAgua(int qtdMl){
        this.mlAgua += qtdMl;
    }

    public int getMlAgua() {
        return this.mlAgua;
    }

    private boolean hasCafe(){
        return this.gCafe > 0;
    }

    public void colocarCafe(int qtdG){
        this.gCafe += qtdG;
    }

    public int getGCafe() {
        return this.gCafe;
    }

    public void ligar(){
        this.isLigada = true;
    }

    public void desligar(){
        this.isLigada = false;
    }

    public void fazerCafe(){
        if(this.podeFazerCafe()) {   
            this.gCafe -= this.moedor.moerCafe();
            this.mlAgua -= this.filtro.filtrarCafe();
            System.out.printf("Estou fazendo %dml de café!%n", this.filtro.getMlAgua());
        }      
    }
}
