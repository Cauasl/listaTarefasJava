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
        controle.entrada(entrada);


        for(int i=0; i<5; i++) {
            System.out.println(" ");
        }
    }while(!entrada.equals("!exit") );
}
