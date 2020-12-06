package com.aptekanizkihcen.anc.service.mapper;

import com.aptekanizkihcen.anc.dto.FamilyMemberDTO;
import com.aptekanizkihcen.anc.model.FamilyMember;

public class FamilyMemberMapper {

    public static FamilyMemberDTO familyMemberToFamilyMemberDTO(FamilyMember familyMember) {
        FamilyMemberDTO familyMemberDTO = new FamilyMemberDTO();
        familyMemberDTO.setId(familyMember.getId());
        familyMemberDTO.setUsername(familyMember.getUsername());
        familyMemberDTO.setFirstName(familyMember.getFirstName());
        familyMemberDTO.setMiddleName(familyMember.getMiddleName());
        familyMemberDTO.setLastName(familyMember.getLastName());
        familyMemberDTO.setBirthday(familyMember.getBirthday());
        return familyMemberDTO;
    }

    public static FamilyMember familyMemberDTOtoFamilyMember(FamilyMemberDTO familyMemberDTO) {
        FamilyMember familyMember = new FamilyMember();
        familyMember.setId(familyMemberDTO.getId());
        familyMember.setUsername(familyMemberDTO.getUsername());
        familyMember.setFirstName(familyMemberDTO.getFirstName());
        familyMember.setMiddleName(familyMemberDTO.getMiddleName());
        familyMember.setLastName(familyMemberDTO.getLastName());
        familyMember.setBirthday(familyMemberDTO.getBirthday());
        return familyMember;
    }
}
