package com.aptekanizkihcen.anc.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class FamilyDTO {

    private int id;
    @NotNull
    private UserDTO userDTO;
    @NotEmpty
    @Valid
    private List<FamilyMemberDTO> familyMembersDTO = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public List<FamilyMemberDTO> getFamilyMembersDTO() {
        return familyMembersDTO;
    }

    public void setFamilyMembersDTO(List<FamilyMemberDTO> familyMembersDTO) {
        this.familyMembersDTO = familyMembersDTO;
    }
}
