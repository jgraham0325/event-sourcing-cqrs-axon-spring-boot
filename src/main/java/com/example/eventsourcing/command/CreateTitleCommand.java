package com.example.eventsourcing.command;

import com.example.eventsourcing.entities.EntryWithoutId;
import com.example.eventsourcing.entities.TitleWithoutId;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Value
public class CreateTitleCommand extends TitleWithoutId {
  @TargetAggregateIdentifier
  String id;

  public CreateTitleCommand(
      String id,
      String titleNumber,
      String tenure,
      String classOfTitle,
      LocalDate editionDate,
      String applicationReference,
      OffsetDateTime applicationTimestamp,
      String estateInterest,
      List<EntryWithoutId> entries
      ) {
    super(titleNumber,tenure,classOfTitle,editionDate,applicationReference,applicationTimestamp,estateInterest,entries);
    this.id = id;
  }
}