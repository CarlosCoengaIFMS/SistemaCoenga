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
    private int cmc_id_clinte;
    private int cmc_id_usuario;
    private  boolean cmc_valor_total;
    private Timestamp cmc_cmc_data_venda;
    private String cmc_status;
    private String cmc_forma_pagamento;
    private String cmc_observacoes;

    /**
     * @return the cmc_id_venda
     */
    public int getCmc_id_venda() {
        return cmc_id_venda;
    }

    /**
     * @param cmc_id_venda the cmc_id_venda to set
     */
    public void setCmc_id_venda(int cmc_id_venda) {
        this.cmc_id_venda = cmc_id_venda;
    }

    /**
     * @return the cmc_id_clinte
     */
    public int getCmc_id_clinte() {
        return cmc_id_clinte;
    }

    /**
     * @param cmc_id_clinte the cmc_id_clinte to set
     */
    public void setCmc_id_clinte(int cmc_id_clinte) {
        this.cmc_id_clinte = cmc_id_clinte;
    }

    /**
     * @return the cmc_id_usuario
     */
    public int getCmc_id_usuario() {
        return cmc_id_usuario;
    }

    /**
     * @param cmc_id_usuario the cmc_id_usuario to set
     */
    public void setCmc_id_usuario(int cmc_id_usuario) {
        this.cmc_id_usuario = cmc_id_usuario;
    }

    /**
     * @return the cmc_valor_total
     */
    public boolean isCmc_valor_total() {
        return cmc_valor_total;
    }

    /**
     * @param cmc_valor_total the cmc_valor_total to set
     */
    public void setCmc_valor_total(boolean cmc_valor_total) {
        this.cmc_valor_total = cmc_valor_total;
    }

    /**
     * @return the cmc_cmc_data_venda
     */
    public Timestamp getCmc_cmc_data_venda() {
        return cmc_cmc_data_venda;
    }

    /**
     * @param cmc_cmc_data_venda the cmc_cmc_data_venda to set
     */
    public void setCmc_cmc_data_venda(Timestamp cmc_cmc_data_venda) {
        this.cmc_cmc_data_venda = cmc_cmc_data_venda;
    }

    /**
     * @return the cmc_status
     */
    public String getCmc_status() {
        return cmc_status;
    }

    /**
     * @param cmc_status the cmc_status to set
     */
    public void setCmc_status(String cmc_status) {
        this.cmc_status = cmc_status;
    }

    /**
     * @return the cmc_forma_pagamento
     */
    public String getCmc_forma_pagamento() {
        return cmc_forma_pagamento;
    }

    /**
     * @param cmc_forma_pagamento the cmc_forma_pagamento to set
     */
    public void setCmc_forma_pagamento(String cmc_forma_pagamento) {
        this.cmc_forma_pagamento = cmc_forma_pagamento;
    }

    /**
     * @return the cmc_observacoes
     */
    public String getCmc_observacoes() {
        return cmc_observacoes;
    }

    /**
     * @param cmc_observacoes the cmc_observacoes to set
     */
    public void setCmc_observacoes(String cmc_observacoes) {
        this.cmc_observacoes = cmc_observacoes;
    }
    
    
}
