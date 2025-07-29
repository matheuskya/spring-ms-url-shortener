package com.matheuskya.url_shortener_service.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends MongoRepository<Url, String> {

}
