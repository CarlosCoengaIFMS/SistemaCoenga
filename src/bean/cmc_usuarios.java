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
public class cmc_usuarios {

    private int cmc_id_usuario;
    private String cmc_nome;
    private String cmc_apelido;
    private String cmc_cpf;
    private Date cmc_data_nascimento;
    private int cmc_nivel;
    private String cmc_ativo;
    private String cmc_senha;

    public int getCmc_id_usuario() {
        return cmc_id_usuario;
    }

    public void setCmc_id_usuario(int cmc_id_usuario) {
        this.cmc_id_usuario = cmc_id_usuario;
    }

    public String getCmc_nome() {
        return cmc_nome;
    }

    public void setCmc_nome(String cmc_nome) {
        this.cmc_nome = cmc_nome;
    }

    public String getCmc_apelido() {
        return cmc_apelido;
    }

    public void setCmc_apelido(String cmc_apelido) {
        this.cmc_apelido = cmc_apelido;
    }

    public String getCmc_cpf() {
        return cmc_cpf;
    }

    public void setCmc_cpf(String cmc_cpf) {
        this.cmc_cpf = cmc_cpf;
    }

    public Date getCmc_data_nascimento() {
        return cmc_data_nascimento;
    }

    public void setCmc_data_nascimento(Date cmc_data_nascimento) {
        this.cmc_data_nascimento = cmc_data_nascimento;
    }

    public int getCmc_nivel() {
        return cmc_nivel;
    }

    public void setCmc_nivel(int cmc_nivel) {
        this.cmc_nivel = cmc_nivel;
    }

    public String getCmc_ativo() {
        return cmc_ativo;
    }

    public void setCmc_ativo(String cmc_ativo) {
        this.cmc_ativo = cmc_ativo;
    }

    public String getCmc_senha() {
        return cmc_senha;
    }

    public void setCmc_senha(String cmc_senha) {
        this.cmc_senha = cmc_senha;
    }

}
