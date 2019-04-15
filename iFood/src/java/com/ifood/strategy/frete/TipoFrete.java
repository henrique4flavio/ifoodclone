
package com.ifood.strategy.frete;
import com.ifood.strategy.frete.FreteBicicleta;
import com.ifood.strategy.frete.FreteNormal;


public enum TipoFrete {

	BICICLETA {
		@Override
		public Frete obterFrete() {
			return new FreteBicicleta();
		}
	},
	NORMAL {
		@Override
		public Frete obterFrete() {
			return new FreteNormal();
		}
	};
	
	public abstract Frete obterFrete();
	
}
