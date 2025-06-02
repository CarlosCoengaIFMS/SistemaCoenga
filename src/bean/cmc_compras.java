/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import java.security.Timestamp;
import java.util.Date;

/**
 *
 * @author notedarckbr
 */
public class cmc_compras {
    private int cmc_id_compra;
    private int cmc_id_fornecedor;
    private int cmc_id_produto;
    private int cmc_quantidade;
    private double cmc_valor_total;
    private Date cmc_data_compra;
    private String cmc_status;

    public int getCmc_id_compra() {
        return cmc_id_compra;
    }

    public void setCmc_id_compra(int cmc_id_compra) {
        this.cmc_id_compra = cmc_id_compra;
    }

    public int getCmc_id_fornecedor() {
        return cmc_id_fornecedor;
    }

    public void setCmc_id_fornecedor(int cmc_id_fornecedor) {
        this.cmc_id_fornecedor = cmc_id_fornecedor;
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

    public double getCmc_valor_total() {
        return cmc_valor_total;
    }

    public void setCmc_valor_total(double cmc_valor_total) {
        this.cmc_valor_total = cmc_valor_total;
    }

    public Date getCmc_data_compra() {
        return cmc_data_compra;
    }

    public void setCmc_data_compra(Date cmc_data_compra) {
        this.cmc_data_compra = cmc_data_compra;
    }

    public String getCmc_status() {
        return cmc_status;
    }

    public void setCmc_status(String cmc_status) {
        this.cmc_status = cmc_status;
    }
   
    
}
