package kreis.aula;

public class Principal {
    public static void main(String[] args) {
        ModificacaoCadastroController controller = new ModificacaoCadastroController();
        controller.novoCadastro(41, 60, 8000.00);
        controller.novoCadastro(31, 40, 5000.00);
        controller.novoCadastro(21, 30, 3000.00);
    }
}