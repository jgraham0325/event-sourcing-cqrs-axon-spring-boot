package com.example.eventsourcing.command.entities;

import lombok.Value;
import org.axonframework.modelling.command.EntityId;

@Value
public class EntryEntity {
  @EntityId
  String entryId;
  Integer entrySequence;
  String roleCode;
  String entryText;
}
