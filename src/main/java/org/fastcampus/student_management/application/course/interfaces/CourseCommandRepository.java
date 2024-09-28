package org.fastcampus.student_management.application.course.interfaces;

import java.util.List;
import org.fastcampus.student_management.domain.Course;

public interface CourseCommandRepository {
    void save(Course course);
    /**
     * 인터페이스 꿀팁!
     * 저장 메소드와 조회 메소드를 분리하여 저장하면 더 좋다.
     * 프로젝트가 작은 규모의 경우 대부분 저장과 조회를 같은 DB에 하게 된다.
     * 물론 이 경우가 쉽고 더 직관적이다.
     *
     * 하지만 사용자나 데이터가 기하급수적으로 늘게 되면 저장과 조회를 다른 DB에서 수행하게 될 수도 있다.
     * 종종 있음.
     *
     */
}
