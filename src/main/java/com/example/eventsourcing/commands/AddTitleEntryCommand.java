package com.example.eventsourcing.commands;

public class AddTitleEntryCommand extends BaseCommand<String> {

  public final Integer entrySequence;

  public final String roleCode;

  public final String entryText;

  public AddTitleEntryCommand(String titleId, Integer entrySequence, String roleCode, String entryText) {
    super(titleId);
    this.entrySequence = entrySequence;
    this.roleCode = roleCode;
    this.entryText = entryText;
  }

  @Override
  public String toString() {
    return "AddTitleEntryCommand{" +
        "entrySequence=" + entrySequence +
        ", roleCode='" + roleCode + '\'' +
        ", entryText='" + entryText + '\'' +
        ", id=" + id +
        '}';
  }
}
