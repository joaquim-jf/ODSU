package com.joaquimFelix.ODSU.model.entity;
import com.joaquimFelix.ODSU.model.entity.carro.Carro;
import com.joaquimFelix.ODSU.model.entity.cliente.Cliente;
import com.joaquimFelix.ODSU.model.entity.servico.OrdemServico;
import jakarta.persistence.*;

import java.util.Set;
@Entity
public class Oficina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private String endereco;
    private String cep;
    private String telefone;
    private String cnpj;
    @OneToMany(mappedBy = "oficina")
    private Set<Cliente> clientes;
    @OneToMany(mappedBy = "oficina")
    private Set<Carro> carros;
}
