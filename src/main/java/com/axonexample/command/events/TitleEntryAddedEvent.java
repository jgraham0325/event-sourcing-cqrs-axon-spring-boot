package com.axonexample.command.events;

import com.axonexample.command.aggregates.entities.EntryEntity;
import lombok.Value;

@Value
public class TitleEntryAddedEvent {
  String titleId;
  Integer entrySequence;
  String roleCode;
  String entryText;

}
