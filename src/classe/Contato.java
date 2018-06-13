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
public class Contato implements TratamentoDeDados {

    private String nome = "";
    private String email = "";
    private Telefone telefone = null;
    private Endereco enderecoResidencial = null;
    private String caminhoFoto = "";
    

    public Contato() {}

    public Contato(String nome, String email, Telefone telefoneResidencial, Endereco enderecoResidencial,String caminhoFoto) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefoneResidencial;
        this.enderecoResidencial = enderecoResidencial;
        this.caminhoFoto = caminhoFoto;
        
        

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return enderecoResidencial;
    }

    public void setEndereco(Endereco endereco) {
        this.enderecoResidencial = endereco;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    @Override
    public void materializar(String dados) throws Exception {
        String vetorDados[] = dados.split(";");
        if (vetorDados.length != 8) {
            throw new Exception("Faltam dados");
        }
        this.nome = vetorDados[0];
        this.email = vetorDados[1];

        telefone = new Telefone(Integer.parseInt(vetorDados[2]),
                Integer.parseInt(vetorDados[3]),
                Integer.parseInt(vetorDados[4]));

        enderecoResidencial = new Endereco(vetorDados[5], Integer.parseInt(vetorDados[6]));
        caminhoFoto = vetorDados[7];

    }

    @Override
    public String desmaterializar() {
        String saida = nome + ";" + email + ";";
        saida += telefone.desmaterializar() + ";";
        saida += enderecoResidencial.desmaterializar()+";";
        saida += caminhoFoto;
        return saida;

    }

    public Endereco getEnderecoResidencial() {
        return enderecoResidencial;
    }

    public void setEnderecoResidencial(Endereco enderecoResidencial) {
        this.enderecoResidencial = enderecoResidencial;
    }

    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    public void setCaminhoFoto(String caminhoFoto) {
        this.caminhoFoto = caminhoFoto;
    }
  
}
