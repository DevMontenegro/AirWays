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
public class Vendas {
    private int id;
    private Clientes cliente; 
    private String data_venda;
    private double total_venda;
    private String local_inicio;
    private String local_final;
    private String obs;
    private int qtd;

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
     * @return the cliente
     */
    public Clientes getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the data_venda
     */
    public String getData_venda() {
        return data_venda;
    }

    /**
     * @param data_venda the data_venda to set
     */
    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }

    /**
     * @return the total_venda
     */
    public double getTotal_venda() {
        return total_venda;
    }

    /**
     * @param total_venda the total_venda to set
     */
    public void setTotal_venda(double total_venda) {
        this.total_venda = total_venda;
    }

    /**
     * @return the obs
     */
    public String getObs() {
        return obs;
    }

    /**
     * @param obs the obs to set
     */
    public void setObs(String obs) {
        this.obs = obs;
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
     * @return the qtd
     */
    public int getQtd() {
        return qtd;
    }

    /**
     * @param qtd the qtd to set
     */
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
