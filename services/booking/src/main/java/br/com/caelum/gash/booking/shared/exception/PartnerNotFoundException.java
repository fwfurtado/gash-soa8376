package br.com.caelum.gash.booking.shared.exception;

public class PartnerNotFoundException extends IllegalArgumentException {

    private final Long partnerId;

    public PartnerNotFoundException(Long id) {
        super(String.format("Cannot find partner with id '%s'", id));
        this.partnerId = id;
    }

    public Long getPartnerId() {
        return partnerId;
    }
}
