package me.dominikoso.toolbox.repository;

import me.dominikoso.toolbox.model.Url;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlRepository extends CrudRepository<Url, Long> {
    List<Url> findAll();
    List<Url> findAllByOwner(String owner);
}
