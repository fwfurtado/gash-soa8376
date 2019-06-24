package br.com.caelum.gash.garage.shared.exceptions;

public class GarageNotFoundException extends IllegalArgumentException {

    public GarageNotFoundException(String message) {
        super(message);
    }
}
