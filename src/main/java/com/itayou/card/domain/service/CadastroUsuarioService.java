package com.itayou.card.domain.service;

import com.itayou.card.domain.model.*;
import com.itayou.card.domain.repository.EnderecoRepository;
import com.itayou.card.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Getter
public class CadastroUsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final EnderecoRepository enderecoRepository;

    public Usuario encontrarUsuario(Long id) throws Exception {
        if (id == null) {
            throw new Exception("id não pode ser nulo");
        }

        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) {
            return usuario.get();
        }

        throw new Exception("Usuario não encontrado");
    }

    public Endereco encontrarEndereco(Long id) throws Exception {
        if (id == null) {
            throw new Exception("id não pode ser nulo");
        }

        Optional<Endereco> endereco = enderecoRepository.findById(id);

        if (endereco.isPresent()) {
            return endereco.get();
        }

        throw new Exception("Endereço não encontrado");
    }

    public List<Usuario> listarUsuarios() throws Exception {
        return usuarioRepository.findAll();
    }

    public List<Endereco> listarEnderecos() throws Exception {
        return enderecoRepository.findAll();
    }

    @Transactional
    public Usuario salvarUsuario(@Valid Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public Endereco salvarEndereco(@Valid Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Transactional
    public Usuario atualizarUsuario(Long id, @Valid Usuario novoUsuario) throws Exception {
        if (id == null) {
            throw new Exception("id não pode ser nulo");
        }

        Usuario usuario = encontrarUsuario(id);
        BeanUtils.copyProperties(usuario, novoUsuario, "id");

        return usuarioRepository.save(usuario);
    }

    @Transactional
    public Endereco atualizarEndereco(Long id, @Valid Endereco novoEndereco) throws Exception {
        if (id == null) {
            throw new Exception("id não pode ser nulo");
        }

        Endereco endereco = encontrarEndereco(id);
        BeanUtils.copyProperties(endereco, novoEndereco, "id");

        return enderecoRepository.save(endereco);
    }

    @Transactional
    public void deletarUsuario(Long id) throws Exception {
        if (id == null) {
            throw new Exception("id não pode ser nulo");
        }

        Usuario usuario = encontrarUsuario(id);

        usuarioRepository.delete(usuario);
    }

    @Transactional
    public void deletarEndereco(Long id) throws Exception {
        if (id == null) {
            throw new Exception("id não pode ser nulo");
        }

        Endereco endereco = encontrarEndereco(id);

        enderecoRepository.delete(endereco);
    }
}
