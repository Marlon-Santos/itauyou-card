package com.itayou.card.domain.service;

import com.itayou.card.domain.model.PerfilCredito;
import com.itayou.card.domain.repository.PerfilCreditoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
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
public class CadastroPerfilCreditoService {
    @Autowired
    private PerfilCreditoRepository perfilCreditoRepository;

    public PerfilCredito encontrarPerfilCredito(Long id) throws Exception {
        if (id == null) {
            throw new Exception("id não pode ser nulo");
        }

        Optional<PerfilCredito> perfilCredito = perfilCreditoRepository.findById(id);

        if (perfilCredito.isPresent()) {
            return perfilCredito.get();
        }

        throw new Exception("Perfil não encontrado");
    }

    public List<PerfilCredito> listarPerfisCredito() throws Exception {
        return perfilCreditoRepository.findAll();
    }

    @Transactional
    public PerfilCredito salvarPerfilCredito(@Valid PerfilCredito perfilCredito) {
        return perfilCreditoRepository.save(perfilCredito);
    }

    @Transactional
    public PerfilCredito atualizarPerfilCredito(Long id, @Valid PerfilCredito novoPerfilCredito) throws Exception {
        if (id == null) {
            throw new Exception("id não pode ser nulo");
        }

        PerfilCredito perfilCredito = encontrarPerfilCredito(id);
        BeanUtils.copyProperties(novoPerfilCredito, perfilCredito, "id");

        return perfilCreditoRepository.save(perfilCredito);
    }

    @Transactional
    public void deletarPerfilCredito(Long id) throws Exception {
        if (id == null) {
            throw new Exception("id não pode ser nulo");
        }

        PerfilCredito PerfilCredito = encontrarPerfilCredito(id);

        perfilCreditoRepository.delete(PerfilCredito);
    }
}
