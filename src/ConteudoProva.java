public class ConteudoProva {
    private final String conteudo; // assumindo que o conteúdo não vai mudar

    public ConteudoProva(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return conteudo;
    }
}
