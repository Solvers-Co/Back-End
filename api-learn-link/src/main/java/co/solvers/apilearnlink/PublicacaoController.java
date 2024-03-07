package co.solvers.apilearnlink;

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

        publicacoes.add(publicacao);

        return ResponseEntity.status(201).body(publicacao);
    }

    @GetMapping
    public ResponseEntity<List<Publicacao>> listarPublicacoes(){

        if (!publicacoes.isEmpty()){
            return ResponseEntity.status(200).body(publicacoes);
        }

        return ResponseEntity.status(204).build();

    }



}
