package org.fastcampus.student_management;

import org.fastcampus.student_management.application.course.CourseService;
import org.fastcampus.student_management.application.course.dto.CourseInfoDto;
import org.fastcampus.student_management.application.student.StudentService;
import org.fastcampus.student_management.application.student.dto.StudentInfoDto;
import org.fastcampus.student_management.repo.CourseRepository;
import org.fastcampus.student_management.repo.StudentRepository;
import org.fastcampus.student_management.ui.course.CourseController;
import org.fastcampus.student_management.ui.course.CoursePresenter;
import org.fastcampus.student_management.ui.student.StudentController;
import org.fastcampus.student_management.ui.student.StudentPresenter;
import org.fastcampus.student_management.ui.UserInputType;

public class  Main {

  public static void main(String[] args) {
    StudentRepository studentRepository = new StudentRepository();
    CourseRepository courseRepository = new CourseRepository();

    StudentService studentService = new StudentService(studentRepository);
    CourseService courseService = new CourseService(courseRepository, studentService);

    CoursePresenter coursePresenter = new CoursePresenter();
    StudentPresenter studentPresenter = new StudentPresenter();

    CourseController courseController = new CourseController(coursePresenter, courseService, studentPresenter);
    StudentController studentController = new StudentController(studentPresenter, studentService);

    // default 세팅 추가
    StudentInfoDto studentInfoDto = new StudentInfoDto("홍길동", 20, "서울시 강남구");
    StudentInfoDto studentInfoDto1 = new StudentInfoDto("안흥도", 21, "서울시 마포구");
    StudentInfoDto studentInfoDto2 = new StudentInfoDto("최범수", 27, "당진시 합덕읍");
    studentService.saveStudent(studentInfoDto);
    studentService.saveStudent(studentInfoDto1);
    studentService.saveStudent(studentInfoDto2);

    CourseInfoDto courseInfoDto = new CourseInfoDto("바이올린", 1000, "MONDAY", "홍길동", 1717299008L);
    CourseInfoDto courseInfoDto1 = new CourseInfoDto("첼로", 1020, "MONDAY", "안흥도", 1217299008L);
    CourseInfoDto courseInfoDto2 = new CourseInfoDto("돈까스", 1040, "TUESDAY", "최범수", 1215299008L);
    CourseInfoDto courseInfoDto3 = new CourseInfoDto("도시락만들기", 1048, "MONDAY", "최범수", 1215298008L);
    courseService.registerCourse(courseInfoDto);
    courseService.registerCourse(courseInfoDto1);
    courseService.registerCourse(courseInfoDto2);
    courseService.registerCourse(courseInfoDto3);


    studentPresenter.showMenu();
    UserInputType userInputType = studentController.getUserInput();
    while (userInputType != UserInputType.EXIT) {
      switch (userInputType) {
        case NEW_STUDENT:
          studentController.registerStudent();
          break;
        case NEW_COURSE:
          courseController.registerCourse();
          break;
        case SHOW_COURSE_DAY_OF_WEEK:
          courseController.showCourseDayOfWeek();
          break;
        case ACTIVATE_STUDENT:
          studentController.activateStudent();
          break;
        case DEACTIVATE_STUDENT:
          studentController.deactivateStudent();
          break;
        case CHANGE_FEE:
          courseController.changeFee();
          break;
        default:
          studentPresenter.showErrorMessage();
          break;
      }
      studentPresenter.showMenu();
      userInputType = studentController.getUserInput();
    }
  }
}