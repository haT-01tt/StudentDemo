package com.tuanha.spring.project.studentprojectspringdemo.service;

import com.tuanha.spring.project.studentprojectspringdemo.dto.ParentDto;
import com.tuanha.spring.project.studentprojectspringdemo.entity.Parent;
import com.tuanha.spring.project.studentprojectspringdemo.exceptionstudent.NotFoundException;
import com.tuanha.spring.project.studentprojectspringdemo.mapper.FnMapper;
import com.tuanha.spring.project.studentprojectspringdemo.mapper.ParentMapper;
import com.tuanha.spring.project.studentprojectspringdemo.repo.ParentRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@Service
public class ParentService {
    ParentRepository parentRepository;
    private final ParentMapper parentMapper;
    //ParentMapper mapper;

    public Parent saveParentStudent(ParentDto parentDTO) {
        return parentRepository.save(FnMapper.createEntity(Parent::new,
                parent -> BeanUtils.copyProperties(parentDTO, parent)));
    }


    public ParentDto getByIdParentStudent(Integer id) {
        Parent parent = parentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Parent not found with id" + id));
        return FnMapper.createEntity(ParentDto::new,
                parentMapper.mapperEntityToDto(parent)
                        .andThen(FnMapper.consumer(parent)));
    }

    public List<ParentDto> getAllParentStudent() {
        return FnMapper.<Parent, ParentDto>mapperList(ParentDto::new).apply(parentRepository.findAll());
    }
    public List<ParentDto> getAllById(List<Integer> ids) {
        List<Parent> parents = parentRepository.findAllById(ids);
        if(parents.isEmpty()){
            throw new NotFoundException("Parent not found with ID: " + ids);
        }
        return FnMapper.<Parent, ParentDto>mapperList(ParentDto::new).apply(parents);
    }

    //JPA Repository
    public Parent saveParent(ParentDto parentDTO){
        return parentRepository.save(FnMapper.createEntity(Parent::new,
                parent -> BeanUtils.copyProperties(parentDTO, parent)));
    }

    public List<ParentDto> getAllParent(){
        return FnMapper.<Parent, ParentDto>mapperList(ParentDto::new).apply(parentRepository.findAll());
    }

    public ParentDto getByIdParent(Integer id){
        Parent parent = parentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Parent not found with id" + id));
        return FnMapper.createEntity(ParentDto::new,
                parentMapper.mapperEntityToDto(parent)
                        .andThen(FnMapper.consumer(parent)));
    }
    public Optional<ParentDto> getAllById(Integer id){
        return Optional.ofNullable(FnMapper.dtoEntity(ParentDto::new).apply(parentRepository.findAllById(id).get()));
    }

}
