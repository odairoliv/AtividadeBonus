import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private static List<ObrasDeArte> obrasDeArteCadastradas = new ArrayList<>();

    public static void iniciar() {
        while (true) {
            exibirMenu();
            int opcao = Console.lerInt();

            switch (opcao) {
                case 0:
                    System.out.println("Saindo do sistema...");
                    return;
                case 1:
                    cadastrarObraDeArte();
                    break;
                case 2:
                    System.out.print("Digite o título da obra a ser buscada: ");
                    String titulo = Console.lerString();
                    ObrasDeArte obra = buscarObraDeArte(titulo);
                    if (obra != null) {
                        System.out.println("\n---- Obra encontrada ----\n" + obra.toString() + "\n");

                    } else {
                        System.out.println("Obra não encontrada.");
                    }
                    break;
                case 3:
                    listarObrasDeArte();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("---- Menu de Obras de Arte ----");
        System.out.println("1. Cadastrar nova obra de arte");
        System.out.println("2. Buscar obra de arte");
        System.out.println("3. Listar todas as obras de arte");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void cadastrarObraDeArte() {
        System.out.println("---- Cadastro de Obras de Arte ----");

        System.out.print("Digite o título da obra: ");
        String titulo = Console.lerString();

        System.out.print("Digite o nome do artista: ");
        String artista = Console.lerString();

        System.out.print("Digite o ano de criação: ");
        int anoCriacao = Console.lerInt();

        System.out.print("Digite o tipo de obra: ");
        String tipoObra = Console.lerString();

        System.out.print("Digite a localização no museu: ");
        String localizacao = Console.lerString();

        ObrasDeArte obra = new ObrasDeArte(titulo, artista, anoCriacao, tipoObra, localizacao);
        obrasDeArteCadastradas.add(obra);
        System.out.println("Obra de arte cadastrada com sucesso!");
    }

    public static ObrasDeArte buscarObraDeArte(String titulo) {
        for (ObrasDeArte obra : obrasDeArteCadastradas) {
            if (obra.getTitulo().equals(titulo)) {
                return obra;
            }
        }
        return null;
    }

    public static void listarObrasDeArte() {
        if (obrasDeArteCadastradas.isEmpty()) {
            System.out.println("Nenhuma obra de arte cadastrada.");
        } else {
            System.out.println("---- Lista de Obras de Arte Cadastradas ----\n");
            for (ObrasDeArte obra : obrasDeArteCadastradas) {
                System.out.println(obra.toString());
                System.out.println("-----------------------------------");
            }
        }
    }
}
