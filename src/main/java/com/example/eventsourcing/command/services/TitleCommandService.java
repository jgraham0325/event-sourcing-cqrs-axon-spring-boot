package com.example.eventsourcing.command.services;

import com.example.eventsourcing.command.dtos.TitleCreateDTO;
import com.example.eventsourcing.command.dtos.TitleEntryAddDTO;
import java.util.concurrent.CompletableFuture;

public interface TitleCommandService {

    CompletableFuture<String> createTitle(TitleCreateDTO titleCreateDTO);

    CompletableFuture<String> addTitleEntry(String titleId, TitleEntryAddDTO titleEntryAddDTO);
}
