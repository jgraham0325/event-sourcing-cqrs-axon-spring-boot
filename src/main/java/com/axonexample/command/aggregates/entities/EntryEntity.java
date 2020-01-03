package com.axonexample.command.aggregates.entities;

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
