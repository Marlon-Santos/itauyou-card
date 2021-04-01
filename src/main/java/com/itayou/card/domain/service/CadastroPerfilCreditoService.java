package com.itayou.card.domain.service;

import com.itayou.card.domain.repository.PerfilCreditoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CadastroPerfilCreditoService {
    private PerfilCreditoRepository perfilCreditoRepository;
}
