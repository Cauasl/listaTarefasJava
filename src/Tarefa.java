public class Tarefa {
    private String nome;
    private String descricao;
    private byte nivelPrioridade;
    private boolean status = false;

    Tarefa(String nome, String descricao, byte nivelPrioridade) {
        this.nome = nome;
        setDescricao(descricao);
        setNivelPrioridade(nivelPrioridade);
    }

    //Getters
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public byte getNivelPrioridade() { return nivelPrioridade; }
    public boolean getStatus() { return status; }


    //Setters
    public String setDescricao(String descricao) { return this.descricao = descricao; }


    public byte setNivelPrioridade(byte nivelPrioridade) {
        if(nivelPrioridade > 3) {
            throw new RuntimeException("O valor da prioridade não pode passar de 3");
        }else if (nivelPrioridade < 0) {
            throw new RuntimeException("O valor da prioridade não pode passar de 0");
        }else {
            return this.nivelPrioridade = nivelPrioridade;
        }
    }
    public boolean setStatus(boolean status) {
        return this.status = status;
    }
}
