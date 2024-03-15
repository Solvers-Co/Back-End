package co.solvers.apilearnlink.controller;

import co.solvers.apilearnlink.entity.Publicacao;
import co.solvers.apilearnlink.entity.TipoPublicacaoEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/publicacoes")
public class PublicacaoController {

    List<Publicacao> publicacoes = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Publicacao> publicar(@RequestBody Publicacao publicacao){

        if (publicacao.getTipoPublicacao() != TipoPublicacaoEnum.COMUM){
            ResponseEntity.status(400).build();
        }

        if (publicacao.getTitulo() == null || publicacao.getDescricao() == null){
            ResponseEntity.status(400).build();
        }

        publicacoes.add(publicacao);

        return ResponseEntity.status(201).body(publicacao);
    }

    @GetMapping
    public ResponseEntity<List<Publicacao>> listarPublicacoes(){

        if (publicacoes.isEmpty()){
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(publicacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publicacao> listarPublicacaoID(@PathVariable int id){

        Publicacao publicacao = buscarPublicacaoPorID(id);

        if (publicacao == null){
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(200).body(publicacao);
    }

    @GetMapping("/comum")
    public ResponseEntity<List<Publicacao>> listarPublicacoesComum(){

        if (publicacoes.isEmpty()){
            return ResponseEntity.status(204).build();
        }

       List<Publicacao> publicacoesComum = publicacoes
                .stream()
                .filter(publicacao -> publicacao.getTipoPublicacao() == TipoPublicacaoEnum.COMUM)
                .toList();

        return ResponseEntity.status(200).body(publicacoesComum);
    }

    @PostMapping("/comentarios")
    public ResponseEntity<Publicacao> comentar(@RequestBody Publicacao comentario){

        Publicacao publicacao = buscarPublicacaoPorID(comentario.getFkPostagem());

        if (publicacao == null){
            return ResponseEntity.status(404).build();
        }

        if (publicacao.getDescricao() == null ||
                publicacao.getFkPostagem() == 0){
            return ResponseEntity.status(400).build();
        }

        publicacao.setComentarios(comentario);

        return ResponseEntity.status(201).body(comentario);
    }

    @GetMapping("/{id}/comentarios")
    public ResponseEntity<List<Publicacao>> listarComentarios(@PathVariable int id){

        Publicacao publicacao = buscarPublicacaoPorID(id);

        if (publicacao == null){
            return ResponseEntity.status(404).build();
        }

        if (publicacao.getComentarios().isEmpty()){
            return ResponseEntity.status(204).build();
        }

       return ResponseEntity.status(200).body(publicacao.getComentarios());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Publicacao> editarPublicacao (@PathVariable int id, @RequestBody Publicacao publicacao){

        Publicacao publicacaoAtualizar = buscarPublicacaoPorID(id);

        if (publicacaoAtualizar == null){
            ResponseEntity.status(404).build();
        }

        switch (publicacao.getTipoPublicacao()){
            case COMUM:

                if (publicacao.getTitulo() == null || publicacao.getDescricao() == null){
                    ResponseEntity.status(400).build();
                }

                publicacaoAtualizar.setTitulo(publicacao.getTitulo());
                publicacaoAtualizar.setDescricao(publicacao.getDescricao());

                return ResponseEntity.status(200).body(publicacaoAtualizar);

            case COMENTARIO:

                if (publicacao.getDescricao() == null) {
                    ResponseEntity.status(400).build();
                }

                publicacaoAtualizar.setDescricao(publicacao.getDescricao());

                return ResponseEntity.status(200).body(publicacaoAtualizar);
        }

        return ResponseEntity.status(400).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(int id){

        Publicacao publicacao = buscarPublicacaoPorID(id);

        if (publicacao == null){
            ResponseEntity.status(404).build();
        }

        publicacoes.remove(publicacao);

        return ResponseEntity.status(204).build();
    }

    public Publicacao buscarPublicacaoPorID (int id){

        return publicacoes
                .stream()
                .filter(publicacao -> publicacao.getId() == id)
                .findFirst()
                .orElse(null);
    }



}
