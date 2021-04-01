package com.itayou.card.domain.service;

import com.itayou.card.domain.enums.Bandeira;
import com.itayou.card.domain.enums.NomeCartao;
import com.itayou.card.domain.mock.CadastrosMock;
import com.itayou.card.domain.model.Cartao;
import com.itayou.card.domain.model.Endereco;
import com.itayou.card.domain.model.Usuario;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class CadastroCartaoServiceTest {
    @Autowired
    private CadastroCartaoService cadastroCartaoService;
    @Autowired
    private CadastroUsuarioService cadastroUsuarioService;

    @Test
    void salvarCartao() {
        Endereco endereco = cadastroUsuarioService.getEnderecoRepository().save(CadastrosMock.builder().build().gerarEndereco());

        Usuario usuario = CadastrosMock.builder().build().gerarUsuario(endereco);
        cadastroUsuarioService.getUsuarioRepository().save(usuario);
        Cartao novoCartao = Cartao.builder()
                .bandeira(Bandeira.VISA).limite(3500.00)
                .nome(NomeCartao.ITAU_PLATINUM).usuario(usuario).build();

        Cartao cartao = this.cadastroCartaoService.salvarCartao(novoCartao);

        Assertions.assertNotNull(cartao.getBandeira());
    }

    @Test
    void salvarCartaoApresentacao() {
    }

    @Test
    void salvarCartaoSolicitado() {
    }

    @Test
    void listarCartoesCadastrados() {
    }

    @Test
    void listarCartoesApresentacaoCadastrados() {
    }

    @Test
    void listarCartoesSolicitados() {
    }

    @Test
    void encontrarCartaoCadastrado() {
        try {
            cadastroCartaoService.encontrarCartaoCadastrado(2L);

        } catch (Exception e) {
            Assertions.assertEquals("Cartao não encontrado", e.getMessage());
        }

    }

    @Test
    void testEncontrarCartaoCadastrado() {
    }

    @Test
    void encontrarCartaoApresentacaoCadastrado() {
    }

    @Test
    void encontrarCartaoSolicitado() {
    }


    @Test
    void atualizarCartao() {
    }

    @Test
    void atualizarCartaoApresentacao() {
    }

    @Test
    void atualizarCartaoSolicitado() {
    }

    @Test
    void deletarCartao() {
    }

    @Test
    void deletarCartaoApresentacao() {
    }

    @Test
    void deletarCartaoSolicitado() {
    }
}