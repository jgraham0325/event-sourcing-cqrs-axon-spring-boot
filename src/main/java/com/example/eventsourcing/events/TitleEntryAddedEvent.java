package com.example.eventsourcing.events;

public class TitleEntryAddedEvent extends BaseEvent<String> {

  private Integer entrySequence;

  private String roleCode;

  private String entryText;

  public TitleEntryAddedEvent(String id, Integer entrySequence, String roleCode,
      String entryText) {
    super(id);
    this.entrySequence = entrySequence;
    this.roleCode = roleCode;
    this.entryText = entryText;
  }

  public Integer getEntrySequence() {
    return entrySequence;
  }

  public String getRoleCode() {
    return roleCode;
  }

  public String getEntryText() {
    return entryText;
  }
}
