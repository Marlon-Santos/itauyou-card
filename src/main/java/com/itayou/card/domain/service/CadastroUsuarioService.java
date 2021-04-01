package com.itayou.card.domain.service;

import com.itayou.card.domain.repository.EnderecoRepository;
import com.itayou.card.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Getter
public class CadastroUsuarioService {
    private UsuarioRepository usuarioRepository;
    private EnderecoRepository enderecoRepository;
}
