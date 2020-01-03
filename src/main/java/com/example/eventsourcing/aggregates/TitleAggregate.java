package com.example.eventsourcing.aggregates;

import com.example.eventsourcing.commands.AddTitleEntryCommand;
import com.example.eventsourcing.commands.CreateTitleCommand;
import com.example.eventsourcing.events.TitleActivatedEvent;
import com.example.eventsourcing.events.TitleCreatedEvent;
import com.example.eventsourcing.events.TitleEntryAddedEvent;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
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


  public TitleAggregate() {
  }

  @CommandHandler
  public TitleAggregate(CreateTitleCommand createTitleCommand) {

    List<EntryEntity> entries = createTitleCommand.entries.stream().map(
        entryWithoutId -> new EntryEntity(UUID.randomUUID().toString(),
            entryWithoutId.entrySequence,
            entryWithoutId.roleCode,
            entryWithoutId.entryText
        )).collect(Collectors.toList());

    AggregateLifecycle.apply(
        new TitleCreatedEvent(createTitleCommand.id, createTitleCommand.titleNumber,
            createTitleCommand.tenure, createTitleCommand.classOfTitle,
            createTitleCommand.editionDate,
            createTitleCommand.applicationReference, createTitleCommand.applicationTimestamp,
            createTitleCommand.estateInterest,
            entries));
  }

  @EventSourcingHandler
  protected void on(TitleCreatedEvent titleCreatedEvent) {
    this.id = titleCreatedEvent.id;
    this.titleNumber = titleCreatedEvent.getTitleNumber();
    this.applicationReference = titleCreatedEvent.getApplicationReference();
    this.applicationTimestamp = titleCreatedEvent.getApplicationTimestamp();
    this.classOfTitle = titleCreatedEvent.getClassOfTitle();
    this.editionDate = titleCreatedEvent.getEditionDate();
    this.estateInterest = titleCreatedEvent.getEstateInterest();
    this.tenure = titleCreatedEvent.getTenure();
    this.status = String.valueOf(Status.CREATED);
    this.entries = titleCreatedEvent.getEntries();

    AggregateLifecycle.apply(new TitleActivatedEvent(this.id, Status.ACTIVATED));
  }

  @EventSourcingHandler
  protected void on(TitleActivatedEvent titleActivatedEvent) {
    this.status = String.valueOf(titleActivatedEvent.status);
  }

  @CommandHandler
  protected void on(AddTitleEntryCommand addTitleEntryCommand){
    AggregateLifecycle.apply(
        new TitleEntryAddedEvent(addTitleEntryCommand.id, addTitleEntryCommand.entrySequence,
            addTitleEntryCommand.roleCode, addTitleEntryCommand.entryText));
  }

  @EventSourcingHandler
  protected void on(TitleEntryAddedEvent titleEntryAddedEvent) {
    this.entries.add(new EntryEntity(titleEntryAddedEvent.id,
            titleEntryAddedEvent.getEntrySequence(),
            titleEntryAddedEvent.getRoleCode(),
            titleEntryAddedEvent.getEntryText()));
  }

  public String getId() {
    return id;
  }

  public String getTitleNumber() {
    return titleNumber;
  }

  public String getStatus() {
    return status;
  }

  public String getTenure() {
    return tenure;
  }

  public String getClassOfTitle() {
    return classOfTitle;
  }

  public LocalDate getEditionDate() {
    return editionDate;
  }

  public String getApplicationReference() {
    return applicationReference;
  }

  public OffsetDateTime getApplicationTimestamp() {
    return applicationTimestamp;
  }

  public String getEstateInterest() {
    return estateInterest;
  }

  public List<EntryEntity> getEntries() {
    return entries;
  }
}