public class Escultura extends ObrasDeArte {
    private String material;

    public Escultura(String titulo, String artista, int anoCriacao, String localizacaoMuseu, String material) {
        super(titulo, artista, anoCriacao, "Escultura", localizacaoMuseu);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String formatarParaSalvar() {
        return super.formatarParaSalvar() + ";" + material;
    }

    @Override
    public String toString() {
        return super.toString() + "\nMaterial: " + material;
    }
}
