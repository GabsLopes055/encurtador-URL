package gabs.encurtador.URL.repository;

import gabs.encurtador.URL.entity.UrlEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<UrlEntity, String> {
}
