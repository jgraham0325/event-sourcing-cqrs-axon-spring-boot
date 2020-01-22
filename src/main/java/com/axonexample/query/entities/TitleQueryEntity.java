package com.axonexample.query.entities;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class TitleQueryEntity {
    @Id
    private String id;
    private String titleNumber;
    private String status;
    private String tenure;
    private String classOfTitle;
    private LocalDate editionDate;
    private String applicationReference;
    private OffsetDateTime applicationTimestamp;
    private String estateInterest;

    @OneToMany(cascade = CascadeType.ALL)
    private List<EntryQueryEntity> entries;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProprietorQueryEntity> proprietors;
}
