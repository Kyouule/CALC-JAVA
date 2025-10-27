import java.util.ArrayList;
import java.util.List;

public class Historico {
    // Composição: Historico é composto por uma lista de RegistroCalculo
    private final List<RegistroCalculo> registros = new ArrayList<>();

    // Associa o Historico com o RegistroCalculo
    public void adicionar(RegistroCalculo registro) {
        registros.add(registro);
    }

    // Exibe o histórico, usando o método toString() de RegistroCalculo
    public void exibir() {
        if (registros.isEmpty()) {
            System.out.println("Nenhum cálculo realizado ainda.");
        } else {
            System.out.println("\n=== HISTÓRICO DE CÁLCULOS ===");
            for (RegistroCalculo r : registros) {
                System.out.println(r.toString()); // Polimorfismo implícito do toString
            }
            System.out.println("==============================");
        }
    }

    public void limpar() {
        registros.clear();
    }
}
