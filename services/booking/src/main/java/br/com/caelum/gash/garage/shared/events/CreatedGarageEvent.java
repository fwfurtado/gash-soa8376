package br.com.caelum.gash.garage.shared.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.StringJoiner;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatedGarageEvent {
    private Long id;
    private Long ownerId;

    @Deprecated
    private CreatedGarageEvent() {
    }

    public CreatedGarageEvent(Long id, Long ownerId) {
        this.id = id;
        this.ownerId = ownerId;
    }

    public Long getId() {
        return id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CreatedGarageEvent.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("ownerId=" + ownerId)
            .toString();
    }
}
