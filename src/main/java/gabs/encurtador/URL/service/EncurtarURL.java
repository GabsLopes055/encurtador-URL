package gabs.encurtador.URL.service;

import gabs.encurtador.URL.dto.UrlRequest;
import gabs.encurtador.URL.dto.UrlResponse;
import gabs.encurtador.URL.entity.UrlEntity;
import gabs.encurtador.URL.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class EncurtarURL {

    @Autowired
    private UrlRepository repository;

    public UrlResponse encurtarUrl(UrlRequest url, String urlLocal) {

        String codigo = criarCodigoDaUrl();

        validarCodigoCadastrado(codigo);

        UrlEntity salvarUrl = new UrlEntity(codigo, url.url(), LocalDateTime.now().plusMinutes(1));

        repository.save(salvarUrl);

        String urlEncurtada = urlLocal.replace("encurtador-url", codigo);

        return new UrlResponse(urlEncurtada);

    }

    public void validarCodigoCadastrado(String codigo) {

        boolean codigoCadastrado = repository.existsById(codigo);

        if (codigoCadastrado) {
            throw new RuntimeException("Código já existe cadastrado");
        }
    }

    public String criarCodigoDaUrl() {

        String[] alfabeto = {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
        };

        // Criando um objeto Random
        Random random = new Random();

        // String para armazenar o código gerado
        StringBuilder codigo = new StringBuilder();

        // Sorteando 8 valores aleatórios do array
        for (int i = 0; i < 8; i++) {
            codigo.append(alfabeto[random.nextInt(alfabeto.length)]);
        }

        return codigo.toString();

    }

    public String redirectURL(String codeURL) {

        Optional<UrlEntity> findURL = repository.findById(codeURL);

        return findURL.get().getUrlCompleta();

    }
}
