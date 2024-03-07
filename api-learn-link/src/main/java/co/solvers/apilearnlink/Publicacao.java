package co.solvers.apilearnlink;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Publicacao {

    private int id;
    private String titulo;
    private String descricao;
    private int tipoPostagem;
    private Date data;
    private String hora;
    private int fkUsuario;
    private int fkPostagem;

    List<Imagem> imagens = new ArrayList<>();
    List<Reacao> reacoes = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTipoPostagem() {
        return tipoPostagem;
    }

    public void setTipoPostagem(int tipoPostagem) {
        this.tipoPostagem = tipoPostagem;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(int fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public int getFkPostagem() {
        return fkPostagem;
    }

    public void setFkPostagem(int fkPostagem) {
        this.fkPostagem = fkPostagem;
    }

    public List<Imagem> getImagens() {
        return imagens;
    }

    public void setImagens(List<Imagem> imagens) {
        this.imagens = imagens;
    }

    public List<Reacao> getReacoes() {
        return reacoes;
    }

    public void setReacoes(List<Reacao> reacoes) {
        this.reacoes = reacoes;
    }
}
