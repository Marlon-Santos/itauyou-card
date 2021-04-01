package com.itayou.card.domain.service;

import com.itayou.card.CardApplication;
import com.itayou.card.domain.model.Cartao;
import com.itayou.card.domain.repository.CartaoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
@SpringBootTest
@ActiveProfiles("test")
class CadastroCartaoServiceTest {
    @Autowired
    private CadastroCartaoService cadastroCartaoService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void encontrarCartaoCadastrado() {
        System.out.println(cadastroCartaoService);
        try {
            System.out.println(cadastroCartaoService.encontrarCartaoCadastrado(2L));
        }catch (Exception e){

        }

    }
}