package excecoes;

public class ExcecaoLimiteCaracteresDescricao extends Exception {
    @Override
    public String getMessage() {
        return "A descrição da tarefa excedeu o limite de 400 caracteres";
    }
}
