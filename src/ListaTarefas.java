import excecoes.ExcecaoLimiteCaracteresDescricao;
import excecoes.ExcecaoLimiteCaracteresNome;

import java.util.ArrayList;
import java.util.HashMap;

public class ListaTarefas {
    private HashMap<String, Tarefa> listaTarefas = new HashMap<>();

    private boolean tamanhoString(String nome, String descricao) {
        try {
            if (nome.length() > 26) {
                throw new ExcecaoLimiteCaracteresNome();
            }else if (descricao.length() > 400) {
                throw new ExcecaoLimiteCaracteresDescricao();
            }else {
                return true;
            }
        } catch (ExcecaoLimiteCaracteresNome e) {
            System.out.println(e.getMessage());
            return false;
        } catch (ExcecaoLimiteCaracteresDescricao e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // Sobrecarga de métodos
    public void adicionarTarefa(String nome, String descricao, byte nivelPrioridade) {
        if (tamanhoString(nome, descricao)) {
            listaTarefas.put(nome.trim(), new Tarefa(nome.trim(), descricao.trim(), nivelPrioridade));
        }else {
            System.out.println("Os dados não apresentam os criterios");
        }
    }
    public void adicionarTarefa(String nome, String descricao) {
        if (tamanhoString(nome, descricao)) {
            listaTarefas.put(nome.trim(), new Tarefa(nome.trim(), descricao.trim(), (byte) 0));
        }else {
            System.out.println("Os dados não apresentam os criterios");
        }
    }
    public void adicionarTarefa(String nome, byte nivelPrioridade) {
        if (nome.length() <= 26) {
            listaTarefas.put(nome.trim(), new Tarefa(nome.trim(), " ", nivelPrioridade));
        }else {
            System.out.println("Os dados não apresentam os criterios");
        }
    }
    public void adicionarTarefa(String nome) {
        if (nome.length() <= 26) {
            listaTarefas.put(nome.trim(), new Tarefa(nome.trim(), " ", (byte) 0));
        }else {
            System.out.println("Os dados não apresentam os criterios");
        }
    }

    public ArrayList<Tarefa> tarefasConcluidas() {
        ArrayList<Tarefa> tarefasS = new ArrayList<>();

        listaTarefas.forEach((chave, valor) -> {
            tarefasS.add(valor);
        });
        return tarefasS;
    }

    public void mudarNomeTarefa(String antigoNome, String novoNome) {
        try {
            Tarefa tarefa = listaTarefas.get(antigoNome);
            listaTarefas.put(novoNome, new Tarefa(novoNome, tarefa.getDescricao(), tarefa.getNivelPrioridade()));
            listaTarefas.remove(antigoNome);
        } catch (NullPointerException e) {
            System.out.println("Tarefa antiga não encontrada.");
        }
    }

    public String pegarTarefa(String nome) {
        try {
            Tarefa tarefa = listaTarefas.get(nome);
            return tarefa.getNome().toUpperCase() + ": " + tarefa.getDescricao() + " #" + String.valueOf(tarefa.getNivelPrioridade()) + " | " + tarefa.getStatus();
        }catch (NullPointerException e) {
            return " --- VAZIO --- ";
        }
    }

    public Tarefa pegarObjTarefa(String nome) {
        Tarefa objTarefa;
        try {
            objTarefa = listaTarefas.get(nome);
        }catch (NullPointerException e) {
            System.out.println("Tarefa não existe!: " + e.getMessage());
            objTarefa = null;
        }
        return objTarefa;
    }

    public boolean tarefaExiste(String nome) { return listaTarefas.containsKey(nome); }

    public void excluir(String nome) {
        try {
            listaTarefas.remove(nome);
        }catch (NullPointerException e) {
            System.out.println("Tarefa não encontrada ou falta nome da tarefa");
        }
    }
}
