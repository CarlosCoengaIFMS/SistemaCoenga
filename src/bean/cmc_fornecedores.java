/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import java.security.Timestamp;

/**
 *
 * @author notedarckbr
 */
public class cmc_fornecedores {
    private int cmc_id_fornecedores;
    private String cmc_nome;
    private String cmc_telefone;
    private String cmc_email;
    private String cmc_senha;
    private String cmc_endereco;
    private String cmc_cidade;
    private String cmc_estado;
    private Timestamp cmc_data_cadastro;

    public int getCmc_id_fornecedores() {
        return cmc_id_fornecedores;
    }

    public void setCmc_id_fornecedores(int cmc_id_fornecedores) {
        this.cmc_id_fornecedores = cmc_id_fornecedores;
    }

    public String getCmc_nome() {
        return cmc_nome;
    }

    public void setCmc_nome(String cmc_nome) {
        this.cmc_nome = cmc_nome;
    }

    public String getCmc_telefone() {
        return cmc_telefone;
    }

    public void setCmc_telefone(String cmc_telefone) {
        this.cmc_telefone = cmc_telefone;
    }

    public String getCmc_email() {
        return cmc_email;
    }

    public void setCmc_email(String cmc_email) {
        this.cmc_email = cmc_email;
    }

    public String getCmc_senha() {
        return cmc_senha;
    }

    public void setCmc_senha(String cmc_senha) {
        this.cmc_senha = cmc_senha;
    }

    public String getCmc_endereco() {
        return cmc_endereco;
    }

    public void setCmc_endereco(String cmc_endereco) {
        this.cmc_endereco = cmc_endereco;
    }

    public String getCmc_cidade() {
        return cmc_cidade;
    }

    public void setCmc_cidade(String cmc_cidade) {
        this.cmc_cidade = cmc_cidade;
    }

    public String getCmc_estado() {
        return cmc_estado;
    }

    public void setCmc_estado(String cmc_estado) {
        this.cmc_estado = cmc_estado;
    }

    public Timestamp getCmc_data_cadastro() {
        return cmc_data_cadastro;
    }

    public void setCmc_data_cadastro(Timestamp cmc_data_cadastro) {
        this.cmc_data_cadastro = cmc_data_cadastro;
    }
    
    
}
