package com.example.eventsourcing.command.dtos;

import com.example.eventsourcing.command.EntryWithoutId;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Data;

@Data
public class TitleCreateDTO {
  private String titleNumber;
  private String tenure;
  private String classOfTitle;
  private LocalDate editionDate;
  private String applicationReference;
  private OffsetDateTime applicationTimestamp;
  private String estateInterest;
  private List<EntryWithoutId> entries;
}
