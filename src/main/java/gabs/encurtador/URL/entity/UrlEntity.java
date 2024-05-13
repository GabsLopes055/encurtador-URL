package gabs.encurtador.URL.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "urls")
public class UrlEntity {

    @Id
    private String url;

    private String urlCompleta;

    @Indexed(expireAfterSeconds = 0)
    private LocalDateTime dataExpiracao;

    public UrlEntity() {
    }

    public UrlEntity(String url, String urlCompleta, LocalDateTime dataExpiracao) {
        this.url = url;
        this.urlCompleta = urlCompleta;
        this.dataExpiracao = dataExpiracao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlCompleta() {
        return urlCompleta;
    }

    public void setUrlCompleta(String urlCompleta) {
        this.urlCompleta = urlCompleta;
    }

    public LocalDateTime getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(LocalDateTime dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }
}
