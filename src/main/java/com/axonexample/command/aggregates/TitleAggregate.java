package com.axonexample.command.aggregates;

import com.axonexample.command.AddProprietorCommand;
import com.axonexample.command.AddTitleEntryCommand;
import com.axonexample.command.CreateTitleCommand;
import com.axonexample.command.aggregates.entities.EntryEntity;
import com.axonexample.command.aggregates.entities.ProprietorEntity;
import com.axonexample.command.events.ProprietorAddedEvent;
import com.axonexample.command.events.TitleEntryAddedEvent;
import com.axonexample.command.events.TitleCreatedEvent;
import com.axonexample.command.events.TitleOpenedEvent;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.context.annotation.Profile;

@Aggregate
@NoArgsConstructor
@Getter
@Profile("command")
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

  @AggregateMember
  private List<ProprietorEntity> proprietors = new ArrayList<>();

  @CommandHandler
  public TitleAggregate(CreateTitleCommand createTitleCommand) {

    AggregateLifecycle.apply(
        new TitleCreatedEvent(
            createTitleCommand.getId(),
            createTitleCommand.getTitleNumber(),
            createTitleCommand.getTenure(),
            createTitleCommand.getClassOfTitle(),
            createTitleCommand.getEditionDate(),
            createTitleCommand.getApplicationReference(),
            createTitleCommand.getApplicationTimestamp(),
            createTitleCommand.getEstateInterest()));

    createTitleCommand.getEntries().stream().map(
        entryWithoutId -> new TitleEntryAddedEvent(
            createTitleCommand.getId(),
                entryWithoutId.getEntrySequence(),
                entryWithoutId.getRoleCode(),
                entryWithoutId.getEntryText()
            )).forEach(AggregateLifecycle::apply);

    createTitleCommand.getProprietors().stream().map(
        proprietorWithoutId -> new ProprietorAddedEvent(
            createTitleCommand.getId(),
                proprietorWithoutId.getForeNames(),
                proprietorWithoutId.getSurname(),
                proprietorWithoutId.getTitle(),
                proprietorWithoutId.getDecor()
            )).forEach(AggregateLifecycle::apply);
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

    AggregateLifecycle.apply(new TitleOpenedEvent(this.id, Status.OPEN));
  }

  @EventSourcingHandler
  protected void on(TitleOpenedEvent titleOpenedEvent) {
    this.status = String.valueOf(titleOpenedEvent.getStatus());
  }

  @CommandHandler
  protected void on(AddTitleEntryCommand addTitleEntryCommand) {
    AggregateLifecycle.apply(
        new TitleEntryAddedEvent(addTitleEntryCommand.getTitleId(),
            addTitleEntryCommand.getEntrySequence(),
            addTitleEntryCommand.getRoleCode(), addTitleEntryCommand.getEntryText()));
  }

  @EventSourcingHandler
  protected void on(TitleEntryAddedEvent titleEntryAddedEvent) {
    this.entries.add(new EntryEntity(UUID.randomUUID().toString(),
        titleEntryAddedEvent.getEntrySequence(),
        titleEntryAddedEvent.getRoleCode(),
        titleEntryAddedEvent.getEntryText()));
  }

  @CommandHandler
  protected void on(AddProprietorCommand addProprietorCommand) {
    AggregateLifecycle.apply(
        new ProprietorAddedEvent(
            addProprietorCommand.getTitleId(),
            addProprietorCommand.getForeNames(),
            addProprietorCommand.getSurname(),
            addProprietorCommand.getTitle(),
            addProprietorCommand.getDecor()));
  }

  @EventSourcingHandler
  protected void on(ProprietorAddedEvent proprietorAddedEvent) {
    this.proprietors.add(new ProprietorEntity(
        UUID.randomUUID().toString(),
        proprietorAddedEvent.getForeNames(),
        proprietorAddedEvent.getSurname(),
        proprietorAddedEvent.getTitle(),
        proprietorAddedEvent.getDecor()
    ));
  }
}