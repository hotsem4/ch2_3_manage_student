package org.fastcampus.student_management.application.student;

import java.util.Optional;
import org.fastcampus.student_management.application.student.dto.StudentInfoDto;
import org.fastcampus.student_management.domain.Student;
import org.fastcampus.student_management.repo.StudentRepository;

public class StudentService {

	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public void saveStudent(StudentInfoDto studentInfoDto) {
		Student student = new Student(studentInfoDto.getName(), studentInfoDto.getAge(), studentInfoDto.getAddress());
		studentRepository.save(student);
	}

	public Student getStudent(String name) {
		return studentRepository.findByName(name)
			.orElseThrow(() -> new IllegalArgumentException("해당하는 학생이 없습니다."));
	}
//  1차 코드
//	public void activateStudent(String name) {
//		Optional<Student> byName = studentRepository.findByName(name);
//		if (byName.isPresent()) {
//			Student student = byName.get();
//			if (student.isActivate()){
//				System.out.println("이미 활성화된 학생입니다.");
//			}else {
//				student.activate();
//				System.out.println("학생이 활성화되었습니다.");
//				studentRepository.save(student);
//			}
//		} else{
//			throw new IllegalArgumentException("해당하는 학생이 없습니다.");
//		}
//	}
	public void activateStudent(String name) {
		Student student = getStudent(name);
		student.activate();
		System.out.println("학생이 활성화 되었습니다.");
		studentRepository.save(student);
	}

//	public void deactivateStudent(String name) {
//		Optional<Student> byName = studentRepository.findByName(name);
//		if (byName.isPresent()) {
//			Student student = byName.get();
//			if (student.isActivate()){
//				student.deactivate();
//				studentRepository.save(student);
//			} else {
//				System.out.println("이미 비활성화된 학생입니다.");
//			}
//        }else {
//			throw new IllegalArgumentException("해당 학생은 존재하지 않습니다.");
//		}
//	}
	public void deactivateStudent(String name) {
		Student student = getStudent(name);
		student.deactivate();
		System.out.println("학생이 비활성화 되었습니다.");
		studentRepository.save(student);
	}
}
