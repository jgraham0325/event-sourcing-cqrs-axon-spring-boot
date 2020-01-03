package com.axonexample.query.repositories;

import com.axonexample.query.entities.TitleQueryEntity;
import org.springframework.data.repository.CrudRepository;

public interface TitleRepository extends CrudRepository<TitleQueryEntity, String> {
}
