package com.example.eventsourcing.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryWithoutId {
  Integer entrySequence;
  String roleCode;
  String entryText;
}
