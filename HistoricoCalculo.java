public class HistoricoCalculo {
    private final double num1;
    private final double num2;
    private final String simbolo;
    private final double resultado;

    public HistoricoCalculo(double num1, double num2, String simbolo, double resultado) {
        this.num1 = num1;
        this.num2 = num2;
        this.simbolo = simbolo;
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s %.2f = %.2f", num1, simbolo, num2, resultado);
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public double getResultado() {
        return resultado;
    }
}
