package br.com.caelum.gash.garage.shared.events;

import br.com.caelum.gash.garage.shared.domain.Garage;

public class CreatedGarageEvent {

    private final Long id;
    private final Double latitude;
    private final Double longitude;
    private final Long ownerId;

    CreatedGarageEvent(Long id, Double latitude, Double longitude, Long ownerId) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.ownerId = ownerId;
    }

    public static CreatedGarageEvent from(Garage garage) {
        return new CreatedGarageEvent(garage.getId(), garage.getLatitude(), garage.getLongitude(), garage.getUser().getId());
    }

    public Long getId() {
        return id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Long getOwnerId() {
        return ownerId;
    }
}
