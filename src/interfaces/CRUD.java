/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classe.Contato;
import java.util.ArrayList;

/**
 *
 * @author jhene
 */
public interface CRUD {

    void incluir(Contato objeto) throws Exception;

    public ArrayList<Contato> recuperar() throws Exception;

    public void excluir(String nome) throws Exception;

}
