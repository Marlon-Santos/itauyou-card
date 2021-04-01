package com.itayou.card.domain.mock;

import com.itayou.card.domain.enums.Bandeira;
import com.itayou.card.domain.enums.NomeCartao;
import com.itayou.card.domain.enums.Perfil;
import com.itayou.card.domain.enums.Status;
import com.itayou.card.domain.model.*;
import com.itayou.card.domain.repository.CartaoApresentacaoRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.validation.Valid;
import java.util.Date;

@Builder
@AllArgsConstructor
public class CadastrosMock {
    private CartaoApresentacaoRepository cartaoApresentacaoRepository;

    public CartaoApresentacao gerarCartaoApresentacao(@Valid PerfilCredito perfilCredito){

        return CartaoApresentacao.builder().nomeCartao(NomeCartao.ITAU_OURO)
                .bandeira(Bandeira.VISA).limite(2500.00).perfilCredito(perfilCredito).build();
    }

    public Cartao gerarCartao(@Valid Usuario usuario) {
        return Cartao.builder().usuario(usuario).limite(2000.00)
                .bandeira(Bandeira.VISA).nome(NomeCartao.ITAU_OURO).build();
    }

    public CartaoSolicitado solicitarCartao(@Valid Cartao cartao) {
        return CartaoSolicitado.builder().cartao(cartao)
                .dataSolicitacao(new Date()).status(Status.EM_FABRICACAO).build();
    }
    public Endereco gerarEndereco() {
        return Endereco.builder().bairro("sede").cep("83430000")
                .cidade("Campina Grande").numero(50L).rua("Antonio Jose Sobrinho")
                .uf("SP").build();
    }
    public PerfilCredito gerarPerfilCredito() {
        return PerfilCredito.builder().nomePerfil(Perfil.PLATINUM).build();
    }

    public Usuario gerarUsuario(@Valid Endereco endereco) {
        return Usuario.builder().nome("Rafael Oliveira").endereco(endereco).idade(25L)
                .salario(5596.82).build();
    }

}
