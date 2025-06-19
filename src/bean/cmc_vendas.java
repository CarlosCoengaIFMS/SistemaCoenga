/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import java.sql.Timestamp;

/**
 *
 * @author NoteDarckBr
 */
public class cmc_vendas {

    private int cmc_id_venda;
    private int cmc_fk_clinte;
    private int cmc_fk_usuario;
    private boolean cmc_valor_total;
    private Timestamp cmc_cmc_data_venda;
    private String cmc_status;
    private String cmc_forma_pagamento;
    private String cmc_observacoes;
    private String cmc_fk_cendedor;

    public int getCmc_id_venda() {
        return cmc_id_venda;
    }

    public void setCmc_id_venda(int cmc_id_venda) {
        this.cmc_id_venda = cmc_id_venda;
    }

    public int getCmc_fk_clinte() {
        return cmc_fk_clinte;
    }

    public void setCmc_fk_clinte(int cmc_fk_clinte) {
        this.cmc_fk_clinte = cmc_fk_clinte;
    }

    public int getCmc_fk_usuario() {
        return cmc_fk_usuario;
    }

    public void setCmc_fk_usuario(int cmc_fk_usuario) {
        this.cmc_fk_usuario = cmc_fk_usuario;
    }

    public boolean isCmc_valor_total() {
        return cmc_valor_total;
    }

    public void setCmc_valor_total(boolean cmc_valor_total) {
        this.cmc_valor_total = cmc_valor_total;
    }

    public Timestamp getCmc_cmc_data_venda() {
        return cmc_cmc_data_venda;
    }

    public void setCmc_cmc_data_venda(Timestamp cmc_cmc_data_venda) {
        this.cmc_cmc_data_venda = cmc_cmc_data_venda;
    }

    public String getCmc_status() {
        return cmc_status;
    }

    public void setCmc_status(String cmc_status) {
        this.cmc_status = cmc_status;
    }

    public String getCmc_forma_pagamento() {
        return cmc_forma_pagamento;
    }

    public void setCmc_forma_pagamento(String cmc_forma_pagamento) {
        this.cmc_forma_pagamento = cmc_forma_pagamento;
    }

    public String getCmc_observacoes() {
        return cmc_observacoes;
    }

    public void setCmc_observacoes(String cmc_observacoes) {
        this.cmc_observacoes = cmc_observacoes;
    }

    public String getCmc_fk_cendedor() {
        return cmc_fk_cendedor;
    }

    public void setCmc_fk_cendedor(String cmc_fk_cendedor) {
        this.cmc_fk_cendedor = cmc_fk_cendedor;
    }

}
