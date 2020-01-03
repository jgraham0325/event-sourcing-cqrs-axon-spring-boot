package com.example.eventsourcing.query.services;

import com.example.eventsourcing.query.entities.TitleQueryEntity;

import java.util.List;

public interface TitleQueryService {
    List<Object> listEventsForTitle(String titleId);
    TitleQueryEntity getTitle(String titleId);
}
