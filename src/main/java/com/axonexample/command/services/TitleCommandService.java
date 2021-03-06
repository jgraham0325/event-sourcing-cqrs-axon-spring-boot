package com.axonexample.command.services;

import com.axonexample.command.dtos.TitleCreateDTO;
import com.axonexample.command.dtos.TitleEntryAddDTO;
import java.util.concurrent.CompletableFuture;

public interface TitleCommandService {

    CompletableFuture<String> createTitle(TitleCreateDTO titleCreateDTO);

    CompletableFuture<String> addTitleEntry(String titleId, TitleEntryAddDTO titleEntryAddDTO);
}
