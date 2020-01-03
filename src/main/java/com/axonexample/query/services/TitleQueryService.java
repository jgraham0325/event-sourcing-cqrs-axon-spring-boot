package com.axonexample.query.services;

import com.axonexample.query.entities.TitleQueryEntity;

import java.util.List;

public interface TitleQueryService {
    List<Object> listEventsForTitle(String titleId);
    TitleQueryEntity getTitle(String titleId);
}
