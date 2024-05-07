package com.tuanha.spring.project.studentprojectspringdemo.mapper;

import com.tuanha.spring.project.studentprojectspringdemo.dto.BonusStudentModelDto;
import com.tuanha.spring.project.studentprojectspringdemo.entity.BonusStudent;
import com.tuanha.spring.project.studentprojectspringdemo.exceptionstudent.StudentException;
import com.tuanha.spring.project.studentprojectspringdemo.repo.MappingEntityToDTO;
import com.tuanha.spring.project.studentprojectspringdemo.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;


@Component
public class BonusMapper implements MappingEntityToDTO<BonusStudentModelDto, BonusStudent> {
    @Override
    public Function<BonusStudentModelDto, BonusStudent> dtoEntity() {
        return dto -> {
            BonusStudent entity = new BonusStudent();
            try {
                if(dto.getCreateAt() != null){
                    entity.setCreateAt(DateUtils.convertStringToDate(dto.getCreateAt()));
                }
                if(dto.getReceivedDate() != null){
                    entity.setReceivedDate(DateUtils.convertStringToDate(dto.getReceivedDate()));
                }
                if(dto.getUpdateAt() != null){
                    entity.setUpdateAt(DateUtils.convertStringToDate(dto.getUpdateAt()));
                }
            } catch (StudentException e) {
                throw new RuntimeException(e.getMessage());
            }
            BeanUtils.copyProperties(dto, entity);
            return entity;
        };
    }

    public Function<BonusStudent, BonusStudentModelDto> entityToDto() {
        return entity -> {
            BonusStudentModelDto dto = new BonusStudentModelDto();
            mapperEntityToDto(entity).accept(dto);
            return dto;
        };
    }

    public Consumer<BonusStudentModelDto> mapperEntityToDto(BonusStudent entity){
        return dto -> {
            dto.setCreateAt(DateUtils.convertDateToString(entity.getCreateAt()));
            dto.setReceivedDate(DateUtils.convertDateToString(entity.getReceivedDate()));
            dto.setUpdateAt(DateUtils.convertDateToString(entity.getUpdateAt()));
            BeanUtils.copyProperties(entity, dto);
        };
    }

    public Function<List<BonusStudent>, List<BonusStudentModelDto>> listEntityToDto() {
        return entities -> entities.stream()
                .map(entity -> {
                    BonusStudentModelDto dto = new BonusStudentModelDto();
                    mapperEntityToDto(entity).accept(dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
