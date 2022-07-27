package cn.com.do1.apisdk.test;

import cn.com.do1.apisdk.inter.ReimApi;
import cn.com.do1.apisdk.inter.reim.req.vo.ApiReimAddCenterCostVo;
import cn.com.do1.apisdk.inter.reim.req.vo.ApiReimGetBudgetVo;
import cn.com.do1.apisdk.inter.reim.req.vo.ApiReimGetReimListVO;
import cn.com.do1.apisdk.inter.reim.resp.vo.ApiInvoicePagerResult;
import cn.com.do1.apisdk.inter.reim.resp.vo.ApiLoanPagerResult;
import cn.com.do1.apisdk.inter.reim.resp.vo.ApiReimGetBudgetResult;
import cn.com.do1.apisdk.inter.reim.resp.vo.ApiReimGetCenterCostResult;
import cn.com.do1.apisdk.inter.reim.resp.vo.ApiReimGetReimListResult;
import cn.com.do1.apisdk.inter.reim.resp.vo.GetBudgetDetailResultVO;
import cn.com.do1.apisdk.util.JSONUtil;
import cn.com.do1.apisdk.util.QwSdkUtil;
import cn.com.do1.apisdk.util.SdkConfig;

import java.util.ArrayList;
import java.util.List;

public class ReimApiTest {

	/**
	 * 获取报销列表接口测试
	 */
	public static void getReimList() {
		// SDK get_reim_list START
		ApiReimGetReimListVO vo = new ApiReimGetReimListVO();
		vo.setStartTime("2022-01-10");
		vo.setEndTime("2022-01-12");
		System.out.println(JSONUtil.stringify(vo));
		ReimApi api = QwSdkUtil.getInter(ReimApi.class);
		// 调用接口
		ApiReimGetReimListResult re = api.getReimList(
				QwSdkUtil.getCacheToken(), SdkConfig.getString("corpId"), vo);
		// 表单id
		System.out.println(JSONUtil.stringify(re));
		// SDK get_reim_list END
	}

	/**
	 * 获取成本中心接口测试
	 */
	public static void getCenterCostList() {
		// SDK get_centercost_list START
		ReimApi api = QwSdkUtil.getInter(ReimApi.class);
		// 调用接口
		ApiReimGetCenterCostResult s = api.getCenterCostList(
				QwSdkUtil.getCacheToken(), SdkConfig.getString("corpId"));
		// 表单id
		System.out.println(JSONUtil.stringify(s));
		// SDK get_centercost_list END
	}

	/**
	 * 导入成本中心接口测试
	 */
	public static void addCenterCost() {
		// SDK add_centercost START
		ApiReimAddCenterCostVo vo = new ApiReimAddCenterCostVo();
		vo.setId("9016edf386a94b7d912003c5d99095f7");
		vo.setName("二级成本中心");
		vo.setParentId("b8ba7af350f040aab68378a0d981dce6");
		vo.setPrincipalIds("lijipeng");
		vo.setStatus("0");
		List<ApiReimAddCenterCostVo> children = new ArrayList<ApiReimAddCenterCostVo>();
		ApiReimAddCenterCostVo vo1 = new ApiReimAddCenterCostVo();
		vo1.setId("c945a53a77e543b5a6de8da75dc3bae8");
		vo1.setName("三级成本中心");
		vo1.setPrincipalIds("lijipeng");
		vo1.setStatus("1");
		children.add(vo1);
		vo.setChildren(children);
		ReimApi api = QwSdkUtil.getInter(ReimApi.class);
		// 调用接口
		api.addCenterCost(QwSdkUtil.getCacheToken(),
				SdkConfig.getString("corpId"), vo);
		// SDK add_centercost END
	}

	/**
	 * 获取费用预算接口测试
	 */
	public static void getBudgetList() {
		// SDK get_budget_list START
		ApiReimGetBudgetVo vo = new ApiReimGetBudgetVo();
		vo.setYear("2018");
		ReimApi api = QwSdkUtil.getInter(ReimApi.class);
		// 调用接口
		ApiReimGetBudgetResult re = api.getBudgetList(
				QwSdkUtil.getCacheToken(), SdkConfig.getString("corpId"), vo);
		System.out.println(JSONUtil.stringify(re));
		// SDK get_budget_list END
	}

	/**
	 * 获取预算
	 */
	public static void getBudgetDetail() {
		// SDK get_budget_detail START
		ReimApi api = QwSdkUtil.getInter(ReimApi.class);
		GetBudgetDetailResultVO res = api.getBudgetDetail(
				QwSdkUtil.getCacheToken(), SdkConfig.getString("corpId"), 2019, "dfc6ad2dae54434793a1669966b6e175");
		System.out.println(JSONUtil.stringify(res));
		// SDK get_budget_detail END
	}

	public static void loanList() {
		// SDK loan_list START
		ReimApi api = QwSdkUtil.getInter(ReimApi.class);
		ApiLoanPagerResult result = api.loanList(QwSdkUtil.getCacheToken(), SdkConfig.getString("corpId"), "2021-01-01", "2021-01-31", 1, 10);
		System.out.println(JSONUtil.stringify(result));
		// SDK loan_list END
	}

	public static void invoiceList() {
		// SDK invoice_list START
		ReimApi api = QwSdkUtil.getInter(ReimApi.class);
		ApiInvoicePagerResult result = api.invoiceList(QwSdkUtil.getCacheToken(), SdkConfig.getString("corpId"), "2021-01-01", "2021-01-31", 1, 10);
		System.out.println(JSONUtil.stringify(result));
		// SDK invoice_list END
	}

	public static void main(String args[]) throws Exception {
		getReimList();
		// getCenterCostList();
		// addCenterCost();
		// getBudgetList();
		// 获取预算
		//getBudgetDetail();
		//loanList();
		//invoiceList();
	}
}
