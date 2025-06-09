/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author notedarckbr
 */
public class cmc_produtos {
    private int cmc_id_produtos;
    private String cmc_nome;
    private String cmc_descricao;
    private double cmc_preco;
    private int cmc_quantidade;
    private String cmc_categoria;
    private int cmc_id_fornecedor;
    private Timestamp cmc_data_cadastro;

    public int getCmc_id_produtos() {
        return cmc_id_produtos;
    }

    public void setCmc_id_produtos(int cmc_id_produtos) {
        this.cmc_id_produtos = cmc_id_produtos;
    }

    public String getCmc_nome() {
        return cmc_nome;
    }

    public void setCmc_nome(String cmc_nome) {
        this.cmc_nome = cmc_nome;
    }

    public String getCmc_descricao() {
        return cmc_descricao;
    }

    public void setCmc_descricao(String cmc_descricao) {
        this.cmc_descricao = cmc_descricao;
    }

    public double getCmc_preco() {
        return cmc_preco;
    }

    public void setCmc_preco(double cmc_preco) {
        this.cmc_preco = cmc_preco;
    }

    public int getCmc_quantidade() {
        return cmc_quantidade;
    }

    public void setCmc_quantidade(int cmc_quantidade) {
        this.cmc_quantidade = cmc_quantidade;
    }

    public String getCmc_categoria() {
        return cmc_categoria;
    }

    public void setCmc_categoria(String cmc_categoria) {
        this.cmc_categoria = cmc_categoria;
    }

    public int getCmc_id_fornecedor() {
        return cmc_id_fornecedor;
    }

    public void setCmc_id_fornecedor(int cmc_id_fornecedor) {
        this.cmc_id_fornecedor = cmc_id_fornecedor;
    }

    public Timestamp getCmc_data_cadastro() {
        return cmc_data_cadastro;
    }

    public void setCmc_data_cadastro(Timestamp cmc_data_cadastro) {
        this.cmc_data_cadastro = cmc_data_cadastro;
    }

    public void setCmc_data_de_cadastro(Date sqlDate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
