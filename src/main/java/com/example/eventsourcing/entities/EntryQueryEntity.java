package com.example.eventsourcing.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class EntryQueryEntity {

  @Id
  private String entryId;

  private Integer entrySequence;
  private String roleCode;
  private String entryText;

  public EntryQueryEntity(String entryId, Integer entrySequence, String roleCode, String entryText) {
    this.entryId = entryId;
    this.entrySequence = entrySequence;
    this.roleCode = roleCode;
    this.entryText = entryText;
  }

  public EntryQueryEntity() {}

}
