package org.fastcampus.student_management.domain.dto;

import org.fastcampus.student_management.domain.Course;
import org.fastcampus.student_management.domain.DayOfWeek;

public class CourseInfoDto {

    private final String courseName;
    private final int fee;
    private final DayOfWeek dayOfWeek;
    private final String studentName;
    private final Long courseTime;

    public CourseInfoDto(String courseName, int fee, String dayOfWeek, String studentName,
        Long courseTime) {
        this.courseName = courseName;
        this.fee = fee;
        this.dayOfWeek = DayOfWeek.valueOf(dayOfWeek);
        this.studentName = studentName;
        this.courseTime = courseTime;
    }

    public CourseInfoDto(Course course) {
        this.courseName = course.getCourseName();
        this.fee = course.getFee();
        this.dayOfWeek = course.getDayOfWeek();
        this.studentName = course.getStudentName();
        this.courseTime = course.getCourseTime();
    }

    public String getCourseName() {
        return courseName;
    }

    public int getFee() {
        return fee;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public String getStudentName() {
        return studentName;
    }

    public Long getCourseTime() {
        return courseTime;
    }
}

// 현재 dto를 domain으로 내렸다.
/**
 * 이럴 경우 데이터의 흐름에는 문제가 전혀 없다.
 * 하지만 각 각의 레이어의 역할에 맞는 것인지 다시 한번 생각해보아야 할 것이다.
 * 도메인 레이어는 순수하게 비지니스 로직을 넣기 위해 만든것이다.
 * 하지만 DTO는 데이터를 전달하기 위한 목적을 가진 객체이다.
 * 어플리케이션 레이어에 있는 경우 어플리케이션 레이어는 비지니스 로직을 담당하며 여러 레이어의 협업을 도와주는
 * 레이어이기 때문에 협업을 돕는 레이어 안에 데이터를 전송하는 객체도 있구나 할 것이다.
 *
 * 이러한 부분은 팀원들과 상의해서 결정할 문제이다.
 *
 * 하지만 현재 코드에서는 유지보수 측면에서 봤을 때 이동하는 것이 더 좋다고 판단됨.
 */
