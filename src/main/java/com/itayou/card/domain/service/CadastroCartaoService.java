package com.itayou.card.domain.service;

import com.itayou.card.domain.model.Cartao;
import com.itayou.card.domain.model.CartaoApresentacao;
import com.itayou.card.domain.model.CartaoSolicitado;
import com.itayou.card.domain.repository.CartaoApresentacaoRepository;
import com.itayou.card.domain.repository.CartaoRepository;
import com.itayou.card.domain.repository.CartaoSolicitadoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class CadastroCartaoService {
    private CartaoRepository cartaoRepository;
    private CartaoApresentacaoRepository cartaoApresentacaoRepository;
    private CartaoSolicitadoRepository cartaoSolicitadoRepository;

    public Cartao encontrarCartaoCadastrado(Long id) throws Exception {
        Optional<Cartao> cartao = cartaoRepository.findById(id);

        if (cartao.isPresent()) {
            return cartao.get();
        }

        throw new Exception("cartao não encontrado");
    }

    public CartaoApresentacao encontrarCartaoApresentacaoCadastrado(Long id) {

        return new CartaoApresentacao();
    }

    public CartaoSolicitado encontrarCartaoSolicitado(Long id) {

        return new CartaoSolicitado();
    }

    public List<Cartao> listarCartoesCadastrados() {

        return new ArrayList<>();
    }

    public List<CartaoApresentacao> listarCartoesApresentacaoCadastrados() {

        return new ArrayList<>();
    }

    public List<CartaoSolicitado> listarCartoesSolicitados() {

        return new ArrayList<>();
    }
}
