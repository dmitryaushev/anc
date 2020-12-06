package com.aptekanizkihcen.anc.service.impl;

import com.aptekanizkihcen.anc.model.Family;
import com.aptekanizkihcen.anc.model.FamilyMember;
import com.aptekanizkihcen.anc.repository.FamilyRepository;
import com.aptekanizkihcen.anc.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamilyServiceImpl implements FamilyService {

    private FamilyRepository familyRepository;

    @Autowired
    public FamilyServiceImpl(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    @Override
    public Family createFamily(Family family) {
        family.setId(family.getUser().getId());
        List<FamilyMember> familyMembers = family.getFamilyMembers();
        familyMembers.forEach(familyMember -> familyMember.setFamily(family));
        family.setFamilyMembers(familyMembers);
        return familyRepository.save(family);
    }

    @Override
    public Optional<Family> getFamilyById(int id) {
        return familyRepository.findById(id);
    }
}
