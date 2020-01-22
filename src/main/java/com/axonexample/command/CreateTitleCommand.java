package com.axonexample.command;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Value
public class CreateTitleCommand {
  @TargetAggregateIdentifier
  String id;
  String titleNumber;
  String tenure;
  String classOfTitle;
  LocalDate editionDate;
  String applicationReference;
  OffsetDateTime applicationTimestamp;
  String estateInterest;
  List<EntryWithoutId> entries;
  List<ProprietorWithoutId> proprietors;
}