package com.itayou.card.api.controller;

import com.itayou.card.domain.model.Endereco;
import com.itayou.card.domain.model.Usuario;
import com.itayou.card.domain.service.CadastroUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/usuario")
public class UsuarioController {
    @Autowired
    private CadastroUsuarioService cadastroUsuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> encontrarUsuario(@PathVariable Long id) {
        try {
            Usuario usuario = cadastroUsuarioService.encontrarUsuario(id);
            return ResponseEntity.ok(usuario);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();

        }
    }

    @GetMapping("/endereco/{id}")
    public ResponseEntity<Endereco> encontrarEndereco(@PathVariable Long id) {
        try {
            Endereco endereco = cadastroUsuarioService.encontrarEndereco(id);
            return ResponseEntity.ok(endereco);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();

        }
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        try {
            List<Usuario> usuario = cadastroUsuarioService.listarUsuarios();
            return ResponseEntity.ok(usuario);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }
    }

    @GetMapping("/endereco")
    public ResponseEntity<List<Endereco>> listarEnderecos() {
        try {
            List<Endereco> enderecos = cadastroUsuarioService.listarEnderecos();
            return ResponseEntity.ok(enderecos);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }
    }

    @PostMapping
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody @Valid Usuario usuario, UriComponentsBuilder uriBuilder) {
        try {
            Usuario novoUsuario = cadastroUsuarioService.salvarUsuario(usuario);
            URI uri = uriBuilder.path("/{id}").buildAndExpand(novoUsuario.getId()).toUri();
            return ResponseEntity.created(uri).body(novoUsuario);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }
    }

    @PostMapping("/endereco")
    public ResponseEntity<Endereco> salvarEndereco(@RequestBody @Valid Endereco endereco, UriComponentsBuilder uriBuilder) {
        try {
            Endereco novoEndereco = cadastroUsuarioService.salvarEndereco(endereco);
            URI uri = uriBuilder.path("/{id}").buildAndExpand(novoEndereco.getId()).toUri();
            return ResponseEntity.created(uri).body(novoEndereco);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody @Valid Usuario usuario) {
        try {
            Usuario usuarioAtualizado = cadastroUsuarioService.atualizarUsuario(id, usuario);
            return ResponseEntity.ok(usuarioAtualizado);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();

        }
    }

    @PutMapping("/endereco/{id}")
    public ResponseEntity<Endereco> atualizarEndereco(@PathVariable Long id, @RequestBody @Valid Endereco endereco) {
        try {
            Endereco enderecoAtualizado = cadastroUsuarioService.atualizarEndereco(id, endereco);
            return ResponseEntity.ok(enderecoAtualizado);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deletarUsuario(@PathVariable Long id) {
        try {
            cadastroUsuarioService.deletarUsuario(id);
            return ResponseEntity.noContent().build();

        } catch (Exception e) {
            return ResponseEntity.notFound().build();

        }
    }

    @DeleteMapping("/endereco/{id}")
    public ResponseEntity<Endereco> deletarEndereco(@PathVariable Long id) {
        try {
            cadastroUsuarioService.deletarEndereco(id);
            return ResponseEntity.noContent().build();

        } catch (Exception e) {
            return ResponseEntity.notFound().build();

        }
    }

}
