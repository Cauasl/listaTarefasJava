//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Controle controle = new Controle();
    Scanner sc = new Scanner(System.in);

    System.out.println("TAREFAS");
    System.out.println(" > NOME DA TAREFA: descricao #prioridade(1-3) ");
    System.out.println("");
    System.out.println("");
    System.out.println("Comandos: !help, !concluir 'NOME DA TAREFA', !excluir 'NOME DA TAREFA'");

    String entrada = sc.nextLine();
    controle.entrada(entrada);

    do {
        System.out.println("TAREFAS");
        System.out.println(" > NOME DA TAREFA: descricao #prioridade(1-3) ");

        System.out.println("");
        System.out.println("");
        System.out.println("Comandos: !help, !concluir 'NOME DA TAREFA', !excluir 'NOME DA TAREFA'");


        System.out.println("Insira um comando ou tarefa seguindo o exemplo acima.");
        entrada = sc.nextLine();
        controle.entrada(entrada);

    } while (!entrada.equals("!exit"));
}
