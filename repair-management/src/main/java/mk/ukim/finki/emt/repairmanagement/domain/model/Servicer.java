package mk.ukim.finki.emt.repairmanagement.domain.model;


import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "servicers")
@Getter
public class Servicer extends AbstractEntity<ServicerId> {
    private String name;
    private String surname;

    private Servicer() {
        super(ServicerId.randomId(ServicerId.class));
    }

    public static Servicer build(@NonNull String name, @NonNull String surname) {
        Servicer servicer = new Servicer();
        servicer.name = name;
        servicer.surname = surname;
        return servicer;
    }
}
