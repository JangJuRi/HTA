package collection.recruit.service;

import java.util.ArrayList;

import collection.recruit.repo.RecruitmentRepository;
import collection.recruit.vo.Career;
import collection.recruit.vo.Recruitment;
import collection.recruit.vo.Resume;

public class RecruitmentService {

	private RecruitmentRepository repo = new RecruitmentRepository();
	
	// 이력서 등록기능
	public void addNewResume(Resume resume) {
		// 구직신청객체 생성
		// 구직신청객체에 전달받은 이력서 객체 저장
		// 레포지토리객체를 사용해서 db에 저장하고, 자신의 구직신청번호를 반환받는다.
		// 구직신청번호를 출력한다.
		Recruitment recruitment = new Recruitment();
		recruitment.setResume(resume);
		int no = repo.addRecuitment(recruitment);
		System.out.println("채용신청번호 : " + no);
	}
	
	// 경력사항 등록기능
	public void addCareer(int recruitmentNo, Career career) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 조회한다.
		// 구직신청객체의 경력사항에 전달받은 경력사항객체를 추가한다.
		Recruitment findRecruitment = repo.getRecruitmentByNo(recruitmentNo);
		
		if (findRecruitment == null) {
			System.out.println("### 정보가 없습니다 ###");
			return;
		}
		
		findRecruitment.addCareer(career);
	}
	
	// 구직신청 상태 조회 기능
	public void printRecruitmentDetail(int recruitmentNo) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 조회해서 화면에 출력한다.
		Recruitment findRecruitment = repo.getRecruitmentByNo(recruitmentNo);
		
		if (findRecruitment == null) {
			System.out.println("### 정보가 없습니다 ###");
			return;
		}
		
		System.out.println("=== "+ findRecruitment.getResume().getName() +"님의 구직신청정보 ===");
		System.out.println("번      호 : " + findRecruitment.getNo());
		System.out.println("이      름 : " + findRecruitment.getResume().getName());
		System.out.println("전화번호 : " + findRecruitment.getResume().getTel());
		System.out.println("지원부서 : " + findRecruitment.getResume().getDept());
		System.out.println("합격여부 : " + findRecruitment.isPassed());
		System.out.println("----- 경력 사항 -----");
		System.out.println("회사명\t부서명\t최종직급\t근무기간");
		for(Career c : findRecruitment.getCareers()) {
			System.out.print(c.getCompanyName() + "\t");
			System.out.print(c.getDept() + "\t");
			System.out.print(c.getPosition() + "\t");
			System.out.println(c.getYear());
		}
		
		System.out.println("============================");
	}
	
	// 이력서 수정 기능
	public void updateResume(int recruitmentNo, Resume resume) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 조회한다.
		// 구직신청객체의 이력서정보를 전달받은 이력서 정보로 교체한다.
		Recruitment findRecruitment = repo.getRecruitmentByNo(recruitmentNo);
		
		if (findRecruitment == null) {
			System.out.println("### 정보가 없습니다 ###");
			return;
		}
		
		findRecruitment.setResume(resume);
	}
	
	// 구직신청 삭제하기
	public void deleteRecruitment(int recruitmentNo) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 삭제한다.
		repo.deleteRecruitmentByNo(recruitmentNo);
	}
	
	// 전체 구직신청정보 간단 조회
	public void printAllRecruitment() {
		// 레포지토리에서 모든 구직신청 정보를 조회해서 화면에 출력한다.
		ArrayList<Recruitment> allRecruitments = repo.getAllRecruitments();
		
		System.out.println("=====================================");
		System.out.println("번호\t이름\t지원부서\t합격여부");
		System.out.println("=====================================");
		for(Recruitment r : allRecruitments) {
			System.out.print(r.getNo() + "\t");
			System.out.print(r.getResume().getName() + "\t");
			System.out.print(r.getResume().getDept() + "\t");
			System.out.println(r.isPassed());
		}
	}
	
	// 구직신청정보 상세조회
	/*
	public void printDetailRecruitment(int recruitmentNo) {
		Recruitment findRecruitment = repo.getRecruitmentByNo(recruitmentNo);
		
		if (findRecruitment == null) {
			System.out.println("### 정보가 없습니다 ###");
			return;
		}
		
		System.out.println("=== "+ findRecruitment.getResume().getName() +"님의 구직신청정보 ===");
		System.out.println("번      호 : " + findRecruitment.getNo());
		System.out.println("이      름 : " + findRecruitment.getResume().getName());
		System.out.println("전화번호 : " + findRecruitment.getResume().getTel());
		System.out.println("지원부서 : " + findRecruitment.getResume().getDept());
		System.out.println("합격여부 : " + findRecruitment.isPassed());
		System.out.println("----- 경력 사항 -----");
		System.out.println("회사명\t부서명\t최종직급\t근무기간");
		for(Career c : findRecruitment.getCareers()) {
			System.out.print(c.getCompanyName() + "\t");
			System.out.print(c.getDept() + "\t");
			System.out.print(c.getPosition() + "\t");
			System.out.println(c.getYear());
		}
		
		System.out.println("============================");
	}
	*/
	
	// 구직신청 심사하기
	public void checkRecruitment(int recruitmentNo, boolean passed) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 조회한다.
		// 합격/불합격여부를 결정한다.
		Recruitment findRecruitment = repo.getRecruitmentByNo(recruitmentNo);
		
		if (findRecruitment == null) {
			System.out.println("### 정보가 없습니다 ###");
			return;
		}
		
		findRecruitment.setPassed(passed);
	}
}