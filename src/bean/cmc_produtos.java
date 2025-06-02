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
public class cmc_produtos {
    private int cmc_id_produtos;
    private String cmc_nome;
    private String cmc_descricao;
    private boolean cmc_preco;
    private int cmc_quantidade;
    private String cmc_categoria;
    private int cmc_id_fornedor;
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

    public boolean isCmc_preco() {
        return cmc_preco;
    }

    public void setCmc_preco(boolean cmc_preco) {
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

    public int getCmc_id_fornedor() {
        return cmc_id_fornedor;
    }

    public void setCmc_id_fornedor(int cmc_id_fornedor) {
        this.cmc_id_fornedor = cmc_id_fornedor;
    }

    public Timestamp getCmc_data_cadastro() {
        return cmc_data_cadastro;
    }

    public void setCmc_data_cadastro(Timestamp cmc_data_cadastro) {
        this.cmc_data_cadastro = cmc_data_cadastro;
    }

  
}
