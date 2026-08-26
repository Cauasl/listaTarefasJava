import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Controle {
    private ListaTarefas listaTarefas = new ListaTarefas();
    private Comando comando = new Comando(listaTarefas);

    public void entrada(String entr) throws ArrayIndexOutOfBoundsException {
        //Verifica se é um comando ou tarefa.
        if (entr.contains("!") && !entr.contains(":") && !entr.contains("#")) {
            String txt = entr.trim().replaceFirst(".*!([a-zA-Z]+)", "$1"); //Retira tudo antes da exclamação
            String[] txt2 = txt.split(" (?=(?:[^']*'[^']*')*[^']*$)"); //Separa a string por espaço, mas ignora oq estiver dentro de aspas simples

            comando.comandos(txt2);

        }else { //Se passar pela verificação da formatação
            String tarefa = semCaracteresEntradaParecidos(entr.trim().replaceAll("![a-zA-Z]+", ""));

            if(tarefa.length() > 3) {
                if (tarefa.contains(":") && tarefa.contains("#")) {
                    String[] tarefaRepartida = tarefa.split(":"); //Separa a string em dois [Nome da tarefa, descrição e prioridade]
                    String[] descr = tarefaRepartida[1].split("#"); //Separa a string em dois [decrição, prioridade]

                    String nome = tarefaRepartida[0];
                    byte prioridade = Byte.valueOf(descr[1].replaceAll("[^0-9]", ""));

                    listaTarefas.adicionarTarefa(nome, descr[0].trim(), prioridade);
                    //System.out.println(": e # - " + listaTarefas.pegarTarefa(nome));
                } else if (tarefa.contains(":") && !tarefa.contains("#")) {
                    String[] tarefaRepartida = tarefa.split(":");

                    listaTarefas.adicionarTarefa(tarefaRepartida[0], tarefaRepartida[1]);
                    //System.out.println(": e !# - " + listaTarefas.pegarTarefa(tarefaRepartida[0].trim()));
                } else if (tarefa.contains("#")) {
                    String[] tarefaRepartida = tarefa.split("#");

                    listaTarefas.adicionarTarefa(tarefaRepartida[0], Byte.valueOf(tarefaRepartida[1].trim()));
                    //System.out.println("# - " + listaTarefas.pegarTarefa(tarefaRepartida[0].trim()));
                } else {
                    listaTarefas.adicionarTarefa(tarefa);
                    //System.out.println("Ultimo - " + listaTarefas.pegarTarefa(tarefa));
                }
            }else {
                System.out.println("Tarefa vazia");
            }
        }
    }


    public void naoConcluidas() {
        ArrayList<Tarefa> tarefas = listaTarefas.tarefasConcluidas();

        tarefas.forEach((valor) -> {
            if(!valor.getStatus()) {
                System.out.println(valor.getNome() + ": " + valor.getDescricao() + " #" + valor.getNivelPrioridade());
            }
        });

    }
    

    //Retira as caracteres de comando repetidas
    private String semCaracteresEntradaParecidos(String texto) {
        Set<Character> visto = new HashSet<>();
        StringBuilder resposta = new StringBuilder();

        for (char caractere : texto.toCharArray()) {
            if ((caractere == ':' || caractere == '#') && visto.contains(caractere)) {
                continue;
            }
            if (caractere == ':' || caractere == '#') {
                visto.add(caractere);
            }
            resposta.append(caractere);
        }
        return resposta.toString();
    }
}
