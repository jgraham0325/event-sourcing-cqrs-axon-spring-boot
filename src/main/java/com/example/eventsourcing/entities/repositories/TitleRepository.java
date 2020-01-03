package com.example.eventsourcing.entities.repositories;

import com.example.eventsourcing.entities.TitleQueryEntity;
import org.springframework.data.repository.CrudRepository;

public interface TitleRepository extends CrudRepository<TitleQueryEntity, String> {
}
