public class Soma implements Operacao {
    @Override
    public double executar(double num1, double num2) {
        return num1 + num2;
    }

    @Override
    public String getSimbolo() {
        return "+";
    }
}
