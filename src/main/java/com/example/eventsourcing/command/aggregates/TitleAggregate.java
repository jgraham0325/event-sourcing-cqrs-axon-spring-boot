package com.example.eventsourcing.command.aggregates;

import com.example.eventsourcing.command.AddTitleEntryCommand;
import com.example.eventsourcing.command.CreateTitleCommand;
import com.example.eventsourcing.command.entities.EntryEntity;
import com.example.eventsourcing.command.events.TitleEntryAddedEvent;
import com.example.eventsourcing.command.events.TitleCreatedEvent;
import com.example.eventsourcing.command.events.TitleOpenedEvent;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@NoArgsConstructor
@Getter
public class TitleAggregate {

  @AggregateIdentifier
  private String id;
  private String titleNumber;
  private String status;
  private String tenure;
  private String classOfTitle;
  private LocalDate editionDate;
  private String applicationReference;
  private OffsetDateTime applicationTimestamp;
  private String estateInterest;

  @AggregateMember
  private List<EntryEntity> entries = new ArrayList<>();

  @CommandHandler
  public TitleAggregate(CreateTitleCommand createTitleCommand) {

    List<EntryEntity> entries = createTitleCommand.getEntries().stream().map(
        entryWithoutId -> new EntryEntity(UUID.randomUUID().toString(),
            entryWithoutId.getEntrySequence(),
            entryWithoutId.getRoleCode(),
            entryWithoutId.getEntryText()
        )).collect(Collectors.toList());

    AggregateLifecycle.apply(
        new TitleCreatedEvent(
            createTitleCommand.getId(),
            createTitleCommand.getTitleNumber(),
            createTitleCommand.getTenure(),
            createTitleCommand.getClassOfTitle(),
            createTitleCommand.getEditionDate(),
            createTitleCommand.getApplicationReference(),
            createTitleCommand.getApplicationTimestamp(),
            createTitleCommand.getEstateInterest(),
            entries));
  }

  @EventSourcingHandler
  protected void on(TitleCreatedEvent titleCreatedEvent) {
    this.id = titleCreatedEvent.getId();
    this.titleNumber = titleCreatedEvent.getTitleNumber();
    this.applicationReference = titleCreatedEvent.getApplicationReference();
    this.applicationTimestamp = titleCreatedEvent.getApplicationTimestamp();
    this.classOfTitle = titleCreatedEvent.getClassOfTitle();
    this.editionDate = titleCreatedEvent.getEditionDate();
    this.estateInterest = titleCreatedEvent.getEstateInterest();
    this.tenure = titleCreatedEvent.getTenure();
    this.status = String.valueOf(Status.CREATED);
    this.entries = titleCreatedEvent.getEntries();

    AggregateLifecycle.apply(new TitleOpenedEvent(this.id, Status.OPEN));
  }

  @EventSourcingHandler
  protected void on(TitleOpenedEvent titleOpenedEvent) {
    this.status = String.valueOf(titleOpenedEvent.getStatus());
  }

  @CommandHandler
  protected void on(AddTitleEntryCommand addTitleEntryCommand){
    AggregateLifecycle.apply(
        new TitleEntryAddedEvent(addTitleEntryCommand.getId(), addTitleEntryCommand.getEntrySequence(),
            addTitleEntryCommand.getRoleCode(), addTitleEntryCommand.getEntryText()));
  }

  @EventSourcingHandler
  protected void on(TitleEntryAddedEvent titleEntryAddedEvent) {
    this.entries.add(new EntryEntity(titleEntryAddedEvent.getId(),
            titleEntryAddedEvent.getEntrySequence(),
            titleEntryAddedEvent.getRoleCode(),
            titleEntryAddedEvent.getEntryText()));
  }
}