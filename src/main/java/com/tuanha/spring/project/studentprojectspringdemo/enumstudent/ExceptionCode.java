package com.tuanha.spring.project.studentprojectspringdemo.enumstudent;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionCode {
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
        CLASSIFY_STUDENTS("Classify Students"),
        PARENT_STUDENT("Parent Student");

        private final String value;
    }

    @AllArgsConstructor
    private enum Action {
        SAVE("Save"),
        UPDATE("Update"),
        DELETE("Delete"),
        FIND("Find"),
        NOT_FOUND("Not found");

        private final String value;
    }
    @AllArgsConstructor
    @Getter
    public enum StudentMessage {
        STU_001(Action.SAVE.value + " " + Message.STUDENT.value + " successful", "STU-001"),
        STU_002(Action.UPDATE.value + " " + Message.STUDENT.value + " successful", "STU-002"),
        STU_003(Action.DELETE.value + " " + Message.STUDENT.value + " successful", "STU-003"),
        STU_010(Action.SAVE.value + " " + Message.STUDENT.value + " fail", "STU-010"),
        STU_011(Action.UPDATE.value + " " + Message.STUDENT.value + " fail", "STU-011"),
        STU_012(Action.DELETE.value + " " + Message.STUDENT.value + " fail", "STU-012"),
        STU_013(Action.FIND.value + " " + Message.STUDENT.value + " successful", "STU-013"),
        STU_014(Action.NOT_FOUND.value + " " + Message.STUDENT.value + " fail", "STU-014")
        ;

        private final String message;
        private final String code;

    }
    @AllArgsConstructor
    @Getter
    public enum StudentOrTeacherMessage {
        SOT_004(Action.SAVE.value + " " + Message.SOT.value + " successful", "SOT-004"),
        SOT_005(Action.UPDATE.value + " " + Message.SOT.value + " successful", "SOT-005"),
        SOT_006(Action.DELETE.value + " " + Message.SOT.value + " successful", "SOT-006");

        private final String message;
        private final String code;
    }
    @AllArgsConstructor
    @Getter
    public enum ClassifyStudents {
        CS_007(Action.SAVE.value + " " + Message.CLASSIFY_STUDENTS.value + " successful", "CS-007"),
        CS_008(Action.UPDATE.value + " " + Message.CLASSIFY_STUDENTS.value + " successful", "CS-008"),
        CS_009(Action.DELETE.value + " " + Message.CLASSIFY_STUDENTS.value + " successful", "CS-009");

        private final String message;
        private final String code;
    }
    @AllArgsConstructor
    @Getter
    public enum DateError {
        DATE_007("Convert string to date fail", "DATE-007"),
        DATE_008("Convert date to string fail", "DATE-008");

        private final String message;
        private final String code;
    }

    @AllArgsConstructor
    @Getter
    public enum ParentStudentMessage {
        PR_STU_001(Action.SAVE.value + " " + Message.PARENT_STUDENT.value + " successful", "PR_STU-001"),
        PR_STU_002(Action.UPDATE.value + " " + Message.PARENT_STUDENT.value + " successful", "PR_STU-002"),
        PR_STU_003(Action.DELETE.value + " " + Message.PARENT_STUDENT.value + " successful", "PR_STU-003"),
        PR_STU_010(Action.SAVE.value + " " + Message.PARENT_STUDENT.value + " fail", "PR_STU-010"),
        PR_STU_011(Action.UPDATE.value + " " + Message.PARENT_STUDENT.value + " fail", "PR_STU-011"),
        PR_STU_012(Action.DELETE.value + " " + Message.PARENT_STUDENT.value + " fail", "PR_STU-012"),
        PR_STU_013(Action.FIND.value + " " + Message.PARENT_STUDENT.value + " successful", "PR_STU-013"),
        PR_STU_014(Action.NOT_FOUND.value + " " + Message.PARENT_STUDENT.value + " fail", "PR_STU-014")
        ;

        private final String message;
        private final String code;

    }
}
