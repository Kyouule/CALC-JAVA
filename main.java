import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<Integer, Operacacao> OPERACOES = Map.of(
        1, new Soma(),
        2, new Subtracao(),
        3, new Multiplicacao(),
        4, new Divisao()
    );

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Calculadora calc = new Calculadora(); 
        Historico historico = new Historico(); 

        boolean continuar = true;

        while (continuar) {
            try {
                exibirMenuPrincipal();
                int menu = entrada.nextInt();

                switch (menu) {
                    case 1 -> realizarCalculo(entrada, calc, historico);
                    case 2 -> historico.exibir();
                    case 3 -> {
                        historico.limpar();
                        System.out.println("Histórico limpo com sucesso!");
                    }
                    case 4 -> {
                        System.out.println("Encerrando...");
                        continuar = false;
                    }
                    default -> System.out.println("Opção inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite um número.");
                entrada.next(); 
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            }
        }

        entrada.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n=== CALCULADORA SIMPLES (OO Refatorada) ===");
        System.out.println("1 - Calcular");
        System.out.println("2 - Ver histórico");
        System.out.println("3 - Limpar histórico");
        System.out.println("4 - Sair");
        System.out.print("Opção: ");
    }

    private static void realizarCalculo(Scanner entrada, Calculadora calc, Historico historico) {
        System.out.print("Digite o primeiro número: ");
        double num1 = entrada.nextDouble();

        System.out.print("Digite o segundo número: ");
        double num2 = entrada.nextDouble();

        exibirMenuOperacoes();
        int opcao = entrada.nextInt();

        Operacao operacaoSelecionada = OPERACOES.get(opcao); 
        if (operacaoSelecionada == null) {
            System.out.println("Opção de operação inválida!");
            return;
        }

        try {
            double resultado = calc.calcular(num1, num2, operacaoSelecionada);
            System.out.println("Resultado: " + resultado);

        
            HistoricoCalculo registro = new HistoricoCalculo(
                num1,
                num2,
                operacaoSelecionada.getSimbolo(),
                resultado
            );

            historico.adicionar(registro); 
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void exibirMenuOperacoes() {
        System.out.println("Escolha a operação:");
        OPERACOES.forEach((k, v) -> System.out.printf("%d - %s (%s)\n", k, v.getClass().getSimpleName(), v.getSimbolo()));
        System.out.print("Opção: ");
    }
}
