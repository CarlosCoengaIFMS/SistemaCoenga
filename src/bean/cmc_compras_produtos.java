/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import java.util.Date;

/**
 *
 * @author notedarckbr
 */
public class cmc_compras_produtos {

    private int cmc_id_compra_produto;
    private int cmc_id_compra;
    private int cmc_id_produto;
    private int cmc_quantidade;
    private double cmc_valor_unitario;
    private double cmc_valor_total;

    public int getCmc_id_compra_produto() {
        return cmc_id_compra_produto;
    }

    public void setCmc_id_compra_produto(int cmc_id_compra_produto) {
        this.cmc_id_compra_produto = cmc_id_compra_produto;
    }

    public int getCmc_id_compra() {
        return cmc_id_compra;
    }

    public void setCmc_id_compra(int cmc_id_compra) {
        this.cmc_id_compra = cmc_id_compra;
    }

    public int getCmc_id_produto() {
        return cmc_id_produto;
    }

    public void setCmc_id_produto(int cmc_id_produto) {
        this.cmc_id_produto = cmc_id_produto;
    }

    public int getCmc_quantidade() {
        return cmc_quantidade;
    }

    public void setCmc_quantidade(int cmc_quantidade) {
        this.cmc_quantidade = cmc_quantidade;
    }

    public double getCmc_valor_unitario() {
        return cmc_valor_unitario;
    }

    public void setCmc_valor_unitario(double cmc_valor_unitario) {
        this.cmc_valor_unitario = cmc_valor_unitario;
    }

    public double getCmc_valor_total() {
        return cmc_valor_total;
    }

    public void setCmc_valor_total(double cmc_valor_total) {
        this.cmc_valor_total = cmc_valor_total;
    }

}
