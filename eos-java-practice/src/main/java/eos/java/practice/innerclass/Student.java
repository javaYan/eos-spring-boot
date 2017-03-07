package eos.java.practice.innerclass;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanyuyu on 2017/3/7.
 */
@Getter @Setter @ToString
public class Student {
    private int id;
    private String name;
    private List<Grade> gradeList;

    @Getter @Setter @ToString
    class Grade {
        private String subject;
        private String points;
    }

    public static void main(String args[]) {
        Student student = new Student();
        student.gradeList = new ArrayList<Grade>();
        student.setName("haha");
        student.setId(1);
        Grade grade = student.new Grade();
        grade.setPoints("99");
        grade.setSubject("China");
        student.gradeList.add(grade);

        Grade grade1 = student.new Grade();
        grade1.setPoints("97");
        grade1.setSubject("Math");
        student.gradeList.add(grade1);

        System.out.println(student);
    }
}
