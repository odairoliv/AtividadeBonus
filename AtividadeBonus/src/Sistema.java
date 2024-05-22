import java.io.IOException;
import java.util.List;

public class Sistema {

    public static void iniciar() {
        exibirMenu();
    }

    private static void exibirMenu() {
        while (true) {
            System.out.println("---- Menu de Obras de Arte ----");
            System.out.println("1. Cadastrar nova obra de arte");
            System.out.println("2. Buscar obra de arte");
            System.out.println("3. Listar todas as obras de arte");
            System.out.println("4. Atualizar dados de uma obra de arte");
            System.out.println("5. Excluir uma obra de arte");
            System.out.println("6. Busca avançada");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = Console.lerInt();

            switch (opcao) {
                case 0:
                    System.out.println("Saindo do sistema...");
                    return;
                case 1:
                    cadastrarObraDeArte();
                    break;
                case 2:
                    buscarObraDeArte();
                    break;
                case 3:
                    listarObrasDeArte();
                    break;
                case 4:
                    try {
                        atualizarObraDeArte();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    excluirObraDeArte();
                    break;
                case 6:
                    buscaAvancada();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void cadastrarObraDeArte() {
        System.out.println("---- Cadastro de Obras de Arte ----");

        System.out.print("Digite o título da obra: ");
        String titulo = Console.lerString();

        System.out.print("Digite o nome do artista: ");
        String artista = Console.lerString();

        System.out.print("Digite o ano de criação: ");
        int anoCriacao = Console.lerInt();

        System.out.print("Digite a localização no museu: ");
        String localizacao = Console.lerString();

        System.out.println("Escolha o tipo de obra:");
        System.out.println("1. Pintura");
        System.out.println("2. Escultura");
        System.out.println("3. Fotografia");
        System.out.print("Escolha uma opção: ");
        int optipo = Console.lerInt();

        ObrasDeArte obra = null;

        switch (optipo) {
            case 1:
                System.out.print("Digite a técnica da pintura: ");
                String tecnica = Console.lerString();
                obra = new Pintura(titulo, artista, anoCriacao, localizacao, tecnica);
                break;
            case 2:
                System.out.print("Digite o material da escultura: ");
                String material = Console.lerString();
                obra = new Escultura(titulo, artista, anoCriacao, localizacao, material);
                break;
            case 3:
                System.out.print("Digite o tipo de câmera da fotografia: ");
                String tipoCamera = Console.lerString();
                obra = new Fotografia(titulo, artista, anoCriacao, localizacao, tipoCamera);
                break;
            default:
                System.out.println("Tipo de obra inválido.");
                return;
        }

        try {
            GerenciadorObrasDeArte.salvarObraDeArte(obra);
            System.out.println("Obra de arte cadastrada com sucesso!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void buscarObraDeArte() {
        System.out.print("Digite o título da obra a ser buscada: ");
        String titulo = Console.lerString();

        try {
            ObrasDeArte obra = GerenciadorObrasDeArte.buscarObra(titulo);
            System.out.println("\n---- Obra encontrada ----\n" + obra.toString() + "\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void listarObrasDeArte() {
        System.out.println("\n---- Obras Cadastradas ----");

        try {
            for (ObrasDeArte obra : GerenciadorObrasDeArte.lerObrasDeArte()) {
                System.out.println(obra);
                System.out.println("---------------");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void atualizarObraDeArte() throws Exception {
        System.out.println("\n---- Atualizar Dados da Obra ----");
        System.out.print("Digite o título da obra a ser atualizada: ");
        String titulo = Console.lerString();
        ObrasDeArte obra = GerenciadorObrasDeArte.buscarObra(titulo);
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

            System.out.println("Escolha o tipo de obra:");
            System.out.println("1. Pintura");
            System.out.println("2. Escultura");
            System.out.println("3. Fotografia");
            int tipoEscolha = Console.lerInt();

            String novoTipoObra;
            ObrasDeArte novaObra;
            
            switch (tipoEscolha) {
                case 1:
                    novoTipoObra = "Pintura";
                    System.out.print("Digite a nova técnica da pintura: ");
                    String novaTecnica = Console.lerString();
                    novaObra = new Pintura(novoTitulo, novoArtista, novoAnoCriacao, novoTipoObra, novaTecnica);
                    break;
                case 2:
                    novoTipoObra = "Escultura";
                    System.out.print("Digite o novo material da escultura: ");
                    String novoMaterial = Console.lerString();
                    novaObra = new Escultura(novoTitulo, novoArtista, novoAnoCriacao, novoTipoObra, novoMaterial);
                    break;
                case 3:
                    novoTipoObra = "Fotografia";
                    System.out.print("Digite o novo tipo de câmera utilizada: ");
                    String novoTipoCamera = Console.lerString();
                    novaObra = new Fotografia(novoTitulo, novoArtista, novoAnoCriacao, novoTipoObra, novoTipoCamera);
                    break;
                default:
                    System.out.println("Tipo de obra inválido.");
                    return;
            }

            System.out.print("Digite a nova localização no museu: ");
            String novaLocalizacao = Console.lerString();
            novaObra.setLocalizacaoMuseu(novaLocalizacao);

            GerenciadorObrasDeArte.atualizarObra(titulo, novaObra);
            System.out.println("Dados da obra atualizados com sucesso!");
        } else {
            System.out.println("Obra não encontrada.");
        }
    }

    private static void excluirObraDeArte() {
        System.out.println("\n---- Excluir Obra de Arte ----");
        System.out.print("Digite o título da obra a ser excluída: ");
        String titulo = Console.lerString();

        try {
            GerenciadorObrasDeArte.apagarObra(titulo);
            System.out.println("\nObra excluída com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void buscaAvancada() {
        System.out.println("\n---- Busca Avançada ----");
        System.out.println("Escolha o critério de busca:");
        System.out.println("1. Por Artista");
        System.out.println("2. Por Ano de Criação");
        System.out.println("3. Por Tipo de Obra");
        int escolha = Console.lerInt();

        switch (escolha) {
            case 1:
                buscarPorArtista();
                break;
            case 2:
                buscarPorAno();
                break;
            case 3:
                buscarPorTipo();
                break;
            default:
                System.out.println("Critério de busca inválido.");
        }
    }

    private static void buscarPorArtista() {
        System.out.print("Digite o nome do artista: ");
        String artista = Console.lerString();

        try {
            List<ObrasDeArte> obras = GerenciadorObrasDeArte.buscarPorArtista(artista);
            if (obras.isEmpty()) {
                System.out.println("Nenhuma obra encontrada para o artista: " + artista);
            } else {
                System.out.println("\n---- Obras encontradas ----");
                for (ObrasDeArte obra : obras) {
                    System.out.println(obra);
                    System.out.println("---------------");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void buscarPorAno() {
        System.out.print("Digite o ano de criação: ");
        int ano = Console.lerInt();
    
        try {
            List<ObrasDeArte> obras = GerenciadorObrasDeArte.buscarPorAno(ano);
            if (obras.isEmpty()) {
                System.out.println("Nenhuma obra encontrada para o ano de criação: " + ano);
            } else {
                System.out.println("\n---- Obras encontradas ----");
                for (ObrasDeArte obra : obras) {
                    System.out.println(obra);
                    System.out.println("---------------");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void buscarPorTipo() {
        System.out.print("Digite o tipo de obra (Pintura, Escultura, Fotografia): ");
        String tipo = Console.lerString();
    
        try {
            List<ObrasDeArte> obras = GerenciadorObrasDeArte.buscarPorTipo(tipo);
            if (obras.isEmpty()) {
                System.out.println("Nenhuma obra encontrada para o tipo: " + tipo);
            } else {
                System.out.println("\n---- Obras encontradas ----");
                for (ObrasDeArte obra : obras) {
                    System.out.println(obra);
                    System.out.println("---------------");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
