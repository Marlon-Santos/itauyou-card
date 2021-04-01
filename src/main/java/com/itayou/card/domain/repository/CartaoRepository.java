package com.itayou.card.domain.repository;

import com.itayou.card.domain.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
}
