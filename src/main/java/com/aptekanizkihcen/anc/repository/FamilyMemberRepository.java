package com.aptekanizkihcen.anc.repository;

import com.aptekanizkihcen.anc.model.FamilyMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Integer> {
}
