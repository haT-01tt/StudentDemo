package com.tuanha.spring.project.studentprojectspringdemo.repo;

import java.util.function.Function;

@FunctionalInterface
public interface MappingEntityToDTO<T, R> {
    Function<T, R> dtoEntity();
}
