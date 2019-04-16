package com.ifood.strategy.frete;

/**
 *
 * @author jonat
 */
public class FreteExpresso implements Frete {

    @Override
    public double calculaFrete(double valorDoFrete) {
        double calculo = valorDoFrete + (valorDoFrete * 0.50);
        return calculo;

    }
}
