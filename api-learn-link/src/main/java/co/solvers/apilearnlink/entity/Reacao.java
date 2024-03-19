package co.solvers.apilearnlink;

public class Reacao {

    private int id;
    private String nome;
    private int fkPostagem;
    private int fkTipoPostagem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getFkPostagem() {
        return fkPostagem;
    }

    public void setFkPostagem(int fkPostagem) {
        this.fkPostagem = fkPostagem;
    }

    public int getFkTipoPostagem() {
        return fkTipoPostagem;
    }

    public void setFkTipoPostagem(int fkTipoPostagem) {
        this.fkTipoPostagem = fkTipoPostagem;
    }
}
