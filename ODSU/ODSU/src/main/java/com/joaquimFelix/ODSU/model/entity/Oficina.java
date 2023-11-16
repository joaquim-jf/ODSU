package com.joaquimFelix.ODSU.model.entity;

import com.joaquimFelix.ODSU.model.entity.carro.Carro;
import com.joaquimFelix.ODSU.model.entity.cliente.Cliente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Set;
@Entity
public class Oficina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String nome;
    @NotNull
    private String endereco;
    @NotNull
    @Size(max =9,min = 8, message = "Colocar no mínimo 8 caracteres")
    private String cep;
    @NotNull
    @Size(max = 12,min = 8,message = "Coloque seu numero completo")
    private String telefone;
    @NotNull
    @Size(max = 14,min = 14,message = "Colocar o Cnpj todo")
    private String cnpj;
    @OneToMany(mappedBy = "oficina")
    private Set<Cliente> clientes;
    @OneToMany(mappedBy = "oficina")
    private Set<Carro> carros;
    // Getters e Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Set<Carro> getCarros() {
        return carros;
    }

    public void setCarros(Set<Carro> carros) {
        this.carros = carros;
    }
}
