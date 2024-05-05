package com.tuanha.spring.project.studentprojectspringdemo.Repo;

import java.util.function.Function;

@FunctionalInterface
public interface MappingEntityToDTO<T, R> {
    Function<T, R> dtoEntity();
}
