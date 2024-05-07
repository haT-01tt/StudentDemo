package com.tuanha.spring.project.studentprojectspringdemo.service;

import com.tuanha.spring.project.studentprojectspringdemo.dto.BonusStudentDto;
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

    public BonusStudent saveBonus(BonusStudentDto dto){
        return bonusStudentRepository.save(mapper.dtoEntity().apply(dto));
    }

    public BonusStudentDto getByIdBonus(Integer id){
        return mapper.entityToDto().apply(bonusStudentRepository.findById(id).orElse(null));
    }

    public List<BonusStudentDto> getAllBonus(){
        return mapper.listEntityToDto().apply(bonusStudentRepository.findAll());
    }
}
