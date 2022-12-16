public class Prova {

    private float nota;
    private ConteudoProva conteudoProva;
    private TipoProva tipoProva;

    public Prova(float nota, ConteudoProva conteudoProva, TipoProva tipoProva) {
        this.nota = nota;
        this.conteudoProva = conteudoProva;
        this.tipoProva = tipoProva;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public ConteudoProva getConteudoProva() {
        return conteudoProva;
    }

    public void setConteudoProva(ConteudoProva conteudoProva) {
        this.conteudoProva = conteudoProva;
    }

    @Override
    public String toString() {
        return "Conteúdo da prova: " + conteudoProva.toString() + ". Nota: " + nota + ". Tipo de prova: " +
                tipoProva.toString();
    }
}
