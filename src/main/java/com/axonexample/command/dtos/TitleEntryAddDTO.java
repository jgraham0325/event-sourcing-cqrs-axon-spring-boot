package com.axonexample.command.dtos;

import lombok.Data;

@Data
public class TitleEntryAddDTO {
  Integer entrySequence;
  String roleCode;
  String entryText;
}
