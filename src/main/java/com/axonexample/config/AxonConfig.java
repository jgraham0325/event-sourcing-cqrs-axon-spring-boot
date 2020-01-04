package com.axonexample.config;

import com.axonexample.command.aggregates.TitleAggregate;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"command","query"})
public class AxonConfig {

    @Bean
    EventSourcingRepository<TitleAggregate> titleAggregateEventSourcingRepository(EventStore eventStore){
        EventSourcingRepository<TitleAggregate> repository = EventSourcingRepository.builder(
            TitleAggregate.class).eventStore(eventStore).build();
        return repository;
    }
}
