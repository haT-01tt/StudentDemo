package com.tuanha.spring.project.studentprojectspringdemo.service;

import com.tuanha.spring.project.studentprojectspringdemo.dto.BonusStudentModelDto;
import com.tuanha.spring.project.studentprojectspringdemo.entity.BonusStudent;
import com.tuanha.spring.project.studentprojectspringdemo.mapper.BonusMapper;
import com.tuanha.spring.project.studentprojectspringdemo.repo.BonusStudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class BonusStudentService {
    BonusStudentRepository bonusStudentRepository;
    BonusMapper mapper;

    public BonusStudent saveBonus(BonusStudentModelDto dto){
        return bonusStudentRepository.save(mapper.dtoEntity().apply(dto));
    }

    public BonusStudentModelDto getByIdBonus(Integer id){
        return mapper.entityToDto().apply(bonusStudentRepository.findById(id).orElse(null));
    }

    public List<BonusStudentModelDto> getAllBonus(){
        return mapper.listEntityToDto().apply(bonusStudentRepository.findAll());
    }
}
