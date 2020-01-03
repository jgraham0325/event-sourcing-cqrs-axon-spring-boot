package com.example.eventsourcing.events;

import lombok.Value;

@Value
public class TitleEntryAddedEvent {
  String id;
  Integer entrySequence;
  String roleCode;
  String entryText;

}
