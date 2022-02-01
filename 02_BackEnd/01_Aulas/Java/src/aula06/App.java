package aula06;

public class App {
    private static final int QTD_MAX_AGUA = 100;
    private static final int QTD_MAX_CAFE = 50;
    //private static final int QTD_CAFEZINHO = 10;
    public static void main(String[] args) {
        Cafeteira cafeteira = new Cafeteira(QTD_MAX_AGUA, QTD_MAX_CAFE);

        cafeteira.fazerCafe();
        cafeteira.ligar();
        cafeteira.fazerCafe();
        cafeteira.fazerCafe();
        cafeteira.fazerCafe();
        //cafeteira.colocarAgua(200);
        cafeteira.desligar();
        cafeteira.fazerCafe();
    }
}
