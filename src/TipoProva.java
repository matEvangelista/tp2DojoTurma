public enum TipoProva {
    AVALIACAO1("prova 1"),
    AVALIACAO2("prova 2"),
    PROVA_FINAL("prova final");

    private final String descricao;
    TipoProva(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String
    toString() {
        return descricao;
    }
}
