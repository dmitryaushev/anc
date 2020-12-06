package com.aptekanizkihcen.anc.service;

import com.aptekanizkihcen.anc.model.Family;

import java.util.Optional;

public interface FamilyService {

    Family createFamily(Family family);

    Optional<Family> getFamilyById(int id);
}
