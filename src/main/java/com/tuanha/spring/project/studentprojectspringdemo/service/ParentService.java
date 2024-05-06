package com.tuanha.spring.project.studentprojectspringdemo.service;

import com.tuanha.spring.project.studentprojectspringdemo.dto.ParentDTO;
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

    public Parent saveParentStudent(ParentDTO parentDTO) {
        return parentRepository.save(mapper.dtoEntity().apply(parentDTO));
    }

    public ParentDTO getByIdParentStudent(Integer id) {
        return mapper.entityToDTO().apply(parentRepository.findById(id).orElse(null));
    }

    public List<ParentDTO> getAllParentStudent() {
        return mapper.listEntityToDTO().apply(parentRepository.findAll());
    }
    public List<ParentDTO> getAllById(List<Integer> ids) {
        return mapper.listEntityToDTO().apply(parentRepository.findAllById(ids));
    }

    //JPA Repository
    public Parent saveParent(ParentDTO parentDTO){
        return parentRepository.save(mapper.dtoEntity().apply(parentDTO));
    }

    public List<ParentDTO> getAllParent(){
        return mapper.listEntityToDTO().apply(parentRepository.findAll());
    }

    public ParentDTO getByIdParent(Integer id){
        return mapper.entityToDTO().apply(parentRepository.findById(id).get());
    }
    public Optional<ParentDTO> getAllById(Integer idStudent){
        return Optional.ofNullable(mapper.entityToDTO().apply(parentRepository.findAllByIdStudent(idStudent).get()));
    }

}
