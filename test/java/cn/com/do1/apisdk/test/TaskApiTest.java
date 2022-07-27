package cn.com.do1.apisdk.test;

import cn.com.do1.apisdk.inter.SdkAnnotation;
import cn.com.do1.apisdk.inter.TaskApi;
import cn.com.do1.apisdk.inter.task.vo.*;
import cn.com.do1.apisdk.util.JSONUtil;
import cn.com.do1.apisdk.util.QwSdkUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskApiTest {
	@SdkAnnotation("get-task-info")
	public static void getTaskInfo() {
		// SDK get-task-info START
		TaskListVO taskListVO = new TaskListVO();
		// 设置查询的创建时间，格式必须为:yyyy-MM-dd，创建时间间隔不的超过两个月
		taskListVO.setStartTimes("2019-01-01");
		taskListVO.setEndTime("2019-01-31");
		// 设置查询页码，必须是正整数，如果超过最大页数,会默认为最大页数
		taskListVO.setCurrentPage("1");
		// 分页大小，即每次获取的数据条数， 默认为100,并且不超过1000
		taskListVO.setPageSize("10");
		TaskApi taskApi = QwSdkUtil.getInter(TaskApi.class);
		ApiTaskGetTaskInfoResultVO resultVO = taskApi.getTaskInfo(
				QwSdkUtil.getCacheToken(), taskListVO);
		System.out.println(JSONUtil.stringify(resultVO));
		// SDK get-task-info END
	}

	@SdkAnnotation("get-task-type-info")
	public static void getTaskTypeInfo() {
		// SDK get-task-type-info START
		TaskApi taskApi = QwSdkUtil.getInter(TaskApi.class);
		// 调用接口
		TaskTypeListVO resultList = taskApi.getTaskTypeInfo(QwSdkUtil.getCacheToken());
		// 打印输出结果
		System.out.println(JSONUtil.stringify(resultList));
		// SDK get-task-type-info END
	}


	@SdkAnnotation("ajax-add-task")
	public static void ajaxAddTask() {
		// SDK ajax-add-task START
		TaskAddJsonReqVO taskVO = new TaskAddJsonReqVO();
		//主任务id
		taskVO.setTaskId(UUID.randomUUID().toString().replace("-", ""));
		//设置任务标题
		taskVO.setTitle("这是任务标题");
		//设置任务类型
		taskVO.setTaskType("db54be9a-d618-48f4-a008-84ebe20c6b7c");
		//设置任务内容
		taskVO.setContent("这是任务内容");
		//设置任务创建人
		taskVO.setCreatorWxUserId("qw123456");
		//设置任务负责人
		taskVO.setInchargeWxUserIdStr("qw123456,lin");
		//设置任务相关人
		taskVO.setRelevantWxUserIdStr("lin");
		//设置任务反馈方式
		taskVO.setIsUseRate("0");
		//设置任务时长
		taskVO.setTaskHours("");
		//设置任务开始时间
		taskVO.setTaskStart("2019-03-06 17:15:00");
		//设置任务结束时间
		taskVO.setTaskStop("2019-03-07 17:15:00");
		//设置任务优先级
		taskVO.setPriority("0");
		//设置任务地点
		taskVO.setAccessAddress("广州天河");
		//设置任务【任务开始前30分钟提醒负责人】开关
		taskVO.setSendStartRemindMsg("0");
		//设置任务【任务截止前30分钟提醒负责人】开关
		taskVO.setDeadlineRemindMsg("0");
		//设置任务【有新评论时提醒负责人】开关
		taskVO.setCommentSendMsg("1");
		//设置任务【更新进度时通知提醒】开关
		taskVO.setRateSendMsg("1");

		//设置任务重复提醒
		RemindTaskReqVO remindTaskVO = new RemindTaskReqVO();
		//设置任务提醒时间
		remindTaskVO.setRemindTime("2019-03-06 12:00:00");
		//设置任务提醒类型
		remindTaskVO.setRemindCycle(1);
		//设置任务自定义提醒
		remindTaskVO.setRegExp("");
		taskVO.setRemindTaskVO(remindTaskVO);

		//设置子任务
		List<SubtaskAddJsonReqVO> subtaskList = new ArrayList<SubtaskAddJsonReqVO>();
		SubtaskAddJsonReqVO subtaskVO = new SubtaskAddJsonReqVO();
		//主任务id
		subtaskVO.setMainTaskId(taskVO.getTaskId());
		//子任务id
		subtaskVO.setSubtaskId(UUID.randomUUID().toString().replace("-", ""));
		//子任务编号
		subtaskVO.setNumber("这是子任务编号");
		//子任务标题
		subtaskVO.setTitle("这是子任务标题");
		//子任务内容
		subtaskVO.setContent("这是子任务内容");
		//子任务创建人账号
		subtaskVO.setCreatorWxUserId("qw123456");
		//子任务负责人账号
		subtaskVO.setInchargesWxUserId("qw123456");
		//子任务执行人账号
		subtaskVO.setExecutorsWxUserId("do123456,lin");
		//子任务优先级
		subtaskVO.setPriority("0");
		//子任务预计时长
		subtaskVO.setWorkHour("");
		//子任务开始时间
		subtaskVO.setStartTime("2019-03-06 17:15:00");
		//子任务结束时间
		subtaskVO.setStopTime("2019-03-07 17:15:00");
		subtaskList.add(subtaskVO);

		JSONArray subtaskListJsonArray = JSONArray.fromObject(subtaskList);
		JSONObject subtaskJsonObject = new JSONObject();
		subtaskJsonObject.put("subtask", subtaskListJsonArray);

		TaskApi taskApi = QwSdkUtil.getInter(TaskApi.class);
		// 调用接口
		TaskAddResultVO resultVO = taskApi.ajaxAddTask(QwSdkUtil.getCacheToken(), taskVO, subtaskJsonObject.toString());
		//任务id
		System.out.println(resultVO.getTaskId());
		//任务类型
		System.out.println(resultVO.getTaskType());
		//任务标题
		System.out.println(resultVO.getTitle());
		//创建人账号
		System.out.println(resultVO.getCreatorWxUserId());
		// SDK ajax-add-task END
	}

	public static void main(String[] args) {
		 //getTaskInfo();
		//getTaskTypeInfo();
		//ajaxAddTask();
	}
}
