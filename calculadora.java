public class Calculadora {

    // A calculadora agora apenas executa a operação que lhe é passada (Strategy Pattern)
    public double calcular(double num1, double num2, OperacaoMatematica operacao) {
        return operacao.executar(num1, num2);
    }
}
