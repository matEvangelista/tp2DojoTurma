import java.util.Arrays;
import java.util.Objects;

public class Aluno {
    private int matricula;
    private String nome;
    private int idade;
    private Prova[] provas = new Prova[3]; // aluno tem 3 provas

    public Aluno(int matricula, String nome, int idade) {
        this.matricula = matricula;
        this.nome = nome;
        this.idade = idade;
    }

    // necessário para utilizar o arraylist na classe turma
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return matricula == aluno.matricula && idade == aluno.idade && Objects.equals(nome, aluno.nome) && Arrays.equals(provas, aluno.provas);
    }

    // toString, será utilizado para exibir dados de um aluno
    @Override
    public String toString() {
        String mediaMensagem, situacao, notas;
        if (media() == -1) {
            situacao = "indeterminada";
            mediaMensagem = "indeterminada";
        } else {
            mediaMensagem = String.format("%.2f", media());
            situacao = estaAprovado() ? "aprovado" : "reprovado";
        }
        return "Nome: " + nome +". Matrícula: " + matricula + ". Idade: " + idade + "\nNotas\nP1: " +
                (provas[0] == null ? "sem nota" : provas[0].toString()) +
                "\nP2: " + (provas[1] == null ? "sem nota": provas[1].toString()) + "\nP3: " + (provas[2] == null ? "indeterminado"
                : provas[2].toString()) + "\nMédia: " + mediaMensagem +
                "\nSituação: " + situacao;
    }

    // calcula média
    private float media() {
        int i = 0;
        float soma = 0;
        for (i = 0; i < 3; i++) {
            if(provas[i] != null)
                soma += provas[i].getNota();
            else
                break;
        }
        if (i > 0)
            return  soma / (i);
        return -1; // não é possível calcular a nota
    }

    // aprovado
    private boolean estaAprovado() {
        return media() >= 6;
    }

    // setter (apenas idade pode ser alterada)
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setProva(int numeroProva, Prova prova) {
        provas[numeroProva] = prova;
    }

    // getters
    public int getMatricula() {
        return matricula;
    }
// ver o porquê disto depois, aula de 13/12
/*    @Override
    public int hashCode() {
        return Objects.hash(matricula, nome, idade);
    }
*/
}
