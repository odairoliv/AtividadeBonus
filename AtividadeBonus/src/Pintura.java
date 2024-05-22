public class Pintura extends ObrasDeArte {
    private String tecnica;

    public Pintura(String titulo, String artista, int anoCriacao, String localizacaoMuseu, String tecnica) {
        super(titulo, artista, anoCriacao, "Pintura", localizacaoMuseu);
        this.tecnica = tecnica;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    @Override
    public String formatarParaSalvar() {
        return super.formatarParaSalvar() + ";" + tecnica;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTécnica: " + tecnica;
    }
}
