// entende-se turma como um conjunto de alunos. Foi aceito pelo professor
import java.util.ArrayList;
public class Turma {
    private ArrayList<Aluno> alunos = new ArrayList<Aluno>(); // sem capacidade inicial definida

    public Turma() { // construtor vazio. Posso fazer isto?
    }

    // adiciona aluno
    public boolean adicionaAluno(Aluno aluno) {
        if (alunos.contains(aluno))
            return false; // verdadeiro se bem sucedido, falso caso contrário
        alunos.add(aluno);
        return true;
    }

    // remove aluno, falta remover por list iterator para não haja erros
    public boolean removeAluno(Aluno aluno) {
        if (alunos.contains(aluno)) {
            alunos.remove(aluno);
            return true;
        }
        return false; // mesma lógica vista acima
    }

    // busca aluno por matrícula
    public int buscaPorMatricula(int matricula) {
        for (int i = 0; i < alunos.size(); i++)
            if (matricula == alunos.get(i).getMatricula())
                return i;
        return -1;
    }

    // retorna aluno por posicao
    public Aluno alunoNaPosicao(int i) {
        return alunos.get(i);
    }

    // altera idade
    public boolean alteraIdadeAluno(int matricula, int novaIdade) {
        if (buscaPorMatricula(matricula) == -1)
            return false; // se o aluno não está na turma, a operação não é realizada, então false
        alunos.get(buscaPorMatricula(matricula)).setIdade(novaIdade);
        return true;
    }

    // está na turma?
    public boolean estaNaTurma(Aluno aluno) {
        return alunos.contains(aluno);
    }

    @Override
    public String toString() {
        String string = "";
        for (Aluno aluno: alunos) {
            string += aluno.toString() + "\n";
        }
        return string;
    }


}
