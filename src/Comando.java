import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Comando {
    private ListaTarefas listaTarefas;

    Comando(ListaTarefas listaTarefas) {
        this.listaTarefas = listaTarefas;
    }

    public void comandos(String[] val) {
        String cmd = val[0], nomeTarefa;

        if (val.length > 1) {
            //Retira as aspas simples antes de buscar pela tarefa
            nomeTarefa = val[1].replace("'", "").trim();
        }else {
            nomeTarefa = "";
        }

        switch (cmd) {
            case "concluir":
                Tarefa tarefa = listaTarefas.pegarObjTarefa(nomeTarefa);
                if (tarefa != null) {
                    tarefa.setStatus(true);
                } else {
                    System.out.println("Tarefa não encontrada ou falta nome da tarefa");
                }
            break;

            case "excluir":
                listaTarefas.excluir(nomeTarefa);
            break;

            case "alterar":
                //!alterar 'NOME DA TAREFA' oq_alterar 'valor'
                try {
                    if (val.length >= 4) {
                        String oqAlterar = val[2];
                        String valor = val[3].replace("'", "");
                        System.out.println(cmd + " " + nomeTarefa + " " + oqAlterar + " " + valor);
                        aleteracaoTarefa(oqAlterar, valor, nomeTarefa);
                    } else {
                        System.err.println("Falta valores, padrão para alteração: !alterar 'NOME DA TAREFA' oq_alterar 'valor'");
                    }
                } catch (NullPointerException e) {
                    System.out.println("Tarefa não encontrada ou falta nome da tarefa: " + e.getMessage());
                }
            break;

            case "historico":
                ArrayList<Tarefa> tarefas = listaTarefas.tarefasConcluidas();

                tarefas.forEach((valor) -> {
                    if (valor.getStatus()) {
                        System.out.println(valor.getNome() + ": CONCLUIDA");
                    }
                });
            break;

            case "ajuda":
                try {
                    String conteudo = Files.readString(Path.of("ajuda.txt"));
                    System.out.println(conteudo);
                } catch (IOException e) {
                    System.out.println("Erro ao ler o arquivo de ajuda: " + e.getMessage());
                }
            break;

            case "sair":
                break;
            default:
                System.out.println("Comando não reconhecido: " + cmd);
        }
    }


    private void aleteracaoTarefa(String oqAlterar, String valor, String nomeTarefa) {
        switch (oqAlterar) {
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
