package com.aptekanizkihcen.anc.controller;

import com.aptekanizkihcen.anc.dto.FamilyDTO;
import com.aptekanizkihcen.anc.model.Family;
import com.aptekanizkihcen.anc.service.FamilyService;
import com.aptekanizkihcen.anc.service.mapper.FamilyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/family")
public class FamilyController {

    private FamilyService familyService;

    @Autowired
    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    @PostMapping("create")
    public ResponseEntity<FamilyDTO> createFamily(@Valid @RequestBody FamilyDTO familyDTO) {
        Family family = familyService.createFamily(FamilyMapper.familyDTOtoFamily(familyDTO));
        familyDTO = FamilyMapper.familyToFamilyDTO(family);
        return ResponseEntity.ok(familyDTO);
    }

    @GetMapping("{id}")
    public ResponseEntity<FamilyDTO> getFamily(@PathVariable int id) {
        Optional<Family> familyOptional = familyService.getFamilyById(id);
        if (familyOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        FamilyDTO familyDTO = FamilyMapper.familyToFamilyDTO(familyOptional.get());
        return ResponseEntity.ok(familyDTO);
    }
}
