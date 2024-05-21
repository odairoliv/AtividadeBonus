import java.util.ArrayList;

public class Sistema {
    private static ArrayList<ObrasDeArte> obrasDeArteCadastradas = new ArrayList<>();

    public static void cadastrarObraDeArte() {
        System.out.println("Cadastro de Obras de Arte");

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
            if (obra.getTitulo().equalsIgnoreCase(titulo)) {
                return obra;
            }
        }
        return null;
    }
}
