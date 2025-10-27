public class Calculadora {

    public double calcular(double num1, double num2, Operacao operacao) {
        return operacao.executar(num1, num2);
    }
}
