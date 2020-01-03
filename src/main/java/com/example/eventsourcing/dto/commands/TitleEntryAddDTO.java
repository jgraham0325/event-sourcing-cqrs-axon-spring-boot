package com.example.eventsourcing.dto.commands;

import lombok.Data;

@Data
public class TitleEntryAddDTO {

    private Integer entrySequence;

    private String roleCode;

    private String entryText;
}
