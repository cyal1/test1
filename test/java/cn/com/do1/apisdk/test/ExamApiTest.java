package cn.com.do1.apisdk.test;

import cn.com.do1.apisdk.inter.ExamApi;
import cn.com.do1.apisdk.inter.exam.vo.SearchExamResult;
import cn.com.do1.apisdk.inter.rep.vo.*;
import cn.com.do1.apisdk.util.JSONUtil;
import cn.com.do1.apisdk.util.QwSdkUtil;


public class ExamApiTest {
	private static void searchExamResult() {
		// SDK get-exam-result START
		String userId = "xueba"; // 学员账号
		String examId = ""; // 可以通过云平台查看考试的url获得
		String startDate = "2018-05-21"; // 考试开始日期 （格式：yyyy-MM-dd）
		String endDate = "2018-09-22"; // 考试结束日期 （格式：yyyy-MM-dd）
		ExamApi examApi = QwSdkUtil.getInter(ExamApi.class);
		SearchExamResult result = examApi.searchExamResult(
				QwSdkUtil.getCacheToken(), userId, examId, startDate, endDate);
		System.out.println(JSONUtil.stringify(result));
		// SDK get-exam-result END
	}

	private static void seachExamCount() {
		// SDK get-exam-count START
		Integer page = 1; // 页码
		Integer pageSize = 1; // 页长
		ExamApi examApi = QwSdkUtil.getInter(ExamApi.class);
		ApiExamStatisticResultVO result = examApi.seachExamCount(
				QwSdkUtil.getCacheToken(), page, pageSize);
		System.out.println(JSONUtil.stringify(result));
		// SDK get-exam-count END
	}

	private static void examView() {
		// SDK exam_view START
		Integer page = 1; // 页码
		Integer pageSize = 1; // 页长
		Integer answerStauts = 1;
		String examId = "2327e3a1f2c644f38201c0b29a963f66";
		ExamApi examApi = QwSdkUtil.getInter(ExamApi.class);
		ApiExamViewVO result = examApi.examView(
				QwSdkUtil.getCacheToken(), page, pageSize, examId, answerStauts);
		System.out.println(JSONUtil.stringify(result));
		// SDK exam_view END
	}

	private static void studyCount() {
		// SDK study-count START
		Integer page = 1; // 页码
		Integer pageSize = 1; // 页长
		ExamApi examApi = QwSdkUtil.getInter(ExamApi.class);
		ApiStudyCountVO result = examApi.studyCount(
				QwSdkUtil.getCacheToken(), page, pageSize);
		System.out.println(JSONUtil.stringify(result));
		// SDK study-count END
	}

	private static void personalDetail() {
		// SDK personal-detail START
		Integer page = 1; // 页码
		Integer pageSize = 1; // 页长
		String userId = "xueba";
		ExamApi examApi = QwSdkUtil.getInter(ExamApi.class);
		ApiPersonalDetailVO result = examApi.personalDetail(
				QwSdkUtil.getCacheToken(), page, pageSize, userId);
		System.out.println(JSONUtil.stringify(result));
		// SDK personal-detail END
	}

	private static void courseCount() {
		// SDK course-count START
		Integer page = 1; // 页码
		Integer pageSize = 1; // 页长
		ExamApi examApi = QwSdkUtil.getInter(ExamApi.class);
		ApiCourseCountVO result = examApi.courseCount(
				QwSdkUtil.getCacheToken(), page, pageSize);
		System.out.println(JSONUtil.stringify(result));
		// SDK course-count END
	}

	private static void courseCountDetail() {
		// SDK course-count-detail START
		Integer page = 1; // 页码
		Integer pageSize = 1; // 页长
		String courseId = "bd38a82735f449329333dd8f873e2d06";
		ExamApi examApi = QwSdkUtil.getInter(ExamApi.class);
		ApiCourseCountDetailVO result = examApi.courseCountDetail(
				QwSdkUtil.getCacheToken(), page, pageSize, courseId);
		System.out.println(JSONUtil.stringify(result));
		// SDK course-count-detail END
	}

	private static void creditDetail() {
		// SDK credit-detail START
		Integer page = 1; // 页码
		Integer pageSize = 1; // 页长
		String userId = "xueba";
		ExamApi examApi = QwSdkUtil.getInter(ExamApi.class);
		ApiCreditDetailVO result = examApi.creditDetail(
				QwSdkUtil.getCacheToken(), page, pageSize, userId);
		System.out.println(JSONUtil.stringify(result));
		// SDK credit-detail END
	}

	private static void searchTeacher() {
		// SDK search-teacher START
		Integer page = 1; // 页码
		Integer pageSize = 1; // 页长
		ExamApi examApi = QwSdkUtil.getInter(ExamApi.class);
		ApiSearchTeacherVO result = examApi.searchTeacher(
				QwSdkUtil.getCacheToken(), page, pageSize);
		System.out.println(JSONUtil.stringify(result));
		// SDK search-teacher END
	}

	private static void searchQuestion() {
		// SDK search-teacher START
		Integer page = 1; // 页码
		Integer pageSize = 1; // 页长
		String poolId = "d88458af80c34b39a55164d7b7806f2e";
		ExamApi examApi = QwSdkUtil.getInter(ExamApi.class);
		ApiSearchQuestionVO result = examApi.searchQuestion(
				QwSdkUtil.getCacheToken(), page, pageSize, poolId);
		System.out.println(JSONUtil.stringify(result));
		// SDK search-teacher END
	}

	public static void main(String[] args) {
//		 searchExamResult();
//		seachExamCount();
		examView();
//		studyCount();
//		personalDetail();
//		courseCount();
//		courseCountDetail();
//		creditDetail();
//		searchTeacher();
//		searchQuestion();
	}
}
