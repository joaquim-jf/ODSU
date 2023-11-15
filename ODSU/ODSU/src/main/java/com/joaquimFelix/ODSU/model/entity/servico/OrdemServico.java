package com.joaquimFelix.ODSU.model.entity.servico;
import com.joaquimFelix.ODSU.model.entity.carro.Carro;
import jakarta.persistence.*;

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
    private double orcamentoFinal;
    @Column(length = 1000)
    private String descricao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDeChegada;
    @ManyToOne
    @JoinColumn(name = "carro_id")
    private Carro carro;
}
