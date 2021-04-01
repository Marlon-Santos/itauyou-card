package com.itayou.card.domain.service;

import com.itayou.card.domain.model.Cartao;
import com.itayou.card.domain.model.CartaoApresentacao;
import com.itayou.card.domain.model.CartaoSolicitado;
import com.itayou.card.domain.repository.CartaoApresentacaoRepository;
import com.itayou.card.domain.repository.CartaoRepository;
import com.itayou.card.domain.repository.CartaoSolicitadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CadastroCartaoService {
    private final CartaoRepository cartaoRepository;
    private final CartaoApresentacaoRepository cartaoApresentacaoRepository;
    private final CartaoSolicitadoRepository cartaoSolicitadoRepository;

    public Cartao encontrarCartaoCadastrado(Long id) throws Exception {
        if (id == null) {
            throw new Exception("id não pode ser nulo");
        }

        Optional<Cartao> cartao = cartaoRepository.findById(id);

        if (cartao.isPresent()) {
            return cartao.get();
        }

        throw new Exception("Cartao não encontrado");
    }

    public CartaoApresentacao encontrarCartaoApresentacaoCadastrado(Long id) throws Exception {
        if (id == null) {
            throw new Exception("id não pode ser nulo");
        }

        Optional<CartaoApresentacao> cartaoApresentacao = cartaoApresentacaoRepository.findById(id);

        if (cartaoApresentacao.isPresent()) {
            return cartaoApresentacao.get();
        }

        throw new Exception("Cartao de apresentação não encontrado");
    }

    public CartaoSolicitado encontrarCartaoSolicitado(Long id) throws Exception {
        if (id == null) {
            throw new Exception("id não pode ser nulo");
        }

        Optional<CartaoSolicitado> cartaoSolicitado = cartaoSolicitadoRepository.findById(id);

        if (cartaoSolicitado.isPresent()) {
            return cartaoSolicitado.get();
        }

        throw new Exception("Cartao solicitado não encontrado");
    }

    public List<Cartao> listarCartoesCadastrados() {
        return cartaoRepository.findAll();
    }

    public List<CartaoApresentacao> listarCartoesApresentacaoCadastrados() {
        return cartaoApresentacaoRepository.findAll();
    }

    public List<CartaoSolicitado> listarCartoesSolicitados() {
        return cartaoSolicitadoRepository.findAll();
    }

    @Transactional
    public Cartao salvarCartao(@Valid Cartao cartao) {
        return cartaoRepository.save(cartao);
    }

    @Transactional
    public CartaoApresentacao salvarCartaoApresentacao(@Valid CartaoApresentacao cartaoApresentacao) {
        return cartaoApresentacaoRepository.save(cartaoApresentacao);
    }

    @Transactional
    public CartaoSolicitado salvarCartaoSolicitado(@Valid CartaoSolicitado cartaoSolicitado) {
        return cartaoSolicitadoRepository.save(cartaoSolicitado);
    }

    @Transactional
    public Cartao atualizarCartao(Long id, @Valid Cartao cartao) throws Exception {
        if (id == null) {
            throw new Exception("id não pode ser nulo");
        }

        CartaoSolicitado cartaoSolicitado = encontrarCartaoSolicitado(id);
        BeanUtils.copyProperties(cartao, cartaoSolicitado, "id");

        return cartaoRepository.save(cartao);
    }

    @Transactional
    public CartaoApresentacao atualizarCartaoApresentacao(Long id, @Valid CartaoApresentacao cartaoApresentacao) throws Exception {
        if (id == null) {
            throw new Exception("id não pode ser nulo");
        }

        CartaoSolicitado cartaoSolicitado = encontrarCartaoSolicitado(id);
        BeanUtils.copyProperties(cartaoApresentacao, cartaoSolicitado, "id");

        return cartaoApresentacaoRepository.save(cartaoApresentacao);
    }

    @Transactional
    public CartaoSolicitado atualizarCartaoSolicitado(Long id, @Valid CartaoSolicitado cartaoSolicitadoAtualizacao) throws Exception {
        if (id == null) {
            throw new Exception("id não pode ser nulo");
        }

        CartaoSolicitado cartaoSolicitado = encontrarCartaoSolicitado(id);
        BeanUtils.copyProperties(cartaoSolicitadoAtualizacao, cartaoSolicitado, "id");

        return cartaoSolicitadoRepository.save(cartaoSolicitado);
    }

    @Transactional
    public void deletarCartao(Long id) throws Exception {
        if (id == null) {
            throw new Exception("id não pode ser nulo");
        }

        Cartao cartao = encontrarCartaoCadastrado(id);

        cartaoRepository.delete(cartao);
    }

    @Transactional
    public void deletarCartaoApresentacao(Long id) throws Exception {
        if (id == null) {
            throw new Exception("id não pode ser nulo");
        }

        CartaoApresentacao cartaoApresentacao = encontrarCartaoApresentacaoCadastrado(id);

        cartaoApresentacaoRepository.delete(cartaoApresentacao);
    }

    @Transactional
    public void deletarCartaoSolicitado(Long id) throws Exception {
        if (id == null) {
            throw new Exception("id não pode ser nulo");
        }

        CartaoSolicitado cartaoSolicitado = encontrarCartaoSolicitado(id);

        cartaoSolicitadoRepository.delete(cartaoSolicitado);
    }

}
