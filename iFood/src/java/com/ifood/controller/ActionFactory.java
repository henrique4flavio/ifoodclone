/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifood.controller;

/**
 *
 * @author jonat
 */
public class ActionFactory {

    public static Action create(String pacote, String action) {

        Action actionObject = null;
        String nomeClasse = "com.ifood.action."+pacote+"." + action + "Action";
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();

        } catch (Exception ex) {
            return null;
        }

        if (!(objeto instanceof Action)) {
            return null;
        }
        actionObject = (Action) objeto;
        return actionObject;
    }
}
