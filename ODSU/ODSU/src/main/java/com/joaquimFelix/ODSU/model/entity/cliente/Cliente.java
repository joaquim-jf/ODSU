package com.joaquimFelix.ODSU.model.entity.cliente;
import com.joaquimFelix.ODSU.model.entity.carro.Carro;
import com.joaquimFelix.ODSU.model.entity.Oficina;
import jakarta.persistence.*;
import java.util.Set;
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="class")
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private String  telefone;
    private String endereco;
    @OneToMany(mappedBy = "cliente")
    private Set<Carro> carros;
    @ManyToOne
    @JoinColumn(name = "oficina_id")
    private Oficina oficina;

}
