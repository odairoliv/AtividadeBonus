public class Fotografia extends ObrasDeArte {
    private String tipoCamera;

    public Fotografia(String titulo, String artista, int anoCriacao, String localizacaoMuseu, String tipoCamera) {
        super(titulo, artista, anoCriacao, "Fotografia", localizacaoMuseu);
        this.tipoCamera = tipoCamera;
    }

    public String getTipoCamera() {
        return tipoCamera;
    }

    public void setTipoCamera(String tipoCamera) {
        this.tipoCamera = tipoCamera;
    }

    @Override
    public String formatarParaSalvar() {
        return super.formatarParaSalvar() + ";" + tipoCamera;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipo de Câmera: " + tipoCamera;
    }
}
