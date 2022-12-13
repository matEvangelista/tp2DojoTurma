import java.util.Scanner;
public class Menu {
    private Scanner scanner = new Scanner(System.in);
    public Menu() { // construtor vazio, posso fazer isto?
    }

    public void mostraOpcoes() {
        System.out.println("O que você quer fazer?");
        System.out.println("1) Adicionar um aluno" +
                "2) Listar todos os alunos" +
                "3) Busca por matrícula" +
                "4) Remover aluno por matrícula" +
                "5) Alterar a idade de um aluno em específico" +
                "0) Sair");
    }

    public int opcao(Scanner scanner) { // usar uma exception, talvez? Não acho necessário, mas sei lá
        boolean incorreto = true;
        int op;
        do {
            System.out.print("Digite uma opcao: ");
            op = scanner.nextInt();
            if (op >= 0 && op <= 5)
                incorreto = false;
            else
                System.out.println("Entrada incorreta");
        } while (incorreto);
        return op;
    }

}
