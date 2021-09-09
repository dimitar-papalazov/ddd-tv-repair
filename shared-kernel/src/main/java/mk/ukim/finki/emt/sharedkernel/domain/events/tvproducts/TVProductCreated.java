package mk.ukim.finki.emt.sharedkernel.domain.events.tvproducts;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;

import java.time.LocalDateTime;

@Getter
public class TVProductCreated extends DomainEvent {

    private String repairId;
    private String manufacturer;
    private LocalDateTime dateTime;

    public TVProductCreated(String topic) {
        super(TopicHolder.TOPIC_TVPRODUCT_CREATED);
    }

    public TVProductCreated(String repairId, LocalDateTime dateTime,
                            String manufacturer) {
        super(TopicHolder.TOPIC_TVPRODUCT_CREATED);
        this.dateTime = dateTime;
        this.manufacturer = manufacturer;
        this.repairId = repairId;
    }
}
