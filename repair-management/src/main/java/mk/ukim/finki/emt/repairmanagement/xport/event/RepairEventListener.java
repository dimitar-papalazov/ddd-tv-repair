package mk.ukim.finki.emt.repairmanagement.xport.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.repairmanagement.domain.model.RepairId;
import mk.ukim.finki.emt.repairmanagement.services.RepairService;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.domain.events.tvproducts.TVProductCreated;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RepairEventListener {

    private final RepairService repairService;

    @KafkaListener(topics = TopicHolder.TOPIC_TVPRODUCT_CREATED, groupId =
            "repairManagement")
    public void consumeTVProductCreatedEvent(String jsonMessage) {
        try {
            TVProductCreated event = DomainEvent.fromJson(jsonMessage,
                    TVProductCreated.class);
            repairService.tvProductCreated(new RepairId(event.getRepairId()),
                    event.getDateTime(), event.getManufacturer());
        } catch (Exception e) {

        }
    }
}
