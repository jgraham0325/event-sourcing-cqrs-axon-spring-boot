package com.example.eventsourcing.entities;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TitleWithoutId {
  private String titleNumber;
  private String tenure;
  private String classOfTitle;
  private LocalDate editionDate;
  private String applicationReference;
  private OffsetDateTime applicationTimestamp;
  private String estateInterest;
  private List<EntryWithoutId> entries;
}
