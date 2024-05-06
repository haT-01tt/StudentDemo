package com.tuanha.spring.project.studentprojectspringdemo.repo;

import java.util.function.Function;

@FunctionalInterface
public interface MappingDtoToEntity<T, R> {
     Function<T, R> entityDTO();
}
