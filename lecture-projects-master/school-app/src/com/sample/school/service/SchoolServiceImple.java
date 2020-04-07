package com.sample.school.service;

import com.sample.school.repository.CourseRepository;
import com.sample.school.repository.ProfessorRepository;
import com.sample.school.repository.RegistrationRepository;
import com.sample.school.repository.StudentRepository;
import com.sample.school.repository.SubjectRepository;
import com.sample.school.vo.Course;
import com.sample.school.vo.Professor;
import com.sample.school.vo.Registration;
import com.sample.school.vo.Student;
import com.sample.school.vo.Subject;

public class SchoolServiceImple implements SchoolService {

	private CourseRepository courseRepo = new CourseRepository();
	private ProfessorRepository professorRepo = new ProfessorRepository();
	private RegistrationRepository registrationRepo = new RegistrationRepository();
	private SubjectRepository subjectRepo = new SubjectRepository();
	private StudentRepository studentRepo = new StudentRepository();
	
	@Override
	public void addNewProfessor(Professor professor) {
		professorRepo.insertProfessor(professor);
	}
	
	@Override
	public void addNewSubject(Subject subject) {
		subjectRepo.insertSubject(subject);
	}

	@Override
	public void selectProfessorSubject(int professorNo) {
		Professor findProfessor = professorRepo.getProfessorByNo(professorNo);
		if(findProfessor == null) {
			System.out.println("해당 교수 번호와 일치하는 정보가 없습니다.");
			return;
		}
		
		Subject[] subjects = subjectRepo.getPfSubject(findProfessor);
		System.out.println("===== 과목 조회 =====");
		
		for(int i=0; i<subjects.length; i++) {
			if(subjects[i] == null) {
				break;
			}
			
			System.out.println((i+1) + "." +subjects[i].getTitle());
		}
	}

	@Override
	public void addNewCourse(Course course) {
		Professor findProfessor = professorRepo.getProfessorByNo(course.getProfessorNo());
		Subject findSubject = subjectRepo.getSubjectByNo(course.getSubjectNo());
		
		if(findProfessor == null || findSubject == null) {
			System.out.println("일치하는 정보가 없습니다.");
			return;
		}

		if(!findProfessor.getDept().equals(findSubject.getDept())) {
			System.out.println("해당 학과 개설 과목이 아닙니다.");
			return;
		}
		
		courseRepo.insertCourse(course);
		System.out.println("과정이 개설되었습니다.");
		
//		Subject[] subjects = subjectRepo.getPfSubject(findProfessor);
//		
//		boolean isSubject = false;
//		for(int i=0; i<subjects.length; i++) {
//			if(subjects[i] == null) {
//				break;
//			}
//			
//			if(subjects[i].getNo() == course.getSubjectNo()) {
//				isSubject = true;
//			}
//		}
//		
//		if(!isSubject) {
//			System.out.println("해당 학과 개설 과목이 아닙니다.");
//			return;
//		}
//		
//		courseRepo.insertCourse(course);
//		System.out.println("과정이 개설되었습니다.");
	}

	@Override
	public void selectProfessorCourse(int professorNo) {
		Course[] findCourses = courseRepo.getAllCourseByProfessorNo(professorNo);
		
		System.out.println("===== 개설 과정 조회 =====");
		for(int i=0; i<findCourses.length; i++) {
			if(findCourses[i] == null) {
				break;
			}
			Subject findSubject = subjectRepo.getSubjectByNo(findCourses[i].getSubjectNo());
			
			System.out.println("개설과정번호 : " + findCourses[i].getNo());
			System.out.println("과정명 : " + findCourses[i].getName());
			System.out.println("과목명 : " + findSubject.getTitle());
		}
	}

	@Override
	public void selectApplicant(int professorNo, int courseNo) {
		Professor findProfessor = professorRepo.getProfessorByNo(professorNo);	
		Course findCourse = courseRepo.getCourseByNo(courseNo);
		Registration[] registrations = registrationRepo.getAllRegistrationis();
		
		int studentNo = 0;
		
		System.out.println("----- 개설과정 신청자 조회 -----");
		System.out.println("학생이름\t학과\t학년");
		System.out.println("--------------------------");
		
		for(int i=0; i<registrations.length; i++) {
			if(registrations[i].getCourseNo() == courseNo && findCourse.getProfessorNo() == professorNo) {
				studentNo = registrations[i].getStudentNo();
				
				Student findStudent = studentRepo.getStudentByNo(studentNo);
				
				System.out.print(findStudent.getName() + "\t");
				System.out.print(findStudent.getDept() + "\t");
				System.out.println(findStudent.getGrade() + "\t");
			}
		}

		
	}

