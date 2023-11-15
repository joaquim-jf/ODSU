package com.joaquimFelix.ODSU.model.entity.carro;

import com.joaquimFelix.ODSU.model.entity.cliente.Cliente;
import com.joaquimFelix.ODSU.model.entity.servico.OrdemServico;
import com.joaquimFelix.ODSU.model.entity.Oficina;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;
@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String placa;
    private String marca;
    private String modelo;
    private String chassi;
    private String cor;
    @Temporal(TemporalType.DATE)
    private Date anoFab;
    @OneToMany(mappedBy = "carro")
    private Set<OrdemServico> ordemServicos;
    @ManyToOne
    @JoinColumn(name = "proprietario_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "oficina_id")
    private Oficina oficina;

}
