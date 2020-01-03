package com.axonexample.query.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EntryQueryEntity {

  @Id
  private String entryId;

  private Integer entrySequence;
  private String roleCode;
  private String entryText;

}
