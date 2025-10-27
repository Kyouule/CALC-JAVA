public class Divisao implements Operacao {
    @Override
    public double executar(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Erro: divisão por zero não é permitida!");
        }
        return num1 / num2;
    }

    @Override
    public String getSimbolo() {
        return "/";
    }
}
