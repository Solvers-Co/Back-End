package co.solvers.apilearnlink.entity;

import co.solvers.apilearnlink.entity.strategy.PublicacaoAnuncio;
import co.solvers.apilearnlink.entity.strategy.PublicacaoComentario;
import co.solvers.apilearnlink.entity.strategy.PublicacaoComum;
import co.solvers.apilearnlink.entity.strategy.PublicacaoStrategy;

public enum TipoPublicacaoEnum {

    COMUM(new PublicacaoComum()),
    COMENTARIO(new PublicacaoComentario()),
    ANUNCIO(new PublicacaoAnuncio());

    private PublicacaoStrategy tipoPublicacao;

    TipoPublicacaoEnum(PublicacaoStrategy tipoPublicacao) {
        this.tipoPublicacao = tipoPublicacao;
    }

    public PublicacaoStrategy getTipoPublicacao() {
        return tipoPublicacao;
    }
}
