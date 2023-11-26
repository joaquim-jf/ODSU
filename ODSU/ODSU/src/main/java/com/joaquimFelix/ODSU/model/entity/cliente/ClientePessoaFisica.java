package com.joaquimFelix.ODSU.model.entity.cliente;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@DiscriminatorValue(value = "ClientePessoaFisica")
public class ClientePessoaFisica extends Cliente{
    @NotNull
    @Size(max = 11,min = 11,message = "Colocar o Cpf completo")
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
