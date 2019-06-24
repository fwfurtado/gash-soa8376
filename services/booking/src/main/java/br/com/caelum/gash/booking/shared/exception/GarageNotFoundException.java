package br.com.caelum.gash.booking.shared.exception;

public class GarageNotFoundException extends IllegalArgumentException {

    private final Long garageId;

    public GarageNotFoundException(Long id) {
        super(String.format("Cannot find garage with id '%s'", id));
        this.garageId = id;
    }

    public Long getGarageId() {
        return garageId;
    }
}
