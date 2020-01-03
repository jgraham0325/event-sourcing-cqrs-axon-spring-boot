package com.example.eventsourcing.services.commands;

import com.example.eventsourcing.commands.AddTitleEntryCommand;
import com.example.eventsourcing.commands.CreateTitleCommand;
import com.example.eventsourcing.dto.commands.TitleCreateDTO;
import com.example.eventsourcing.dto.commands.TitleEntryAddDTO;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
public class TitleCommandServiceImpl implements TitleCommandService {

  private final CommandGateway commandGateway;

  public TitleCommandServiceImpl(CommandGateway commandGateway) {
    this.commandGateway = commandGateway;
  }

  @Override
  public CompletableFuture<String> createTitle(TitleCreateDTO titleCreateDTO) {
    return commandGateway.send(
        new CreateTitleCommand(UUID.randomUUID().toString(),
            titleCreateDTO.getTitleNumber(),
            titleCreateDTO.getTenure(),
            titleCreateDTO.getClassOfTitle(),
            titleCreateDTO.getEditionDate(),
            titleCreateDTO.getApplicationReference(),
            titleCreateDTO.getApplicationTimestamp(),
            titleCreateDTO.getEstateInterest(),
            titleCreateDTO.getEntries()));
  }

  @Override
  public CompletableFuture<String> addTitleEntry(String titleId, TitleEntryAddDTO titleEntryAddDTO) {
    return commandGateway.send(
        new AddTitleEntryCommand(titleId,
            titleEntryAddDTO.getEntrySequence(),
            titleEntryAddDTO.getRoleCode(),
            titleEntryAddDTO.getEntryText()));
  }
}
