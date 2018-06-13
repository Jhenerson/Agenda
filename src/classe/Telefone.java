/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

/**
 *
 * @author jhene
 */
public class Telefone {

    private int DDI = 0;
    private int DDD = 0;
    private int numeroTelefone = 0;

    public Telefone() {
    }

    public Telefone(int DDI, int DDD, int numeroTelefone) {
        this.DDI = DDI;
        this.DDD = DDD;
        this.numeroTelefone = numeroTelefone;
    }

    public int getDDI() {
        return DDI;
    }

    public void setDDI(int DDI) {
        this.DDI = DDI;
    }

    public int getDDD() {
        return DDD;
    }

    public void setDDD(int DDD) {
        this.DDD = DDD;
    }

    public int getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(int numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public void materializar(String dados) throws Exception {
        String vetorDados[] = dados.split(";");
        if (vetorDados.length != 3) {
            throw new Exception("Faltam dados");
        }
        this.DDI = Integer.parseInt(vetorDados[0]);
        this.DDD = Integer.parseInt(vetorDados[1]);
        this.numeroTelefone = Integer.parseInt(vetorDados[2]);
    }

    public String desmaterializar() {
        String saida = DDI + ";" + DDD + ";" + numeroTelefone;
        return saida;
    }

    public String getTelefone() {
        return "+" + DDI + " " + DDD + " " + numeroTelefone;
    }
}
