package com.example.eventsourcing.services.queries;

import com.example.eventsourcing.entities.TitleQueryEntity;

import java.util.List;

public interface TitleQueryService {
    public List<Object> listEventsForTitle(String titleId);
    public TitleQueryEntity getTitle(String titleId);
}
