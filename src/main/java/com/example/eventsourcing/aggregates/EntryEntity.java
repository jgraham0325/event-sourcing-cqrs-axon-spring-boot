package com.example.eventsourcing.aggregates;

import com.example.eventsourcing.commands.AddTitleEntryCommand;
import com.example.eventsourcing.events.TitleActivatedEvent;
import com.example.eventsourcing.events.TitleCreatedEvent;
import com.example.eventsourcing.events.TitleEntryAddedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.EntityId;

public class EntryEntity {

  @EntityId
  public final String entryId;

  public final Integer entrySequence;
  public final  String roleCode;
  public final  String entryText;


  public EntryEntity(String entryId, Integer entrySequence, String roleCode, String entryText) {
    this.entryId = entryId;
    this.entrySequence = entrySequence;
    this.roleCode = roleCode;
    this.entryText = entryText;
  }

}
