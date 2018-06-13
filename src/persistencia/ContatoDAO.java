/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classe.Contato;
import interfaces.CRUD;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author jhene
 */
public class ContatoDAO implements CRUD {
    
    private String nomeArquivo = "";
    String newLine = System.getProperty("line.separator");
    
    public ContatoDAO(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }
    
    @Override
    public void incluir(Contato objeto) throws Exception {
        try {
            //cria arquivo
            FileWriter fileWriter = new FileWriter(nomeArquivo,true);

            //cria o buffer do arquivo
            BufferedWriter escrever = new BufferedWriter(fileWriter);

            //escreve no arquivo
            escrever.write(objeto.desmaterializar()+ newLine);

            //fecha arquivo
            escrever.close();
            
        } catch (IOException erro) {
            throw erro;
        }
    }
    
    @Override
    public ArrayList<Contato> recuperar() throws Exception {
        try {
            ArrayList<Contato> listaDeContatos = new ArrayList<>();
            FileReader fileReader = new FileReader(nomeArquivo);
            BufferedReader leitor = new BufferedReader(fileReader);
            String linha = "";
            
            while ((linha = leitor.readLine()) != null) {
                Contato objetoContato = new Contato();
                objetoContato.materializar(linha);
                listaDeContatos.add(objetoContato);
            }
            leitor.close();
            return listaDeContatos;
        } catch (IOException erro) {
            throw erro;
        }
        
    }
    
    @Override
    public void excluir(String nome) throws Exception {
        try {
            ArrayList<Contato> listaDeContatos = this.recuperar();
            //cria arquivo
            FileWriter fileWriter = new FileWriter(nomeArquivo);
            //cria buffer do arquivo
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < listaDeContatos.size(); i++) {
                Contato aux = listaDeContatos.get(i);
                if (!(aux.getNome().equals(nome))) {
                    bufferedWriter.write(aux.desmaterializar()+ newLine);
                }                
            }
            bufferedWriter.close();
        } catch (Exception e) {
        }
    }
    
    public String getNomeArquivo() {
        return nomeArquivo;
    }
    
    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }
}
