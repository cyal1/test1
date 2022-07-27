package cn.com.do1.apisdk.test;

import cn.com.do1.apisdk.inter.OutworkApi;
import cn.com.do1.apisdk.inter.SdkAnnotation;
import cn.com.do1.apisdk.inter.rep.vo.OutworkSignResult;
import cn.com.do1.apisdk.inter.req.vo.OutworkSignVO;
import cn.com.do1.apisdk.util.JSONUtil;
import cn.com.do1.apisdk.util.QwSdkUtil;

/**
 * @author zhouxinxiong
 * @date 2018-06-14
 **/
public class OutworkApiTest {

	@SdkAnnotation("get-outwork-sign-info")
	public static void getSignInfo() {
		// SDK get-outwork-sign-info START
		OutworkSignVO vo = new OutworkSignVO();
		// 创建时间开始点
		vo.setStartTimes("2018-03-01");
		// 创建时间结束点
		vo.setEndTime("2018-03-31");
		// 查询页码
		vo.setCurrentPage(1);
		// 分页大小
		vo.setPageSize(100);
		// 打印传入参数
		System.out.println(JSONUtil.stringify(vo));

		OutworkApi api = QwSdkUtil.getInter(OutworkApi.class);
		// 调用接口
		OutworkSignResult result = api.getSignInfo(QwSdkUtil.getCacheToken(),
				vo);
		// 打印输出结果
		System.out.println(JSONUtil.stringify(result));
		// SDK get-outwork-sign-info END
	}

	public static void main(String[] args) {
		getSignInfo();
	}
}
