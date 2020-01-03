package com.example.eventsourcing.query.repositories;

import com.example.eventsourcing.query.entities.TitleQueryEntity;
import org.springframework.data.repository.CrudRepository;

public interface TitleRepository extends CrudRepository<TitleQueryEntity, String> {
}
