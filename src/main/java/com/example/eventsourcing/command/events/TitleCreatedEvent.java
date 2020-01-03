package com.example.eventsourcing.command.events;

import com.example.eventsourcing.command.entities.EntryEntity;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
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
  List<EntryEntity> entries;
}
