package com.example.eventsourcing.config;

import com.example.eventsourcing.aggregates.TitleAggregate;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {

    @Bean
    EventSourcingRepository<TitleAggregate> titleAggregateEventSourcingRepository(EventStore eventStore){
        EventSourcingRepository<TitleAggregate> repository = EventSourcingRepository.builder(
            TitleAggregate.class).eventStore(eventStore).build();
        return repository;
    }
}
