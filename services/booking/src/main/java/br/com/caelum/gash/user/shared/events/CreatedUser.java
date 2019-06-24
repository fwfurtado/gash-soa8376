package br.com.caelum.gash.user.shared.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.StringJoiner;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatedUser {
    private Long id;
    private String name;

    private CreatedUser() {
    }

    public CreatedUser(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CreatedUser.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("name='" + name + "'")
            .toString();
    }
}
