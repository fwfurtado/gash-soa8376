package br.com.caelum.gash.user.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String slug;

    /**
     * @deprecated frameworks only
     */
    @Deprecated
    private User() {
    }

    public User(String name, String email, String password, String slug) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.slug = slug;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getSlug() {
        return slug;
    }
}
