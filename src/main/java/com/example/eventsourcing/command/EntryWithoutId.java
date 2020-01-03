package com.example.eventsourcing.command;

import lombok.Value;

@Value
public class EntryWithoutId {
  Integer entrySequence;
  String roleCode;
  String entryText;
}
