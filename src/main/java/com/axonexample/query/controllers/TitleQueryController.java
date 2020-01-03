package com.axonexample.query.controllers;

import com.axonexample.query.entities.TitleQueryEntity;
import com.axonexample.query.services.TitleQueryService;
import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/titles")
@Api(value = "Title Queries", description = "Title Query Events Endpoint", tags = "Title Queries")
public class TitleQueryController {

    private final TitleQueryService titleQueryService;

    public TitleQueryController(TitleQueryService titleQueryService) {
        this.titleQueryService = titleQueryService;
    }

    @GetMapping("/{titleId}")
    public TitleQueryEntity getTitle(@PathVariable(value = "titleId") String titleId){
        return titleQueryService.getTitle(titleId);
    }

    @GetMapping("/{titleId}/events")
    public List<Object> listEventsForTitle(@PathVariable(value = "titleId") String titleId){
        return titleQueryService.listEventsForTitle(titleId);
    }
}
