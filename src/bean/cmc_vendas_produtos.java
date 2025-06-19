/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

/**
 *
 * @author notedarckbr
 */
public class cmc_vendas_produtos {

    private int cmc_id_venda_produto;
    private int cmc_fk_venda;
    private int cmc_fk_produto;
    private int cmc_quantidade;
    private double cmc_valor_unitario;
    private double cmc_valor_total;

    public int getCmc_id_venda_produto() {
        return cmc_id_venda_produto;
    }

    public void setCmc_id_venda_produto(int cmc_id_venda_produto) {
        this.cmc_id_venda_produto = cmc_id_venda_produto;
    }

    public int getCmc_fk_venda() {
        return cmc_fk_venda;
    }

    public void setCmc_fk_venda(int cmc_fk_venda) {
        this.cmc_fk_venda = cmc_fk_venda;
    }

    public int getCmc_fk_produto() {
        return cmc_fk_produto;
    }

    public void setCmc_fk_produto(int cmc_fk_produto) {
        this.cmc_fk_produto = cmc_fk_produto;
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
