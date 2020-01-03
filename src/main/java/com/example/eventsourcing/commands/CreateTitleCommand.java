package com.example.eventsourcing.commands;

import com.example.eventsourcing.entities.EntryWithoutId;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

public class CreateTitleCommand extends BaseCommand<String> {

  public final String titleNumber;

  public final String tenure;

  public final String classOfTitle;

  public final LocalDate editionDate;

  public final String applicationReference;

  public final OffsetDateTime applicationTimestamp;

  public final String estateInterest;

  public final List<EntryWithoutId> entries;

  public CreateTitleCommand(String id,
      String titleNumber,
      String tenure,
      String classOfTitle,
      LocalDate editionDate,
      String applicationReference,
      OffsetDateTime applicationTimestamp,
      String estateInterest,
      List<EntryWithoutId> entries) {
    super(id);
    this.titleNumber = titleNumber;
    this.tenure = tenure;
    this.classOfTitle = classOfTitle;
    this.editionDate = editionDate;
    this.applicationReference = applicationReference;
    this.applicationTimestamp = applicationTimestamp;
    this.estateInterest = estateInterest;
    this.entries = entries;
  }
}
