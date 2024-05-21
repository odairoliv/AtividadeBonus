public class ObrasDeArte {
    private String titulo;
    private String artista;
    private int anoCricao;
    private String tipoDeObra;
    private String localizacaoMuseu;

    public ObrasDeArte() {
    }

    public ObrasDeArte(String titulo, String artista, int anoCricao, String tipoDeObra, String localizacaoMuseu) {
        this.titulo = titulo;
        this.artista = artista;
        this.anoCricao = anoCricao;
        this.tipoDeObra = tipoDeObra;
        this.localizacaoMuseu = localizacaoMuseu;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getAnoCricao() {
        return anoCricao;
    }

    public void setAnoCricao(int anoCricao) {
        this.anoCricao = anoCricao;
    }

    public String getTipoDeObra() {
        return tipoDeObra;
    }

    public void setTipoDeObra(String tipoDeObra) {
        this.tipoDeObra = tipoDeObra;
    }

    public String getLocalizacaoMuseu() {
        return localizacaoMuseu;
    }

    public void setLocalizacaoMuseu(String localizacaoMuseu) {
        this.localizacaoMuseu = localizacaoMuseu;
    }

}
