package school.sptech;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;

public class Publicacao {

    private String titulo;
    private String texto;
    private int qtdComentarios;
    private int qtdLikes;
    private LocalDate dataPublicacao;

    public Publicacao(String titulo, String texto, int qtdComentarios, int qtdLikes, LocalDate dataPublicacao) {
        this.titulo = titulo;
        this.texto = texto;
        this.qtdComentarios = qtdComentarios;
        this.qtdLikes = qtdLikes;
        this.dataPublicacao = dataPublicacao;
    }

    public Publicacao() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getQtdComentarios() {
        return qtdComentarios;
    }

    public void setQtdComentarios(int qtdComentarios) {
        this.qtdComentarios = qtdComentarios;
    }

    public int getQtdLikes() {
        return qtdLikes;
    }

    public void setQtdLikes(int qtdLikes) {
        this.qtdLikes = qtdLikes;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public void publicacaoMaisRecente(Publicacao[] v) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        int x, y;
        Publicacao z;
        LocalDate k;
        for (x = 1; x < v.length; x++) {
            k = v[x].dataPublicacao;
            z = v[x];
            for (y = x - 1;y >= 0 && v[y].dataPublicacao.compareTo(k) < 0;y--) {
                v[y+1] = v[y];
            }
            v[y+1] = z;
        }
        for (Publicacao post : v)
        System.out.println(post);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Publicacao{");
        sb.append("titulo='").append(titulo).append('\'');
        sb.append(", texto='").append(texto).append('\'');
        sb.append(", qtdComentarios=").append(qtdComentarios);
        sb.append(", qtdLikes=").append(qtdLikes);
        sb.append(", dataPublicacao=").append(dataPublicacao);
        sb.append('}');
        return sb.toString();
    }
}
