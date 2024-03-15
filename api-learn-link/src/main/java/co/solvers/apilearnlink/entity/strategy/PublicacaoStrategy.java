package co.solvers.apilearnlink.entity.strategy;

import co.solvers.apilearnlink.entity.Publicacao;
import org.springframework.http.ResponseEntity;

public interface PublicacaoStrategy {

    ResponseEntity<Publicacao> publicar(Publicacao publicacao);
}
