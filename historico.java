import java.util.ArrayList;
import java.util.List;

public class Historico {
    private final List<HistoricoCalculo> registros = new ArrayList<>();

    public void adicionar(HistoricoCalculo registro) {
        registros.add(registro);
    }

    public void exibir() {
        if (registros.isEmpty()) {
            System.out.println("Nenhum cálculo realizado ainda.");
        } else {
            System.out.println("\n=== HISTÓRICO DE CÁLCULOS ===");
            for (RegistroCalculo r : registros) {
                System.out.println(r.toString());
            }
            System.out.println("==============================");
        }
    }

    public void limpar() {
        registros.clear();
    }
}
