package com.example.eventsourcing.command;

import com.example.eventsourcing.entities.EntryWithoutId;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Value
public class AddTitleEntryCommand extends EntryWithoutId {

  @TargetAggregateIdentifier
  String id;

  public AddTitleEntryCommand(
      String id,
      Integer entrySequence,
      String roleCode,
      String entryText) {
    super(entrySequence, roleCode, entryText);
    this.id = id;
  }
}
