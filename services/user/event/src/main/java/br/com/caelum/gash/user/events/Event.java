package br.com.caelum.gash.user.events;

import java.time.ZonedDateTime;

public class Event {

    private ZonedDateTime time = ZonedDateTime.now();

    public ZonedDateTime getTime() {
        return time;
    }
}
