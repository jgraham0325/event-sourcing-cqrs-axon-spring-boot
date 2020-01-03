package com.example.eventsourcing.aggregates;

import com.example.eventsourcing.entities.EntryWithoutId;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.axonframework.modelling.command.EntityId;

@Value
@EqualsAndHashCode(callSuper = true)
public class EntryEntity extends EntryWithoutId {
  @EntityId
  String entryId;

  public EntryEntity(String entryId, Integer entrySequence, String roleCode, String entryText){
    super(entrySequence,roleCode,entryText);
    this.entryId = entryId;
  }

}
