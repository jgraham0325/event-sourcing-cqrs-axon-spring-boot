package com.axonexample.command;

import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Value
public class AddTitleEntryCommand{

  @TargetAggregateIdentifier
  String id;
  Integer entrySequence;
  String roleCode;
  String entryText;

}
