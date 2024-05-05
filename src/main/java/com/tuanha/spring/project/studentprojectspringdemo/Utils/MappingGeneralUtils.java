//package com.tuanha.spring.project.studentprojectspringdemo.Utils;
//
//import com.tuanha.spring.project.studentprojectspringdemo.Dto.GeneralDTO;
//import com.tuanha.spring.project.studentprojectspringdemo.Entity.AbtractEntity.AbstractClass;
//import com.tuanha.spring.project.studentprojectspringdemo.Entity.AbtractEntity.AbstractClassEntity;
//import com.tuanha.spring.project.studentprojectspringdemo.Repo.MappingGeneral;
//
//import java.util.function.BiFunction;
//
//public class MappingGeneralUtils implements MappingGeneral<AbstractClass, AbstractClassEntity, GeneralDTO> {
//    @Override
//    public BiFunction<AbstractClass, AbstractClassEntity, GeneralDTO> mapping() {
//        return (a,b) ->{
//            GeneralDTO generalDTO = new GeneralDTO();
//            generalDTO.setName(a.getName());
//            generalDTO.setAddress(b.getAddress());
//            generalDTO.setPhoneNumber(b.getPhoneNumber());
//            generalDTO.setCreateAt(b.getCreateAt());
//            generalDTO.setUpdateAt(b.getUpdateAt());
//            return generalDTO;
//        };
//    }
//}