	@Override
	public void scoreSet(int professorNo, int registrationNo, int score) {
		Registration findRegistration = registrationRepo.getRegistrationByNo(registrationNo);
		Course findCourse = courseRepo.getCourseByNo(findRegistration.getCourseNo());
		if(professorNo == findCourse.getProfessorNo()) {
			findRegistration.setScore(score);
		} else {
			System.out.println("정보가 일치하지 않습니다.");
		}
	}

	
	
	@Override
	public void addNewStudent(Student student) {
		studentRepo.insertStudent(student);
	}

	@Override
	public void selectStudentSubject(int studentNo) {
		Student findStudent = studentRepo.getStudentByNo(studentNo);
		Subject[] subjects = subjectRepo.getAllSubject();
		
		if(findStudent == null) {
			System.out.println("일치하는 정보가 없습니다.");
			return;
		}
		
		System.out.println("===== 과목 조회 결과 =====");
		for(int i=0; i<subjects.length; i++) {
			if(findStudent.getDept().equals(subjects[i].getDept())) {
				System.out.println("* " + subjects[i].getTitle());
			}
		}
	}

	@Override
	public void selectStudentCourse(int studentNo) {
		Student findStudent = studentRepo.getStudentByNo(studentNo);
		Course[] courses = courseRepo.getAllCourse();
		
		if(findStudent == null) {
			System.out.println("일치하는 정보가 없습니다.");
			return;
		}
		
		System.out.println("===== 개설 과정 조회 결과 =====");
		for(int i=0; i<courses.length; i++) {
			Subject findSubject = subjectRepo.getSubjectByNo(courses[i].getSubjectNo());
			
			if(findStudent.getDept().equals(findSubject.getDept())) {
				System.out.println("* " + courses[i].getName());
			}
		}
	}

	@Override
	public void addRegistration(int studentNo, int courseNo) {
		Student findStudent = studentRepo.getStudentByNo(studentNo);
		Course findCourse = courseRepo.getCourseByNo(courseNo);
		
		if(findStudent == null || findCourse == null) {
			System.out.println("일치하는 정보가 없습니다.");
			return;
		}
		
		Subject findSubject = subjectRepo.getSubjectByNo(findCourse.getSubjectNo());
		
		if(findStudent.getDept().equals(findSubject.getDept())) {
			Registration registration = new Registration();
			
			registration.setStudentNo(studentNo);
			registration.setCourseNo(courseNo);
			registrationRepo.insertRegistration(registration);
		}
	}

	@Override
	public void selectRegistration(int studentNo) {
		Registration[] registrations = registrationRepo.getAllRegistrationis();
		
		System.out.println("===== 수강 신청 현황 조회 결과 =====");
		System.out.println("수강신청번호\t개설과정명\t\t취소여부");
		
		for(int i=0; i<registrations.length; i++) {
			if(studentNo == registrations[i].getStudentNo()) {
				Course findCourse = courseRepo.getCourseByNo(registrations[i].getCourseNo());
				
				System.out.print(registrations[i].getNo() + "\t\t");
				System.out.print(findCourse.getName() + "\t");
				System.out.println(registrations[i].isCancel());
			}
		}
	}

	@Override
	public void cancelRegistration(int studentNo, int registrationNo) {
		Registration findRegistration = registrationRepo.getRegistrationByNo(registrationNo);
		
		if(studentNo == findRegistration.getStudentNo()) {
			findRegistration.setCancel(true);
			System.out.println("수강신청이 취소되었습니다.");
		}
	}

	@Override
	public void scorePrint(int studentNo) {
		Registration[] registrations = registrationRepo.getAllRegistrationis();
		
		System.out.println("----- 성적 조회 -----");
		System.out.println("수강신청번호\t개설과정명\t\t성적");
		System.out.println("----------------------------------------");
		for(int i=0; i<registrations.length; i++) {
			if(registrations[i].getStudentNo() == studentNo) {
				Course findCourse = courseRepo.getCourseByNo(registrations[i].getCourseNo());
				
				System.out.print(registrations[i].getNo() + "\t\t");
				System.out.print(findCourse.getName() + "\t");
				System.out.println(registrations[i].getScore() + "\t");
			}
		}
	}
	
	
	
}
