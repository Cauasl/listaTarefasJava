//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Controle controle = new Controle();
    Scanner sc = new Scanner(System.in);
    String entrada;


    do {
        System.out.println("TAREFAS");
        controle.naoConcluidas();

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Comando !help para instruções.");
        System.out.print(" > ");
        entrada = sc.nextLine();
        try {
            controle.entrada(entrada);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("A tarefa ou comando não atende os critérios " + e);
        }



        for(int i=0; i<5; i++) {
            System.out.println(" ");
        }
    }while(!entrada.equals("!exit"));
}
