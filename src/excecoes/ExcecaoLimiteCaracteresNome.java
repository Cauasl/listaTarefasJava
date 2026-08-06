package excecoes;

public class ExcecaoLimiteCaracteresNome extends Exception {
    @Override
    public String getMessage() {
        return "O nome da tarefa excedeu o limite de 26 caracteres";
    }
}
