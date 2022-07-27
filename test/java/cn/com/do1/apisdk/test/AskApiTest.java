package cn.com.do1.apisdk.test;

import cn.com.do1.apisdk.inter.AskApi;
import cn.com.do1.apisdk.inter.SdkAnnotation;
import cn.com.do1.apisdk.inter.ask.vo.AskInfoDataVO;
import cn.com.do1.apisdk.inter.ask.vo.VacationVO;
import cn.com.do1.apisdk.inter.rep.vo.ApiAskGetAskListResultVO;
import cn.com.do1.apisdk.inter.rep.vo.ApiAskGetTypeListResultVO;
import cn.com.do1.apisdk.inter.req.vo.AskListVO;
import cn.com.do1.apisdk.inter.req.vo.VacationJsonVO;
import cn.com.do1.apisdk.util.JSONUtil;
import cn.com.do1.apisdk.util.QwSdkUtil;

public class AskApiTest {
    @SdkAnnotation("get-ask-list")
	public static void getAskList() {
		// SDK get-ask-list START
		AskListVO askListVO = new AskListVO();
		// 设置查询的创建时间，格式必须为:yyy-MM-dd，创建时间间隔不的超过两个月
		askListVO.setStartTimes("2017-01-01");
		askListVO.setEndTime("2017-01-31");
		// 设置查询页码，必须是正整数，如果超过最大页数,会默认为最大页数
		askListVO.setCurrentPage("1");
		// 分页大小，即每次获取的数据条数， 默认为100,并且不超过1000
		askListVO.setPageSize("10");
		AskApi askApi = QwSdkUtil.getInter(AskApi.class);
		ApiAskGetAskListResultVO resultVO = askApi.getAskList(
				QwSdkUtil.getCacheToken(), askListVO);
		System.out.println(JSONUtil.stringify(resultVO));
		// SDK get-ask-list END
	}

    @SdkAnnotation("get-ask-type-list")
    public static void getAskTypeList(){
    	// SDK get-ask-type-list START
        AskApi askApi = QwSdkUtil.getInter(AskApi.class);
        ApiAskGetTypeListResultVO resultVO = askApi.getAskTypeList(QwSdkUtil.getCacheToken());
        System.out.println(JSONUtil.stringify(resultVO));
        // SDK get-ask-type-list END
    }

    @SdkAnnotation("insert-vacation")
    public static void batchInsertVacation(){
    	// SDK insert-vacation START
        VacationJsonVO vacationJsonVO = new VacationJsonVO();
        VacationVO vacationVO = new VacationVO();
        //设置用户账号
        vacationVO.setAccountIds("account1|account2|account3");
        //设置类型id
        vacationVO.setAskTemplateId("tempId");
        //设置总时长，以天为单位
        vacationVO.setSumDays("10");
        //设置剩余时长，以天为单位
        vacationVO.setRemainingDays("10");
        //设置备注
        vacationVO.setRemarks("备注");
        //设置假期开始时间
        vacationVO.setValidStartTime("2018-1-1");
        //设置假期结束时间
        vacationVO.setValidEndTime("2018-12-31");
        //设置是否更新现有数据 0 否 1 是
        vacationJsonVO.setIsUpdate("1");
        vacationJsonVO.setData(new VacationVO[]{vacationVO});
        AskApi askApi = QwSdkUtil.getInter(AskApi.class);
        askApi.batchInsertVacation(QwSdkUtil.getCacheToken(),vacationJsonVO);
        // SDK insert-vacation END
    }

    @SdkAnnotation("get-ask-list")
    public static void getAskDetail() {
        // SDK get-ask-detail START
        //输入请假单id
        String askId = "bc2a6baa-aae8-4abc-a7f6-77f10117f01f";
        AskApi askApi = QwSdkUtil.getInter(AskApi.class);
        AskInfoDataVO resultVO = askApi.getAskDetail(QwSdkUtil.getCacheToken(), askId);
        System.out.println(JSONUtil.stringify(resultVO));
        // SDK get-ask-detail END
    }
    public static void main(String[] args) {
		 getAskList();
//		 getAskDetail();
		// getAskTypeList();
		// batchInsertVacation();
    }
}
