package com.example.eventsourcing.services.commands;

import com.example.eventsourcing.dto.commands.TitleCreateDTO;
import java.util.concurrent.CompletableFuture;

public interface TitleCommandService {

    public CompletableFuture<String> createTitle(TitleCreateDTO titleCreateDTO);
}
