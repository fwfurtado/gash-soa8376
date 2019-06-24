package br.com.caelum.gash.garage.shared.exceptions;

public class UserNotFoundException extends IllegalArgumentException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
