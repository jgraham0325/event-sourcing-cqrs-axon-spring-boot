package com.example.eventsourcing.dto.commands;

import com.example.eventsourcing.entities.EntryWithoutId;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

public class TitleCreateDTO {

    private String titleNumber;

    private String tenure;

    private String classOfTitle;

    private LocalDate editionDate;

    private String applicationReference;

    private OffsetDateTime applicationTimestamp;

    private String estateInterest;

    private List<EntryWithoutId> entries;

    public String getTitleNumber() {
        return titleNumber;
    }

    public void setTitleNumber(String titleNumber) {
        this.titleNumber = titleNumber;
    }

    public String getTenure() {
        return tenure;
    }

    public void setTenure(String tenure) {
        this.tenure = tenure;
    }

    public String getClassOfTitle() {
        return classOfTitle;
    }

    public void setClassOfTitle(String classOfTitle) {
        this.classOfTitle = classOfTitle;
    }

    public LocalDate getEditionDate() {
        return editionDate;
    }

    public void setEditionDate(LocalDate editionDate) {
        this.editionDate = editionDate;
    }

    public String getApplicationReference() {
        return applicationReference;
    }

    public void setApplicationReference(String applicationReference) {
        this.applicationReference = applicationReference;
    }

    public OffsetDateTime getApplicationTimestamp() {
        return applicationTimestamp;
    }

    public void setApplicationTimestamp(OffsetDateTime applicationTimestamp) {
        this.applicationTimestamp = applicationTimestamp;
    }

    public String getEstateInterest() {
        return estateInterest;
    }

    public void setEstateInterest(String estateInterest) {
        this.estateInterest = estateInterest;
    }

    public List<EntryWithoutId> getEntries() {
        return entries;
    }

    public void setEntries(List<EntryWithoutId> entries) {
        this.entries = entries;
    }
}
