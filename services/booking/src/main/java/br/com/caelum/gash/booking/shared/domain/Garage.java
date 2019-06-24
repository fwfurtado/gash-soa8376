package br.com.caelum.gash.booking.shared.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Garage {
    @Id
    private Long id;

    @ManyToOne
    private User partner;

    @Deprecated
    private Garage() {
    }

    public Garage(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public User getPartner() {
        return partner;
    }

    public void setPartner(User partner) {
        this.partner = partner;
    }
}
