package cn.com.do1.apisdk.test;

import cn.com.do1.apisdk.inter.SdkAnnotation;
import cn.com.do1.apisdk.inter.SingleSignOnApi;
import cn.com.do1.apisdk.inter.sso.vo.ResultDataVO;
import cn.com.do1.apisdk.util.JSONUtil;
import cn.com.do1.apisdk.util.QwSdkUtil;

/**
 * 单点登录demo
 * 
 * @author lishengtao
 * @data 20180629
 */
public class SingleSignOnApiTest {

	@SdkAnnotation("sso")
	public static void getLoginInfo() {
		// SDK sso START
		// 单点登录URL参数中返回授权码：这个是测试编码，具体的可以参照后台单点登录的链接编码做测试
		String autoCode = "MTQ2Mzk4ZmQtOWEwMy00MzBlLWJhOTctMmY4OGYyODc2MDYy";
		SingleSignOnApi ssoApi = QwSdkUtil.getInter(SingleSignOnApi.class);
		ResultDataVO resultDataVO = ssoApi.getLoginInfo(
				QwSdkUtil.getCacheToken(), autoCode);
		System.out.println(JSONUtil.stringify(resultDataVO));
		// SDK sso END
	}

	public static void main(String[] args) {
		getLoginInfo();
	}
}
