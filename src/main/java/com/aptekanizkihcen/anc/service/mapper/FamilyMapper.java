package com.aptekanizkihcen.anc.service.mapper;

import com.aptekanizkihcen.anc.dto.FamilyDTO;
import com.aptekanizkihcen.anc.dto.FamilyMemberDTO;
import com.aptekanizkihcen.anc.model.Family;
import com.aptekanizkihcen.anc.model.FamilyMember;

import java.util.List;
import java.util.stream.Collectors;

public class FamilyMapper {

    public static FamilyDTO familyToFamilyDTO(Family family) {
        FamilyDTO familyDTO = new FamilyDTO();
        familyDTO.setId(family.getId());
        familyDTO.setUserDTO(UserMapper.userToUserDTO(family.getUser()));
        List<FamilyMemberDTO> familyMembersDTO = family.getFamilyMembers()
                .stream()
                .map(FamilyMemberMapper::familyMemberToFamilyMemberDTO)
                .collect(Collectors.toList());
        familyDTO.setFamilyMembersDTO(familyMembersDTO);
        return familyDTO;
    }

    public static Family familyDTOtoFamily(FamilyDTO familyDTO) {
        Family family = new Family();
        family.setId(familyDTO.getId());
        family.setUser(UserMapper.userDTOtoUser(familyDTO.getUserDTO()));
        List<FamilyMember> familyMembers = familyDTO.getFamilyMembersDTO()
                .stream()
                .map(FamilyMemberMapper::familyMemberDTOtoFamilyMember)
                .collect(Collectors.toList());
        family.setFamilyMembers(familyMembers);
        return family;
    }
}
