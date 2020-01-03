package com.example.eventsourcing.entities;

public class EntryWithoutId {

  public final Integer entrySequence;
  public final String roleCode;
  public final String entryText;

  public EntryWithoutId(Integer entrySequence, String roleCode, String entryText) {
    this.entrySequence = entrySequence;
    this.roleCode = roleCode;
    this.entryText = entryText;
  }

}
