package com.tuanha.spring.project.studentprojectspringdemo.mapper;

import com.tuanha.spring.project.studentprojectspringdemo.dto.ParentDto;
import com.tuanha.spring.project.studentprojectspringdemo.entity.Parent;
import com.tuanha.spring.project.studentprojectspringdemo.repo.MappingEntityToDTO;
import com.tuanha.spring.project.studentprojectspringdemo.exceptionstudent.StudentException;
import com.tuanha.spring.project.studentprojectspringdemo.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ParentMapper implements MappingEntityToDTO<ParentDto, Parent> {
    @Override
    public Function<ParentDto, Parent> dtoEntity() {
        return dto -> {
            Parent parent = new Parent();
            try {
                if(dto.getJob() != null){
                    parent.setJob(dto.getJob());
                }
                if(dto.getCreateAt() != null){
                    parent.setCreateAt(DateUtils.convertStringToDate(dto.getCreateAt()));
                }
                if(dto.getUpdateAt() != null){
                    parent.setUpdateAt(DateUtils.convertStringToDate(dto.getUpdateAt()));
                }
            } catch (StudentException e) {
                throw new RuntimeException(e.getMessage());
            }
            BeanUtils.copyProperties(dto, parent);
            return parent;
        };
    }

    public Function<Parent, ParentDto> entityToDTO() {
        return parent -> {
            ParentDto parentDTO = new ParentDto();
            mapperEntityToDto(parent).accept(parentDTO);
            return parentDTO;
        };
    }

    public Consumer<ParentDto> mapperEntityToDto(Parent parent){
        return parentDTO -> {
            parentDTO.setJob(parent.getJob());
            parentDTO.setCreateAt(DateUtils.convertDateToString(parent.getCreateAt()));
            parentDTO.setUpdateAt(DateUtils.convertDateToString(parent.getUpdateAt()));
            BeanUtils.copyProperties(parent, parentDTO);
        };
    }

    public Function<List<Parent>, List<ParentDto>> listEntityToDTO (){
        return entities -> entities.stream()
                .map(parent -> {
                    ParentDto parentDTO = new ParentDto();
                    mapperEntityToDto(parent).accept(parentDTO);
                    return parentDTO;
                })
                .collect(Collectors.toList());
    }
}
