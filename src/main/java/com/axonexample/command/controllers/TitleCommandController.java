package com.axonexample.command.controllers;

import com.axonexample.command.dtos.TitleCreateDTO;
import com.axonexample.command.dtos.TitleEntryAddDTO;
import com.axonexample.command.services.TitleCommandService;
import io.swagger.annotations.Api;
import java.util.concurrent.CompletableFuture;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/titles")
@Api(value = "Title Commands", description = "Title Commands Related Endpoints", tags = "Title Commands")
public class TitleCommandController {

    private final TitleCommandService titleCommandService;

    public TitleCommandController(TitleCommandService titleCommandService) {
        this.titleCommandService = titleCommandService;
    }

    @PostMapping
    public CompletableFuture<String> createTitle(@RequestBody TitleCreateDTO titleCreateDTO){
        return titleCommandService.createTitle(titleCreateDTO);
    }

    @PostMapping(value = "/{titleId}/entries")
    public CompletableFuture<String> addEntryToTitle(
        @PathVariable(value = "titleId") String titleId,
        @RequestBody TitleEntryAddDTO titleEntryAddDTO) {
        return titleCommandService.addTitleEntry(titleId, titleEntryAddDTO);
    }


}
