package com.ifood.strategy.frete;

/**
 *
 * @author jonat
 */
public class FreteNormal implements Frete {

    @Override
    public double calculaFrete(double valorDoFrete) {

        return valorDoFrete;

    }
}
