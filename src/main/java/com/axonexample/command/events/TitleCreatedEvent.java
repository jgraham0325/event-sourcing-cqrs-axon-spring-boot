package com.axonexample.command.events;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import lombok.Value;

@Value
public class TitleCreatedEvent {
  String id;
  String titleNumber;
  String tenure;
  String classOfTitle;
  LocalDate editionDate;
  String applicationReference;
  OffsetDateTime applicationTimestamp;
  String estateInterest;
}
