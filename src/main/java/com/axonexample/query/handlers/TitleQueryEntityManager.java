package com.axonexample.query.handlers;

import com.axonexample.command.aggregates.TitleAggregate;
import com.axonexample.query.entities.EntryQueryEntity;
import com.axonexample.query.entities.ProprietorQueryEntity;
import com.axonexample.query.entities.TitleQueryEntity;
import com.axonexample.query.repositories.TitleRepository;
import com.axonexample.command.events.TitleOpenedEvent;
import com.axonexample.command.events.TitleCreatedEvent;
import com.axonexample.command.events.TitleEntryAddedEvent;
import java.util.stream.Collectors;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("query")
public class TitleQueryEntityManager {

  @Autowired
  private TitleRepository titleRepository;

  @Autowired
  @Qualifier("titleAggregateEventSourcingRepository")
  private EventSourcingRepository<TitleAggregate> titleAggregateEventSourcingRepository;

  @EventSourcingHandler
  void on(TitleCreatedEvent event) {
    persistTitle(buildQueryTitle(getTitleFromEvent(event.getId())));
  }

  @EventSourcingHandler
  void on(TitleOpenedEvent event) {
    persistTitle(buildQueryTitle(getTitleFromEvent(event.getId())));
  }

  @EventSourcingHandler
  void on(TitleEntryAddedEvent event) {
    persistTitle(buildQueryTitle(getTitleFromEvent(event.getTitleId())));
  }


  private TitleAggregate getTitleFromEvent(String id) {
    return titleAggregateEventSourcingRepository.load(id).getWrappedAggregate().getAggregateRoot();
  }

  private TitleQueryEntity findExistingOrCreateQueryTitle(String id) {
    return titleRepository.findById(id).isPresent() ? titleRepository.findById(id).get()
        : new TitleQueryEntity();
  }

  private TitleQueryEntity buildQueryTitle(TitleAggregate titleAggregate) {
    TitleQueryEntity titleQueryEntity = findExistingOrCreateQueryTitle(titleAggregate.getId());

    titleQueryEntity.setId(titleAggregate.getId());
    titleQueryEntity.setTitleNumber(titleAggregate.getTitleNumber());
    titleQueryEntity.setApplicationReference(titleAggregate.getApplicationReference());
    titleQueryEntity.setApplicationTimestamp(titleAggregate.getApplicationTimestamp());
    titleQueryEntity.setClassOfTitle(titleAggregate.getClassOfTitle());
    titleQueryEntity.setEditionDate(titleAggregate.getEditionDate());
    titleQueryEntity.setEstateInterest(titleAggregate.getEstateInterest());
    titleQueryEntity.setStatus(titleAggregate.getStatus());
    titleQueryEntity.setTenure(titleAggregate.getTenure());
    titleQueryEntity.setEntries(titleAggregate.getEntries().stream().map(entry ->
        new EntryQueryEntity(
            entry.getEntryId(),
            entry.getEntrySequence(),
            entry.getRoleCode(),
            entry.getEntryText()))
        .collect(Collectors.toList()));
    titleQueryEntity.setProprietors(titleAggregate.getProprietors().stream().map(proprietor ->
        new ProprietorQueryEntity(
            proprietor.getProprietorId(),
            proprietor.getForeNames(),
            proprietor.getSurname(),
            proprietor.getTitle(),
            proprietor.getDecor()))
        .collect(Collectors.toList()));

    return titleQueryEntity;
  }

  private void persistTitle(TitleQueryEntity titleQueryEntity) {
    titleRepository.save(titleQueryEntity);
  }
}
