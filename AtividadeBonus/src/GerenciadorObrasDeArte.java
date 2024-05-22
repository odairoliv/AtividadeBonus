import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class GerenciadorObrasDeArte {

    private static final String ARQUIVO_OBRAS = "obras.txt";

    public static void salvarObraDeArte(ObrasDeArte obra) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO_OBRAS, true))) {
            bw.write(obra.formatarParaSalvar());
            bw.newLine();
        }
    }

    public static void apagarDados() {
        try (FileWriter fw = new FileWriter(ARQUIVO_OBRAS);
        BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static ArrayList<ObrasDeArte> lerObrasDeArte() throws IOException {
        ArrayList<ObrasDeArte> obrasDeArteCadastradas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO_OBRAS))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                ObrasDeArte obra = new ObrasDeArte(dados[0], dados[1], Integer.parseInt(dados[2]), dados[3], dados[4]);

                obrasDeArteCadastradas.add(obra);
            }
        }
        return obrasDeArteCadastradas;
    }
}
