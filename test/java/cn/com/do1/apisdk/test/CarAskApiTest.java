package cn.com.do1.apisdk.test;

import cn.com.do1.apisdk.inter.CarAskApi;
import cn.com.do1.apisdk.inter.SdkAnnotation;
import cn.com.do1.apisdk.inter.rep.vo.ApiCarAskGetCarAskInfoResultVO;
import cn.com.do1.apisdk.inter.req.vo.CarAskListVO;
import cn.com.do1.apisdk.util.JSONUtil;
import cn.com.do1.apisdk.util.QwSdkUtil;

public class CarAskApiTest {
    @SdkAnnotation("get_car_ask_info")
    public static void getCarAskInfo(){
		// SDK get_car_ask_info START
		CarAskListVO carAskListVO = new CarAskListVO();
		// 设置查询的创建时间，格式必须为:yyy-MM-dd，创建时间间隔不的超过两个月
		carAskListVO.setTakeStartTime("2017-07-01");
		carAskListVO.setTakeEndTime("2017-07-31");
		// 设置查询页码，必须是正整数，如果超过最大页数,会默认为最大页数
		carAskListVO.setCurrentPage("1");
		// 分页大小，即每次获取的数据条数， 默认为100,并且不超过1000
		carAskListVO.setPageSize("10");
		CarAskApi carAskApi = QwSdkUtil.getInter(CarAskApi.class);
		ApiCarAskGetCarAskInfoResultVO resultVO = carAskApi.getCarAskInfo(
				QwSdkUtil.getCacheToken(), carAskListVO);
		System.out.println(JSONUtil.stringify(resultVO));// json格式转换，默认把空字符串以及null值的类属性抹去
		// SDK get_car_ask_info END
    }

    public static void main(String[] args) {
          getCarAskInfo();
    }
}
