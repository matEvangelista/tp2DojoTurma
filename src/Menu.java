import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Turma turma = new Turma();

    // pode construtor vazio?
    public Menu() {
    }

    public void menuItself() {
        boolean continua = true;
        do {
            mostraOpcoes();
            int opcao = leOpcao();
            switch (opcao) {
                case 0:
                    continua = adeus();
                    break;
                case 1:
                    cadastraAluno();
                    break;
                case 2:
                    listaAlunos();
                    break;
                case 3:
                    buscaPorMatricula();
                    break;
                case 4:
                    removePorMatricula();
                    break;
                case 5:
                    alteraIdade();
                    break;
            }
        } while (continua);
    }

    // mostra opcoes
    private void mostraOpcoes() {
        System.out.println("O que você quer fazer?");
        System.out.println("1) Adicionar um aluno\n" +
                "2) Listar todos os alunos\n" +
                "3) Busca por matrícula\n" +
                "4) Remover aluno por matrícula\n" +
                "5) Alterar a idade de um aluno em específico\n" +
                "0) Sair\n");
    }


    // lê opcao do aluno
    private int leOpcao() { // usar uma exception, talvez? Não acho necessário, mas sei lá
        boolean incorreto = true;
        int op;
        while (true) {
            System.out.print("Digite uma opcao: ");
            op = scanner.nextInt();
            consomeEnter();
            if (op >= 0 && op <= 5)
                break;
            System.out.println("Digite um valor correto. Tente novamente");
        }
        return op;
    }

    // cadastra aluno
    private void cadastraAluno() {
        String nome = leNome();
        int idade = leIdade();
        int matricula = leMatricula();
        int pos = turma.buscaPorMatricula(matricula);
        if (pos != -1)
            System.out.println("O aluno não pôde ser cadastrado porque ele já está na turma ou há conflito de" +
                    "matrículas");
        else {
            Aluno aluno = new Aluno(matricula, nome, idade);
            turma.adicionaAluno(aluno);
            System.out.println("Aluno adicionado com sucesso!");
        }
    }

    // lista todos os alunos
    private void listaAlunos() {
        System.out.println(turma);
    }

    // busca por matricula
    private void buscaPorMatricula() {
        int matricula = leMatricula();
        int posicao = turma.buscaPorMatricula(matricula);
        if (posicao != -1)
            System.out.println(turma.alunoNaPosicao(posicao));
        else {
            System.out.println("Aluno não está na turma");
        }
    }

    // remove por matrícula
    private void removePorMatricula() {
        int matricula = leMatricula();
        int posicao = turma.buscaPorMatricula(matricula);
        if (posicao == -1)
            System.out.println("O aluno não está na turma, portanto não pode ser removido");
        else {
            Aluno alunoASerRemovido = turma.alunoNaPosicao(posicao);
            turma.removeAluno(alunoASerRemovido);
            System.out.println("Aluno removido com sucesso!");
        }
    }

    // muda idade de um aluno
    private void alteraIdade() {
        int matricula = leMatricula();
        int posicao = turma.buscaPorMatricula(matricula);
        if (posicao == -1)
            System.out.println("O aluno pelo qual você procura não está na turma");
        else {
            int idade = leIdade();
            turma.alunoNaPosicao(posicao).setIdade(idade);
            System.out.println("Idade cadastrada com sucesso.");
        }
    }

    private boolean adeus() {
        System.out.println("Adeus");
        return false; // para sair do loop infinito que mostra o menu
    }

    // lê nome
    private String leNome() {
        System.out.print("Digite o nome do aluno: ");
        return scanner.nextLine();
    }

    // lê idade
    private int leIdade() {
        int idade;
        while (true) {
            System.out.print("Digite a idade do aluno: ");
            idade = scanner.nextInt();
            consomeEnter();
            if (idade > 0)
                break;
            System.out.println("Digite a idade corretamente.");
        }
        return idade;
    }

    // lê matrícula
    private int leMatricula() {
        int matricula;
        while (true) {
            System.out.printf("Digite uma matrícula: ");
            matricula = scanner.nextInt();
            consomeEnter();
            if (matricula > 0)
                break;
            System.out.println("Digite corretamente.");
        }
        return matricula;
    }

    // consome enter
    public void consomeEnter() {
        scanner.nextLine();
    }

}
