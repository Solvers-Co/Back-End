package co.solvers.apilearnlink.entity.strategy;

import co.solvers.apilearnlink.entity.Publicacao;
import org.springframework.http.ResponseEntity;

public class PublicacaoComum implements PublicacaoStrategy{

    @Override
    public ResponseEntity<Publicacao> publicar(Publicacao publicacao) {
        return null;
    }
}
