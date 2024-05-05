package com.tuanha.spring.project.studentprojectspringdemo.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionErrorCode {
    IN("Save successful", "INS"),
    UP("Update successful", "UPD"),
    DE("Delete successful", "DEL");

    private final String message;
    private final String code;

    @Getter
    @AllArgsConstructor
    private enum Message {
        STUDENT("Student"),
        SOT("SOT"),
        CLASSIFY_STUDENTS("Classify Students");

        private final String value;
    }

    @AllArgsConstructor
    private enum Action {
        SAVE("Save"),
        UPDATE("Update"),
        DELETE("Delete");

        private final String value;
    }
    @AllArgsConstructor
    @Getter
    public enum StudentMessage {
        STU_001(Action.SAVE.value + " " + Message.STUDENT.value + " successful", "001"),
        STU_002(Action.UPDATE.value + " " + Message.STUDENT.value + " successful", "002"),
        STU_003(Action.DELETE.value + " " + Message.STUDENT.value + " successful", "003");

        private final String message;
        private final String code;

    }
    @AllArgsConstructor
    public enum StudentOrTeacherMessage {
        SOT_004(Action.SAVE.value + " " + Message.SOT.value + " successful", "004"),
        SOT_005(Action.UPDATE.value + " " + Message.SOT.value + " successful", "005"),
        SOT_006(Action.DELETE.value + " " + Message.SOT.value + " successful", "006");

        private final String message;
        private final String code;
    }
    @AllArgsConstructor
    public enum ClassifyStudents {
        CS_007(Action.SAVE.value + " " + Message.CLASSIFY_STUDENTS.value + " successful", "007"),
        CS_008(Action.UPDATE.value + " " + Message.CLASSIFY_STUDENTS.value + " successful", "008"),
        CS_009(Action.DELETE.value + " " + Message.CLASSIFY_STUDENTS.value + " successful", "009");

        private final String message;
        private final String code;
    }
    @AllArgsConstructor
    @Getter
    public enum DateError {
        DATE_007("Convert string to date fail", "DATE007"),
        DATE_008("Convert date to string fail", "DATE008");

        private final String message;
        private final String code;
    }
}
