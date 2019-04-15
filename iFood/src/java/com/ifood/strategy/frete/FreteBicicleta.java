package com.ifood.strategy.frete;

/**
 *
 * @author jonat
 */
public class FreteBicicleta implements Frete {

    @Override
    public double calculaFrete(double valorDoFrete) {
        double calculo = valorDoFrete - (valorDoFrete * 0.30);

        return calculo;

    }

}
