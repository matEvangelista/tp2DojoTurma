import java.util.Objects;

public class Aluno {
    private int matricula;
    private String nome;
    private int idade;

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
        return matricula == aluno.matricula && idade == aluno.idade && Objects.equals(nome, aluno.nome);
    }

    // toString, será utilizado para exibir dados de um aluno
    @Override
    public String toString() {
        return "Nome: " + nome +". Matrícula: " + matricula + ". Idade: " + idade;
    }

    // setter (apenas idade pode ser alterada)
    public void setIdade(int idade) {
        this.idade = idade;
    }

    // getters
    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    // ver o porquê disto depois, aula de 13/12
/*    @Override
    public int hashCode() {
        return Objects.hash(matricula, nome, idade);
    }
*/
}
