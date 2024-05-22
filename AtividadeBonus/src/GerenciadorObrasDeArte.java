import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class GerenciadorObrasDeArte {

    private static final String ARQUIVO_OBRAS = "obras.txt";

    public static void salvarObraDeArte(ObrasDeArte obra) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO_OBRAS, true))) {
            bw.write(obra.formatarParaSalvar());
            bw.newLine();
        }
    }

    public static void apagarObra(String titulo) throws Exception {
        ArrayList<ObrasDeArte> listaObras = lerObrasDeArte();

        boolean encontrou = false;
        for (ObrasDeArte temp : listaObras) {
            if (temp.getTitulo().equals(titulo)) {
                listaObras.remove(temp);
                encontrou = true;
                break;
            }
        }

        if (!encontrou) {
            throw new Exception("\nObra " + titulo + " não localizada!");
        }

        // sobrescrever arquivo com array list atualizado:
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO_OBRAS, false))) {
            for (ObrasDeArte o : listaObras) {
                bw.write(o.formatarParaSalvar());
                bw.newLine();
            }
        }
    }

    public static ObrasDeArte buscarObra(String titulo) throws Exception {
        ArrayList<ObrasDeArte> listaObras = lerObrasDeArte();

        for (ObrasDeArte tempObra : listaObras) {
            if (tempObra.getTitulo().equals(titulo)) {
                return tempObra;
            }
        }

        throw new Exception("\nObra " + titulo + " não localizada!");
    }

    public static void atualizarObra(String titulo, ObrasDeArte obraAtualizada) throws Exception {
        ArrayList<ObrasDeArte> listaObras = lerObrasDeArte();

        boolean encontrou = false;
        for (int i = 0; i < listaObras.size(); i++) {
            ObrasDeArte temp = listaObras.get(i);
            if (temp.getTitulo().equals(titulo)) {
                listaObras.set(i, obraAtualizada);
                encontrou = true;
                break;
            }
        }

        if (!encontrou) {
            throw new Exception("\nObra " + titulo + " não localizada!");
        }

        // Sobrescrever arquivo com array list atualizado
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO_OBRAS, false))) {
            for (ObrasDeArte o : listaObras) {
                bw.write(o.formatarParaSalvar());
                bw.newLine();
            }
        }
    }

    public static ArrayList<ObrasDeArte> lerObrasDeArte() throws IOException, Exception {
        ArrayList<ObrasDeArte> obrasDeArteCadastradas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO_OBRAS))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                ObrasDeArte obra;
                String tipoDeObra = dados[3];

                switch (tipoDeObra) {
                    case "Pintura":
                        obra = new Pintura(dados[0], dados[1], Integer.parseInt(dados[2]), dados[4], dados[5]);
                        break;
                    case "Escultura":
                        obra = new Escultura(dados[0], dados[1], Integer.parseInt(dados[2]), dados[4], dados[5]);
                        break;
                    case "Fotografia":
                        obra = new Fotografia(dados[0], dados[1], Integer.parseInt(dados[2]), dados[4], dados[5]);
                        break;
                    default:
                        obra = new ObrasDeArte(dados[0], dados[1], Integer.parseInt(dados[2]), dados[3], dados[4]);
                        break;
                }

                obrasDeArteCadastradas.add(obra);
            }
        }

        if (obrasDeArteCadastradas.isEmpty()) {
            throw new Exception("\nNão há obras cadastradas");
        }

        return obrasDeArteCadastradas;
    }

    public static List<ObrasDeArte> buscarPorArtista(String artista) throws IOException, Exception {
        ArrayList<ObrasDeArte> listaObras = lerObrasDeArte();
        List<ObrasDeArte> resultadoBusca = new ArrayList<>();

        for (ObrasDeArte obra : listaObras) {
            if (obra.getArtista().equalsIgnoreCase(artista)) {
                resultadoBusca.add(obra);
            }
        }

        return resultadoBusca;
    }

    public static List<ObrasDeArte> buscarPorAno(int ano) throws IOException, Exception {
        ArrayList<ObrasDeArte> listaObras = lerObrasDeArte();
        List<ObrasDeArte> resultadoBusca = new ArrayList<>();

        for (ObrasDeArte obra : listaObras) {
            if (obra.getAnoCricao() == ano) {
                resultadoBusca.add(obra);
            }
        }

        return resultadoBusca;
    }

    public static List<ObrasDeArte> buscarPorTipo(String tipo) throws IOException, Exception {
        ArrayList<ObrasDeArte> listaObras = lerObrasDeArte();
        List<ObrasDeArte> resultadoBusca = new ArrayList<>();

        for (ObrasDeArte obra : listaObras) {
            if (obra.getTipoDeObra().equalsIgnoreCase(tipo)) {
                resultadoBusca.add(obra);
            }
        }

        return resultadoBusca;
    }

}
