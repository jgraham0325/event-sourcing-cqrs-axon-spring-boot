package com.axonexample.command;

import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Value
public class AddProprietorCommand {

  @TargetAggregateIdentifier
  String titleId;
  String foreNames;
  String surname;
  String title;
  String decor;

}
