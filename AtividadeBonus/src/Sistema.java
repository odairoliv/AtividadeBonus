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
                case 4:
                    atualizarObraDeArte();
                    break;
                case 5:
                    excluirObraDeArte();
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
        System.out.println("4. Atualizar dados de uma obra de arte");
        System.out.println("5. Excluir uma obra de arte");
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

    public static void atualizarObraDeArte() {
        System.out.println("\n---- Autalizar Dados da Obra ----");
        System.out.print("Digite o título da obra a ser atualizada: ");
        String titulo = Console.lerString();
        ObrasDeArte obra = buscarObraDeArte(titulo);
        if (obra != null) {
            System.out.println("Obra encontrada:\n" + obra.toString());
            System.out.println("---- Atualização de Cadastro ----");

            System.out.print("Digite o novo título da obra: ");
            String novoTitulo = Console.lerString();
            obra.setTitulo(novoTitulo);

            System.out.print("Digite o novo nome do artista: ");
            String novoArtista = Console.lerString();
            obra.setArtista(novoArtista);

            System.out.print("Digite o novo ano de criação: ");
            int novoAnoCriacao = Console.lerInt();
            obra.setAnoCricao(novoAnoCriacao);

            System.out.print("Digite o novo tipo de obra: ");
            String novoTipoObra = Console.lerString();
            obra.setTipoDeObra(novoTipoObra);

            System.out.print("Digite a nova localização no museu: ");
            String novaLocalizacao = Console.lerString();
            obra.setLocalizacaoMuseu(novaLocalizacao);

            System.out.println("Dados da obra atualizados com sucesso!");
        } else {
            System.out.println("Obra não encontrada.");
        }
    }

    public static void excluirObraDeArte() {
        System.out.println("\n---- Excluir Obra de Arte ----");
        System.out.print("Digite o título da obra a ser excluída: ");
        String titulo = Console.lerString();
        ObrasDeArte obra = buscarObraDeArte(titulo);
        if (obra != null) {
            obrasDeArteCadastradas.remove(obra);
            System.out.println("Obra excluída com sucesso!");
        } else {
            System.out.println("Obra não encontrada.");
        }
    }
}
