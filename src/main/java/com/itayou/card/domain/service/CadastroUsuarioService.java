package com.itayou.card.domain.service;

import com.itayou.card.domain.model.*;
import com.itayou.card.domain.repository.EnderecoRepository;
import com.itayou.card.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class CadastroUsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

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
        if (usuario.getEndereco() == null) {
            usuario.setEndereco(salvarEndereco(new Endereco()));
        }

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
        BeanUtils.copyProperties(novoUsuario, usuario, "id");

        return usuarioRepository.save(usuario);
    }

    @Transactional
    public Endereco atualizarEndereco(Long id, @Valid Endereco novoEndereco) throws Exception {
        if (id == null) {
            throw new Exception("id não pode ser nulo");
        }

        Endereco endereco = encontrarEndereco(id);
        BeanUtils.copyProperties(novoEndereco, endereco, "id");

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
