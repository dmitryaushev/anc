package com.aptekanizkihcen.anc.repository;

import com.aptekanizkihcen.anc.model.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository extends JpaRepository<Family, Integer> {
}
