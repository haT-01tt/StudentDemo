package com.tuanha.spring.project.studentprojectspringdemo.service;

import com.tuanha.spring.project.studentprojectspringdemo.dto.ParentDto;
import com.tuanha.spring.project.studentprojectspringdemo.entity.Parent;
import com.tuanha.spring.project.studentprojectspringdemo.mapper.ParentMapper;
import com.tuanha.spring.project.studentprojectspringdemo.repo.ParentRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@Service
public class ParentService {
    ParentRepository parentRepository;
    ParentMapper mapper;

    public Parent saveParentStudent(ParentDto parentDTO) {
        return parentRepository.save(mapper.dtoEntity().apply(parentDTO));
    }

    public ParentDto getByIdParentStudent(Integer id) {
        return mapper.entityToDTO().apply(parentRepository.findById(id).orElse(null));
    }

    public List<ParentDto> getAllParentStudent() {
        return mapper.listEntityToDTO().apply(parentRepository.findAll());
    }
    public List<ParentDto> getAllById(List<Integer> ids) {
        return mapper.listEntityToDTO().apply(parentRepository.findAllById(ids));
    }

    //JPA Repository
    public Parent saveParent(ParentDto parentDTO){
        return parentRepository.save(mapper.dtoEntity().apply(parentDTO));
    }

    public List<ParentDto> getAllParent(){
        return mapper.listEntityToDTO().apply(parentRepository.findAll());
    }

    public ParentDto getByIdParent(Integer id){
        return mapper.entityToDTO().apply(parentRepository.findById(id).get());
    }
    public Optional<ParentDto> getAllById(Integer id){
        return Optional.ofNullable(mapper.entityToDTO().apply(parentRepository.findAllById(id).get()));
    }

}
