package com.example.eventsourcing.services.queries;

import com.example.eventsourcing.entities.TitleQueryEntity;
import com.example.eventsourcing.entities.repositories.TitleRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TitleQueryServiceImpl implements TitleQueryService {

    private final EventStore eventStore;

    private final TitleRepository titleRepository;

    public TitleQueryServiceImpl(EventStore eventStore, TitleRepository titleRepository) {
        this.eventStore = eventStore;
        this.titleRepository = titleRepository;
    }

    @Override
    public List<Object> listEventsForTitle(String titleId) {
        return eventStore.readEvents(titleId).asStream().map( s -> s.getPayload()).collect(Collectors.toList());
    }

    @Override
    public TitleQueryEntity getTitle(String titleId) {
        return titleRepository.findById(titleId).get();
    }
}
