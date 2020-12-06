package com.aptekanizkihcen.anc.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "family_member")
@Component
public class FamilyMember extends BaseEntity {

    @ManyToOne
    private Family family;

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }
}
