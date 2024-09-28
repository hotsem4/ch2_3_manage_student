package org.fastcampus.student_management.application.course;

import java.util.List;
import org.fastcampus.student_management.domain.dto.CourseInfoDto;
import org.fastcampus.student_management.application.course.interfaces.CourseCommandRepository;
import org.fastcampus.student_management.application.course.interfaces.CourseQueryRepository;
import org.fastcampus.student_management.domain.Course;
import org.fastcampus.student_management.domain.CourseList;
import org.fastcampus.student_management.domain.DayOfWeek;
import org.fastcampus.student_management.domain.Student;
import org.fastcampus.student_management.repo.CourseCommandRepositoryImpl;
import org.fastcampus.student_management.repo.StudentRepository;

public class CourseService {

    private final CourseCommandRepository courseRepository;
    private final CourseQueryRepository courseQueryRepository;
    private final StudentRepository studentRepository;

    public CourseService(CourseCommandRepositoryImpl courseRepository,
        CourseQueryRepository courseQueryRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.courseQueryRepository = courseQueryRepository;
        this.studentRepository = studentRepository;
    }

    public void registerCourse(CourseInfoDto courseInfoDto) {
        Student student = studentRepository.getStudents(courseInfoDto.getStudentName());
        Course course = new Course(student, courseInfoDto);
        courseRepository.save(course);
    }

//    public List<CourseInfoDto> getCourseDayOfWeek(DayOfWeek dayOfWeek) {
//        List<Course> courseDayOfWeek = courseRepository.getCourseDayOfWeek(dayOfWeek);
//        ArrayList<CourseInfoDto> courseInfoDtos = new ArrayList<>();
//        for (Course course : courseDayOfWeek) {
//            if (course.isActivateUser()){
//                CourseInfoDto courseDto = new CourseInfoDto(course);
//                courseInfoDtos.add(courseDto);
//            }
//        }
//        return courseInfoDtos;
//    }
public List<CourseInfoDto> getCourseDayOfWeek(DayOfWeek dayOfWeek) {
    List<Course> courses = courseQueryRepository.getCourseDayOfWeek(dayOfWeek);
    return courses.stream()
        .filter(Course::isActivateUser) // 학생이 활성화 된 경우에만
        .map(CourseInfoDto::new) // Course 객체를 CourseInfoDto로 변환시켜
        .toList();  // List 형태로 반환핟나.
}



//    public void changeFee(String studentName, int fee) {
//        List<Course> courseListByStudent = courseRepository.getCourseListByStudent(studentName);
//        for (Course course : courseListByStudent) {
//            course.domainChangeFee(fee);
//            String string = course.toString();
//            System.out.println(string);
//        }
//        courseRepository.saveCourses(courseListByStudent);
//    }
    public void changeFee(String studentName, int fee) {
        List<Course> courses = courseQueryRepository.getCourseListByStudent(studentName);
        CourseList courseList = new CourseList(courses);
        courseList.changeAllCoursesFee(fee);
    }
    /**
     * 1급 컬렉션의 장점
     * 1. 로직을 한눈에 파악하기가 쉽다.
     */
}
