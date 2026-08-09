import java.util.ArrayList;

public class Comando {
    private ListaTarefas listaTarefas;

    Comando(ListaTarefas listaTarefas) { this.listaTarefas = listaTarefas; }

    public void comandos(String[] val) {
        String cmd = val[0];
        if(val.length > 1) {
            //Retira as aspas simples antes de buscar pela tarefa
            String nomeTarefa = val[1].replace("'", "").trim();
            if (listaTarefas.tarefaExiste(nomeTarefa)) {
                switch (cmd) {
                    case "concluir":
                        Tarefa tarefa = listaTarefas.pegarObjTarefa(nomeTarefa);
                        tarefa.setStatus(true);
                        break;

                    case "excluir":
                        listaTarefas.excluir(nomeTarefa);
                        break;

                    case "alterar":
                        //!alterar 'NOME DA TAREFA' oq_alterar 'valor'
                        if(val.length >= 4){
                            String oqAlterar = val[2];
                            String valor = val[3].replace("'", "");
                            System.out.println(cmd + " " + nomeTarefa + " " + oqAlterar + " " + valor);
                            aleteracaoTarefa(oqAlterar, valor, nomeTarefa);
                        }else {
                            System.err.println("Falta valores, padrão para alteração: !alterar 'NOME DA TAREFA' oq_alterar 'valor'");
                        }
                        break;

                    case "historico":
                        ArrayList<Tarefa> tarefas = listaTarefas.tarefasConcluidas();

                        tarefas.forEach((valor) -> {
                            if(valor.getStatus()) {
                                System.out.println(valor.getNome() + ": CONCLUIDA");
                            }
                        });
                    break;
                    default:
                        System.out.println("Comando não reconhecido: " + cmd);
                }
            } else {
                System.out.println("Tarefa não existe!");
            }
        }else if(cmd.equals("help")){
            System.out.println("Instruções");
        }else if(!cmd.equals("exit")) {
            System.out.println("Falta nome da tarefa.");
        }
    }


    private void aleteracaoTarefa(String oqAlterar, String valor, String nomeTarefa) {
        switch(oqAlterar) {
            case "nome":
                listaTarefas.mudarNomeTarefa(nomeTarefa, valor);
            break;
            case "descricao":
                listaTarefas.pegarObjTarefa(nomeTarefa).setDescricao(valor);
            break;
            case "prioridade":
                String prioridade = valor.replaceAll("[^0-9]+", "");
                listaTarefas.pegarObjTarefa(nomeTarefa).setNivelPrioridade(Byte.valueOf(prioridade));
            break;
            default:
                System.out.println("O valor oqAlterar não existe no switch");
        }
    }
}
