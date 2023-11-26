package com.joaquimFelix.ODSU.model.entity.servico;
import com.joaquimFelix.ODSU.model.entity.carro.Carro;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
public class OrdemServico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private boolean lavagemPremium;
    private boolean lavagemTecnica;
    private boolean lavagemMotor;
    private boolean higienizacaoInterna;
    private boolean higienizacaoExterna;
    private boolean remocaoChuvaAcida;
    private boolean revitalizacao;
    private boolean funilaria;
    private boolean descontaminacao;
    private boolean enceramento;
    private boolean polimento;
    private boolean ceramicPro9;
    private boolean ceramicProLight;
    private boolean remocaoIsufilme;
    private boolean reformarRodas;
    @NotNull
    private double orcamentoFinal;
    @NotNull
    @Column(length = 1000)
    private String descricao;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Temporal(TemporalType.DATE)
    private Date dataDeChegada;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "carroId")
    private Carro carro;
    // Getters e Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isLavagemPremium() {
        return lavagemPremium;
    }

    public void setLavagemPremium(boolean lavagemPremium) {
        this.lavagemPremium = lavagemPremium;
    }

    public boolean isLavagemTecnica() {
        return lavagemTecnica;
    }

    public void setLavagemTecnica(boolean lavagemTecnica) {
        this.lavagemTecnica = lavagemTecnica;
    }

    public boolean isLavagemMotor() {
        return lavagemMotor;
    }

    public void setLavagemMotor(boolean lavagemMotor) {
        this.lavagemMotor = lavagemMotor;
    }

    public boolean isHigienizacaoInterna() {
        return higienizacaoInterna;
    }

    public void setHigienizacaoInterna(boolean higienizacaoInterna) {
        this.higienizacaoInterna = higienizacaoInterna;
    }

    public boolean isHigienizacaoExterna() {
        return higienizacaoExterna;
    }

    public void setHigienizacaoExterna(boolean higienizacaoExterna) {
        this.higienizacaoExterna = higienizacaoExterna;
    }

    public boolean isRemocaoChuvaAcida() {
        return remocaoChuvaAcida;
    }

    public void setRemocaoChuvaAcida(boolean remocaoChuvaAcida) {
        this.remocaoChuvaAcida = remocaoChuvaAcida;
    }

    public boolean isRevitalizacao() {
        return revitalizacao;
    }

    public void setRevitalizacao(boolean revitalizacao) {
        this.revitalizacao = revitalizacao;
    }

    public boolean isFunilaria() {
        return funilaria;
    }

    public void setFunilaria(boolean funilaria) {
        this.funilaria = funilaria;
    }

    public boolean isDescontaminacao() {
        return descontaminacao;
    }

    public void setDescontaminacao(boolean descontaminacao) {
        this.descontaminacao = descontaminacao;
    }

    public boolean isEnceramento() {
        return enceramento;
    }

    public void setEnceramento(boolean enceramento) {
        this.enceramento = enceramento;
    }

    public boolean isPolimento() {
        return polimento;
    }

    public void setPolimento(boolean polimento) {
        this.polimento = polimento;
    }

    public boolean isCeramicPro9() {
        return ceramicPro9;
    }

    public void setCeramicPro9(boolean ceramicPro9) {
        this.ceramicPro9 = ceramicPro9;
    }

    public boolean isCeramicProLight() {
        return ceramicProLight;
    }

    public void setCeramicProLight(boolean ceramicProLight) {
        this.ceramicProLight = ceramicProLight;
    }

    public boolean isRemocaoIsufilme() {
        return remocaoIsufilme;
    }

    public void setRemocaoIsufilme(boolean remocaoIsufilme) {
        this.remocaoIsufilme = remocaoIsufilme;
    }

    public boolean isReformarRodas() {
        return reformarRodas;
    }

    public void setReformarRodas(boolean reformarRodas) {
        this.reformarRodas = reformarRodas;
    }

    public double getOrcamentoFinal() {
        return orcamentoFinal;
    }

    public void setOrcamentoFinal(double orcamentoFinal) {
        this.orcamentoFinal = orcamentoFinal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataDeChegada() {
        return dataDeChegada;
    }

    public void setDataDeChegada(Date dataDeChegada) {
        this.dataDeChegada = dataDeChegada;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
