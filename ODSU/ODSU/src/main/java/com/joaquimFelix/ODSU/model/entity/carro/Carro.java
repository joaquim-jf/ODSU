package com.joaquimFelix.ODSU.model.entity.carro;

import com.joaquimFelix.ODSU.model.entity.cliente.Cliente;
import com.joaquimFelix.ODSU.model.entity.servico.OrdemServico;
import com.joaquimFelix.ODSU.model.entity.Oficina;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.Set;
@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "A placa não pode estar em branco")
    @Size(max =7,min = 7,message = "A placa deve ter exatamente  7 caracteres")
    private String placa;
    @NotBlank(message = "A marca não pode estar em branco")
    private String marca;
    @NotBlank(message = "O modelo não pode estar em branco")
    private String modelo;

    @NotBlank(message = "O chassi não pode estar em branco")
    @Size(max =17,min = 17,message = "O chassi deve ter exatamente 17 caracteres")
    private String chassi;
    @NotBlank(message = "A cor não pode estar em branco")
    private String cor;
    @NotNull(message = "O ano de fabricação não pode ser nulo")
    @Temporal(TemporalType.DATE)
    private Date anoFab;
    @OneToMany(mappedBy = "carro")
    private Set<OrdemServico> ordemServicos;
    @ManyToOne
    @JoinColumn(name = "proprietario_id")
    @NotNull(message = "O proprietário não pode ser nulo")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "oficina_id")
    @NotNull(message = "A oficina não pode ser nula")
    private Oficina oficina;
    // Getters e Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Date getAnoFab() {
        return anoFab;
    }

    public void setAnoFab(Date anoFab) {
        this.anoFab = anoFab;
    }

    public Set<OrdemServico> getOrdemServicos() {
        return ordemServicos;
    }

    public void setOrdemServicos(Set<OrdemServico> ordemServicos) {
        this.ordemServicos = ordemServicos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }
}
