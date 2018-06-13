/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

import interfaces.TratamentoDeDados;

/**
 *
 * @author jhenerson
 */
public class Endereco implements TratamentoDeDados {

    private String logradouro = "";
    private int numero = 0;

    public Endereco() {
    }

    public Endereco(String logradouro, int numero) {
        this.logradouro = logradouro;
        this.numero = numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public void materializar(String dados) throws Exception {
        String vetorDados[] = dados.split(";");
        if (vetorDados.length != 2) {
            throw new Exception("Faltam dados na string");
        }
        logradouro = vetorDados[0];
        numero = Integer.parseInt(vetorDados[1]);
    }

    @Override
    public String desmaterializar() {
        String saida = logradouro + ";" + numero;
        return saida;
    }

}
