package com.joaquimFelix.ODSU.repository.carro;

import com.joaquimFelix.ODSU.model.entity.carro.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro,Long> {
}
