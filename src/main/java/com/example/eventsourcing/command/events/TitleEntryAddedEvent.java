package com.example.eventsourcing.command.events;

import lombok.Value;

@Value
public class TitleEntryAddedEvent {
  String id;
  Integer entrySequence;
  String roleCode;
  String entryText;

}
