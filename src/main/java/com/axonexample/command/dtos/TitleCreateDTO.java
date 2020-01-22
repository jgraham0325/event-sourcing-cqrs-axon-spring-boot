package com.axonexample.command.dtos;

import com.axonexample.command.EntryWithoutId;
import com.axonexample.command.ProprietorWithoutId;
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
  private List<ProprietorWithoutId> proprietors;
}
