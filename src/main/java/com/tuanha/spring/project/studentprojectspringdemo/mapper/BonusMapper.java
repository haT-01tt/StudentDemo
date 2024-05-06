package com.tuanha.spring.project.studentprojectspringdemo.mapper;

import com.tuanha.spring.project.studentprojectspringdemo.dto.BonusStudentModelDto;
import com.tuanha.spring.project.studentprojectspringdemo.entity.BonusStudent;
import com.tuanha.spring.project.studentprojectspringdemo.exceptionstudent.StudentException;
import com.tuanha.spring.project.studentprojectspringdemo.repo.MappingEntityToDTO;
import com.tuanha.spring.project.studentprojectspringdemo.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.function.Function;


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
}
