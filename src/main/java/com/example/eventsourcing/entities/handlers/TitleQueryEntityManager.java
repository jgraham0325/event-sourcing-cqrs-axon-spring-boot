package com.example.eventsourcing.entities.handlers;

import com.example.eventsourcing.aggregates.TitleAggregate;
import com.example.eventsourcing.entities.EntryQueryEntity;
import com.example.eventsourcing.entities.TitleQueryEntity;
import com.example.eventsourcing.entities.repositories.TitleRepository;
import com.example.eventsourcing.events.BaseEvent;
import java.util.stream.Collectors;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TitleQueryEntityManager {

    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    @Qualifier("titleAggregateEventSourcingRepository")
    private EventSourcingRepository<TitleAggregate> titleAggregateEventSourcingRepository;

    @EventSourcingHandler
    void on(BaseEvent event){
        persistTitle(buildQueryTitle(getTitleFromEvent(event)));
    }


    private TitleAggregate getTitleFromEvent(BaseEvent event){
        return titleAggregateEventSourcingRepository.load(event.id.toString()).getWrappedAggregate().getAggregateRoot();
    }

    private TitleQueryEntity findExistingOrCreateQueryTitle(String id){
        return titleRepository.findById(id).isPresent() ? titleRepository.findById(id).get() : new TitleQueryEntity();
    }

    private TitleQueryEntity buildQueryTitle(TitleAggregate titleAggregate){
        TitleQueryEntity titleQueryEntity = findExistingOrCreateQueryTitle(titleAggregate.getId());

        titleQueryEntity.setId(titleAggregate.getId());
        titleQueryEntity.setTitleNumber(titleAggregate.getTitleNumber());
        titleQueryEntity.setApplicationReference(titleAggregate.getApplicationReference());
        titleQueryEntity.setApplicationTimestamp(titleAggregate.getApplicationTimestamp());
        titleQueryEntity.setClassOfTitle(titleAggregate.getClassOfTitle());
        titleQueryEntity.setEditionDate(titleAggregate.getEditionDate());
        titleQueryEntity.setEstateInterest(titleAggregate.getEstateInterest());
        titleQueryEntity.setStatus(titleAggregate.getStatus());
        titleQueryEntity.setTenure(titleAggregate.getTenure());
        titleQueryEntity.setEntries(titleAggregate.getEntries().stream().map(entry ->
            new EntryQueryEntity(entry.entryId, entry.entrySequence, entry.roleCode, entry.entryText)).collect(
            Collectors.toList()));

        return titleQueryEntity;
    }

    private void persistTitle(TitleQueryEntity titleQueryEntity){
        titleRepository.save(titleQueryEntity);
    }
}
