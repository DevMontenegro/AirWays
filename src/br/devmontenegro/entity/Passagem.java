/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.devmontenegro.entity;

/**
 *
 * @author Gustavo Montenegro
 */
public class Passagem {
    private int id;
    private String local_inicio;
    private String  local_final;
    private Double valor_total;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the local_inicio
     */
    public String getLocal_inicio() {
        return local_inicio;
    }

    /**
     * @param local_inicio the local_inicio to set
     */
    public void setLocal_inicio(String local_inicio) {
        this.local_inicio = local_inicio;
    }

    /**
     * @return the local_final
     */
    public String getLocal_final() {
        return local_final;
    }

    /**
     * @param local_final the local_final to set
     */
    public void setLocal_final(String local_final) {
        this.local_final = local_final;
    }

    /**
     * @return the valor_total
     */
    public Double getValor_total() {
        return valor_total;
    }

    /**
     * @param valor_total the valor_total to set
     */
    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }
}
