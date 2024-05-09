package com.tuanha.spring.project.studentprojectspringdemo.mapper;

import com.tuanha.spring.project.studentprojectspringdemo.dto.ParentDto;
import com.tuanha.spring.project.studentprojectspringdemo.dto.ParentStudentDto;
import com.tuanha.spring.project.studentprojectspringdemo.dto.StudentDto;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FnMapper {
    public static<T, R> Function<List<T>, List<R>> mapperList(Supplier<R> supplier) {
        return entity -> entity.stream().map(e -> {
            R dto = supplier.get();
            BeanUtils.copyProperties(e, dto);
            return dto;
        }).collect(Collectors.toList());
    }
    public static <T> T createEntity(Supplier<T> getEntity, Consumer<T> consumer){
        T entity = getEntity.get();
        consumer.accept(entity);
        return entity;
    }
    public static <T,R> Function<T, R> dtoEntity(Supplier<R> supplier) {
        return dto -> {
            R parent = supplier.get();
            BeanUtils.copyProperties(dto, parent);
            return parent;
        };
    }
    public static <T, R> Page<T> convertPage(Page<R> page, Supplier<T> supplier){
        return new PageImpl<>(page.stream().map(entity -> {
            T dto = supplier.get();
            BeanUtils.copyProperties(entity, dto);
            return dto;
        }).toList());
    }
    public static <T, R, U> BiFunction<T, R, U> mapperBiEntityDto(Supplier<U> supplier, Consumer<U> consumer) {
        return (p, s) -> {
            U modelDto = supplier.get();
            consumer.accept(modelDto);
            return modelDto;
        };
    }

    public static<T, R> Consumer<R> consumer (T entity){
        return dto -> BeanUtils.copyProperties(entity, dto);
    }
}
