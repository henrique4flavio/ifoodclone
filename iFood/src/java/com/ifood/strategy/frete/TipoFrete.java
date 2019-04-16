package com.ifood.strategy.frete;

import com.ifood.strategy.frete.FreteBicicleta;
import com.ifood.strategy.frete.FreteNormal;

public enum TipoFrete {

    NORMAL {
                @Override
                public Frete obterFrete() {
                    return new FreteNormal();
                }
            },
    BICICLETA {
                @Override
                public Frete obterFrete() {
                    return new FreteBicicleta();
                }
            },
    EXPRESSO {
                @Override
                public Frete obterFrete() {
                    return new FreteExpresso();

                }
            };

    public abstract Frete obterFrete();

}
