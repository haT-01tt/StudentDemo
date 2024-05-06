package com.tuanha.spring.project.studentprojectspringdemo.repo;

import java.util.function.BiFunction;

@FunctionalInterface
public interface MappingGeneral<T, U, R> {
    BiFunction<T, U, R> mapping();
}
