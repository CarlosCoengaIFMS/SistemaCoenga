/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import java.util.Date;
import java.sql.Timestamp;

/**
 *
 * @author notedarckbr
 */
public class cmc_vendedor {

    private int cmc_id_vendedor;
private String cmc_nome;
private String cmc_email;
private String cmc_usuario;
private String cmc_senha;
private String cmc_cpf;
private String cmc_telefone;
private String cmc_ativo;
private Timestamp cmc_data_nascimento;
private Timestamp cmc_data_cadastro;

    public int getCmc_id_vendedor() {
        return cmc_id_vendedor;
    }

    public void setCmc_id_vendedor(int cmc_id_vendedor) {
        this.cmc_id_vendedor = cmc_id_vendedor;
    }

    public String getCmc_nome() {
        return cmc_nome;
    }

    public void setCmc_nome(String cmc_nome) {
        this.cmc_nome = cmc_nome;
    }

    public String getCmc_email() {
        return cmc_email;
    }

    public void setCmc_email(String cmc_email) {
        this.cmc_email = cmc_email;
    }

    public String getCmc_usuario() {
        return cmc_usuario;
    }

    public void setCmc_usuario(String cmc_usuario) {
        this.cmc_usuario = cmc_usuario;
    }

    public String getCmc_senha() {
        return cmc_senha;
    }

    public void setCmc_senha(String cmc_senha) {
        this.cmc_senha = cmc_senha;
    }

    public String getCmc_cpf() {
        return cmc_cpf;
    }

    public void setCmc_cpf(String cmc_cpf) {
        this.cmc_cpf = cmc_cpf;
    }

    public String getCmc_telefone() {
        return cmc_telefone;
    }

    public void setCmc_telefone(String cmc_telefone) {
        this.cmc_telefone = cmc_telefone;
    }

    public String getCmc_ativo() {
        return cmc_ativo;
    }

    public void setCmc_ativo(String cmc_ativo) {
        this.cmc_ativo = cmc_ativo;
    }

    public Timestamp getCmc_data_nascimento() {
        return cmc_data_nascimento;
    }

    public void setCmc_data_nascimento(Timestamp cmc_data_nascimento) {
        this.cmc_data_nascimento = cmc_data_nascimento;
    }

    public Timestamp getCmc_data_cadastro() {
        return cmc_data_cadastro;
    }

    public void setCmc_data_cadastro(Timestamp cmc_data_cadastro) {
        this.cmc_data_cadastro = cmc_data_cadastro;
    }


  
}
