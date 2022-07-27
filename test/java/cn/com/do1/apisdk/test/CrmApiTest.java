package cn.com.do1.apisdk.test;

import cn.com.do1.apisdk.inter.CrmApi;
import cn.com.do1.apisdk.inter.crm.vo.CrmBusinessInfoPageResult;
import cn.com.do1.apisdk.inter.crm.vo.CrmClientInfoPageResult;
import cn.com.do1.apisdk.inter.crm.vo.CrmContactsInfoPageResult;
import cn.com.do1.apisdk.inter.crm.vo.CrmContractInfoPageResult;
import cn.com.do1.apisdk.inter.crm.vo.CrmSeniorFieldVO;
import cn.com.do1.apisdk.inter.crm.vo.CrmWorkInfoPageResult;
import cn.com.do1.apisdk.inter.rep.vo.ApiCrmContactsDetailsResultVO;
import cn.com.do1.apisdk.inter.rep.vo.ApiCrmContactsFieldsResultVO;
import cn.com.do1.apisdk.inter.rep.vo.ApiCrmContactsResultVO;
import cn.com.do1.apisdk.inter.req.vo.CrmContactsDetailReqVO;
import cn.com.do1.apisdk.inter.req.vo.CrmContactsReqVO;
import cn.com.do1.apisdk.inter.req.vo.CrmDataPush;
import cn.com.do1.apisdk.util.JSONUtil;
import cn.com.do1.apisdk.util.QwSdkUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZhouHuiBin
 * @date 2018-06-14 9:06
 */
public class CrmApiTest {

	public static void getClientInfo() {
		// SDK get-client-info START
		// 创建请求的参数
		CrmDataPush vo = new CrmDataPush();
		// 设置当前页面
		vo.setCurrentPage(1);
		// 设置页面大小
		vo.setPageSize(10);
		// 设置将要查询的客户信息的创建时间范围（不超过两个月）
		vo.setStartTimes("2018-01-01");
		vo.setEndTime("2018-03-01");
		// 设置clientName模糊查询
		vo.setSearchValue(vo.new SearchValue("测试","13333445566"));
		System.out.println(JSONUtil.stringify(vo));
		CrmApi api = QwSdkUtil.getInter(CrmApi.class);
		// 调用接口
		CrmClientInfoPageResult clientVO = api.getClientInfo(
				QwSdkUtil.getCacheToken(), vo);
		System.out.println(JSONUtil.stringify(clientVO));
		// SDK get-client-info END
	}

	public static void getClientPoolClientInfo() {
		// SDK get-client-pool-client-info START
		// 创建请求的参数
		CrmDataPush vo = new CrmDataPush();
		// 设置当前页面
		vo.setCurrentPage(1);
		// 设置页面大小
		vo.setPageSize(10);
		// 设置将要查询的客户信息的创建时间范围（不超过两个月）
		vo.setStartTimes("2018-01-01");
		vo.setEndTime("2018-03-01");
		// 设置将要查询的客户信息的更新时间范围
		vo.setStartUpdateTime("2019-07-15");
		vo.setEndUpdateTime("2019-08-15");
		// 设置将要查询的客户状态
		vo.setClientStatus("1");
		// 设置clientName模糊查询
		vo.setSearchValue(vo.new SearchValue("测试","13333445566"));
		System.out.println(JSONUtil.stringify(vo));
		CrmApi api = QwSdkUtil.getInter(CrmApi.class);
		// 调用接口
		CrmClientInfoPageResult clientVO = api.getClientPoolClientInfo(
				QwSdkUtil.getCacheToken(), vo);
		System.out.println(JSONUtil.stringify(clientVO));
		// SDK get-client-pool-client-info END
	}

	public static void getBusinessInfo() {
		// SDK get-business-info START
		// 创建请求的参数
		CrmDataPush vo = new CrmDataPush();
		// 设置当前页面
		vo.setCurrentPage(1);
		// 设置页面大小
		vo.setPageSize(10);
		// 设置要查询商机的时间范围（不超过两个月）
		vo.setStartTimes("2019-11-01");
		vo.setEndTime("2019-11-07");
		System.out.println(JSONUtil.stringify(vo));
		CrmApi api = QwSdkUtil.getInter(CrmApi.class);
		// 调用接口
		CrmBusinessInfoPageResult businessInfo = api.getBusinessInfo(
				QwSdkUtil.getCacheToken(), vo);
		System.out.println(JSONUtil.stringify(businessInfo));
		// SDK get-business-info END
	}

	public static void getContactsInfo() {
		// SDK get-contacts-info START
		// 创建请求参数
		CrmDataPush vo = new CrmDataPush();
		// 设置当前页面
		vo.setCurrentPage(1);
		// 设置页面大小
		vo.setPageSize(10);
		// 设置联系人信息的时间范围（不超过两个月）
		vo.setStartTimes("2017-01-01");
		vo.setEndTime("2017-02-01");
		System.out.println(JSONUtil.stringify(vo));
		CrmApi api = QwSdkUtil.getInter(CrmApi.class);
		// 调用接口
		CrmContactsInfoPageResult contactsInfo = api.getContactsInfo(
				QwSdkUtil.getCacheToken(), vo);
		System.out.println(JSONUtil.stringify(contactsInfo));
		// SDK get-contacts-info END
	}

	public static void getOutsideWorkInfo() {
		// SDK get-outside-work-info START
		// 创建请求参数
		CrmDataPush vo = new CrmDataPush();
		// 设置当前页面
		vo.setCurrentPage(1);
		// 设置页面大小
		vo.setPageSize(10);
		// 设置查询拜访信息的时间段（不超过两个月）
		vo.setStartTimes("2017-01-01");
		vo.setEndTime("2017-02-01");
		System.out.println(JSONUtil.stringify(vo));
		CrmApi api = QwSdkUtil.getInter(CrmApi.class);
		// 调用接口
		CrmWorkInfoPageResult workInfo = api.getOutsideWorkInfo(
				QwSdkUtil.getCacheToken(), vo);
		System.out.println(JSONUtil.stringify(workInfo));
		// SDK get-outside-work-info END
	}

	public static void getContractInfo() {
		// SDK get-contract-info START
		// 创建请求参数
		CrmDataPush vo = new CrmDataPush();
		// 设置当前页面
		vo.setCurrentPage(1);
		// 设置分页大小
		vo.setPageSize(10);
		// 设置合同信息的查询时间段（不超过两个月）
		vo.setStartTimes("2018-06-01");
		vo.setEndTime("2018-8-01");
		System.out.println(JSONUtil.stringify(vo));
		CrmApi api = QwSdkUtil.getInter(CrmApi.class);
		// 调用接口
		CrmContractInfoPageResult contractInfo = api.getContractInfo(
				QwSdkUtil.getCacheToken(), vo);
		System.out.println(JSONUtil.stringify(contractInfo));
		// SDK get-contract-info END
	}

	public static void addContacts() {
		// SDK add-contacts START
		// 创建请求参数
        CrmContactsReqVO vo = new CrmContactsReqVO();
        //客户id
        vo.setClientId("000527451e2b4157a93fd8cd2a687d93");
        //联系人名称
        vo.setContactsName("新增CRM0联系人");
        //生日
        vo.setBirthday("1990-10-12");
        //负责人id
        vo.setCcPersonIds("dc924ee1515cef2e3c0f8a6eff8ce5e2");
        //邮箱
        vo.setEmail("123@163.com");
        //兴趣
        vo.setHobby("看电影");
        //联系电话
        vo.setMobile("13436958425");
		//座机号码
		vo.setMobile("13436958425");
        //职位
        vo.setPosition("经理");
        //备注
        vo.setRemark("备注内容");
        //相关人id
        vo.setRelativePersonIds("dc924ee1515cef2e3c0f8a6eff8ce5e2,2a442250fe1d4c178a7e22e1e3794317");
        //学校
        vo.setSchoolName("XXX");
        //消息类型
        vo.setSubmitType("1");
        //自定义字段键值对
        Map<String, Object> optionMap = new HashMap<String, Object>();
        optionMap.put("数值小数",12.12);
        optionMap.put("多行文本","多行文本内容");
        optionMap.put("下拉菜单","选项1");
        optionMap.put("联系方式","13430524955");
        optionMap.put("日期类型","2018-01-12");
        vo.setOptionMap(optionMap);
		// 设置自定义高级字段
		List<CrmSeniorFieldVO> seniorFields = new ArrayList<CrmSeniorFieldVO>();
		// 单行文本
		seniorFields.add(new CrmSeniorFieldVO("fod9e4acf33e9147128fd085e7712a50e3", "这是高级字段单行类型字段"));
		// 邮箱
		seniorFields.add(new CrmSeniorFieldVO("foab338de2db0b449fa46cf375e9d87e3f", "123456789@qq.com"));
		// 数字
		seniorFields.add(new CrmSeniorFieldVO("fo57b9b1ae81ad492c879050330d5eb3d6", "233"));
		// 电话
		seniorFields.add(new CrmSeniorFieldVO("fo498bd7a5a3574807a9010882b70c334f", "020 12031200"));
		// 手机
		seniorFields.add(new CrmSeniorFieldVO("fo62e8daa9b10f41848a1e264f7de4819b", "13312031200"));
		// 多行文本
		seniorFields.add(new CrmSeniorFieldVO("fo61fd1ef6f36d4e5084f9a331b3d65b91", "这是高级字段多行文字类型\\n这是高级字段多行文字类型\\n"));
		// 日期
		seniorFields.add(new CrmSeniorFieldVO("fo645321f1c7b9415dba84974cc3f39202", "2019-12-03"));
		// 时间
		seniorFields.add(new CrmSeniorFieldVO("fo54af86e5f2494bb38a4de1a9282d0ad6", "12:00"));
		// 日期时间
		seniorFields.add(new CrmSeniorFieldVO("fob0adb4f6a7fe440782995cf6426f9ad3", "2019-11-11 11:11"));
		// 单项选择
		seniorFields.add(new CrmSeniorFieldVO("fo3674959396384edc8817651605913ccc", "选项1"));
		// 多项选择
		seniorFields.add(new CrmSeniorFieldVO("fod9e4acf33e9147128fd085e7712a50e3", "选项1,选项2"));
		// 下拉框
		seniorFields.add(new CrmSeniorFieldVO("foe99290cf57f84bfc814b70909a93fc4b", "选项1"));
		// 评分
		seniorFields.add(new CrmSeniorFieldVO("foe779eae3b38d436c8c72ded5324ba8b0", "3"));
		// 地理位置
		seniorFields.add(new CrmSeniorFieldVO("fo9982aebbdd9b423383e7182fbd57740c", "广东省广州市天河区员村一横路3号"));
		// 省市区
		seniorFields.add(new CrmSeniorFieldVO("fo6b8fdde86ec4472a972ec2b71edd7efa", "广东省:广州市:天河区"));
		// 计算式 （当前设置 高级字段-数字 * 2）
		seniorFields.add(new CrmSeniorFieldVO("fo521f8244ba3e4d6785602d4aee23a07d", "466"));
		// 二级选项
		seniorFields.add(new CrmSeniorFieldVO("fobb841af1252547b788d9c93c2baf27c3", "选项1:二级选项2"));
		// 通信录成员
		seniorFields.add(new CrmSeniorFieldVO("foc95fc853e5984552a77dc582a68e8962", "zhangsan,lisi"));
		// 部门
		seniorFields.add(new CrmSeniorFieldVO("foa19a6a39b6d3402a870fc7987ae40e13", "一级部门A->二级部门B,一级部门B->二级部门C->三级部门D"));

		vo.setSeniorFields(seniorFields);

		System.out.println(JSONUtil.stringify(vo));
		CrmApi api = QwSdkUtil.getInter(CrmApi.class);
		// 调用接口
        System.out.println(QwSdkUtil.getCacheToken());
        ApiCrmContactsResultVO crmContactsRepVO = api.addContacts(QwSdkUtil.getCacheToken(), vo);
        System.out.println(JSONUtil.stringify(crmContactsRepVO));
		// SDK add-contacts END
	}

	public static void updateContactsInfo() {
		// SDK update-contacts-info START
		// 创建请求参数
		CrmContactsReqVO vo = new CrmContactsReqVO();
		vo.setId("741dbc6cfd3046a08c8190f5ffc01fe4");
		//客户id
		vo.setClientId("000527451e2b4157a93fd8cd2a687d93");
		//联系人名称
		vo.setContactsName("更新CRM联系人");
		//生日
		vo.setBirthday("1990-10-12");
		//负责人id
		vo.setCcPersonIds("dc924ee1515cef2e3c0f8a6eff8ce5e2");
		//邮箱
		vo.setEmail("123@163.com");
		//兴趣
		vo.setHobby("看电影");
		//联系电话
		vo.setMobile("13436958425");
		//座机号码
		vo.setMobile("13436958425");
		//职位
		vo.setPosition("经理");
		//备注
		vo.setRemark("备注内容");
		//相关人id
		vo.setRelativePersonIds("dc924ee1515cef2e3c0f8a6eff8ce5e2,2a442250fe1d4c178a7e22e1e3794317");
		//学校
		vo.setSchoolName("XXX");
		//消息类型
		vo.setSubmitType("1");
		//自定义字段键值对
		Map<String, Object> optionMap = new HashMap<String, Object>();
		optionMap.put("数值小数",12.12);
		optionMap.put("多行文本","多行文本内容");
		optionMap.put("下拉菜单","选项1");
		optionMap.put("联系方式","13430524955");
		optionMap.put("日期类型","2018-01-12");
		vo.setOptionMap(optionMap);
		// 设置自定义高级字段
		List<CrmSeniorFieldVO> seniorFields = new ArrayList<CrmSeniorFieldVO>();
		// 单行文本
		seniorFields.add(new CrmSeniorFieldVO("fod9e4acf33e9147128fd085e7712a50e3", "这是高级字段单行类型字段"));
		// 邮箱
		seniorFields.add(new CrmSeniorFieldVO("foab338de2db0b449fa46cf375e9d87e3f", "123456789@qq.com"));
		// 数字
		seniorFields.add(new CrmSeniorFieldVO("fo57b9b1ae81ad492c879050330d5eb3d6", "233"));
		// 电话
		seniorFields.add(new CrmSeniorFieldVO("fo498bd7a5a3574807a9010882b70c334f", "020 12031200"));
		// 手机
		seniorFields.add(new CrmSeniorFieldVO("fo62e8daa9b10f41848a1e264f7de4819b", "13312031200"));
		// 多行文本
		seniorFields.add(new CrmSeniorFieldVO("fo61fd1ef6f36d4e5084f9a331b3d65b91", "这是高级字段多行文字类型\\n这是高级字段多行文字类型\\n"));
		// 日期
		seniorFields.add(new CrmSeniorFieldVO("fo645321f1c7b9415dba84974cc3f39202", "2019-12-03"));
		// 时间
		seniorFields.add(new CrmSeniorFieldVO("fo54af86e5f2494bb38a4de1a9282d0ad6", "12:00"));
		// 日期时间
		seniorFields.add(new CrmSeniorFieldVO("fob0adb4f6a7fe440782995cf6426f9ad3", "2019-11-11 11:11"));
		// 单项选择
		seniorFields.add(new CrmSeniorFieldVO("fo3674959396384edc8817651605913ccc", "选项1"));
		// 多项选择
		seniorFields.add(new CrmSeniorFieldVO("fod9e4acf33e9147128fd085e7712a50e3", "选项1,选项2"));
		// 下拉框
		seniorFields.add(new CrmSeniorFieldVO("foe99290cf57f84bfc814b70909a93fc4b", "选项1"));
		// 评分
		seniorFields.add(new CrmSeniorFieldVO("foe779eae3b38d436c8c72ded5324ba8b0", "3"));
		// 地理位置
		seniorFields.add(new CrmSeniorFieldVO("fo9982aebbdd9b423383e7182fbd57740c", "广东省广州市天河区员村一横路3号"));
		// 省市区
		seniorFields.add(new CrmSeniorFieldVO("fo6b8fdde86ec4472a972ec2b71edd7efa", "广东省:广州市:天河区"));
		// 计算式 （当前设置 高级字段-数字 * 2）
		seniorFields.add(new CrmSeniorFieldVO("fo521f8244ba3e4d6785602d4aee23a07d", "466"));
		// 二级选项
		seniorFields.add(new CrmSeniorFieldVO("fobb841af1252547b788d9c93c2baf27c3", "选项1:二级选项2"));
		// 通信录成员
		seniorFields.add(new CrmSeniorFieldVO("foc95fc853e5984552a77dc582a68e8962", "zhangsan,lisi"));
		// 部门
		seniorFields.add(new CrmSeniorFieldVO("foa19a6a39b6d3402a870fc7987ae40e13", "一级部门A->二级部门B,一级部门B->二级部门C->三级部门D"));

		vo.setSeniorFields(seniorFields);

		System.out.println(JSONUtil.stringify(vo));
		CrmApi api = QwSdkUtil.getInter(CrmApi.class);
		// 调用接口
		System.out.println(QwSdkUtil.getCacheToken());
		api.updateContactsInfo(QwSdkUtil.getCacheToken(), vo);
		// SDK update-contacts-info END
	}

	public static void getContactsFields() {
		// SDK get-contacts-fields START
		CrmApi api = QwSdkUtil.getInter(CrmApi.class);
		// 调用接口
		ApiCrmContactsFieldsResultVO result = api.getContactsFields(QwSdkUtil.getCacheToken());
		System.out.println(JSONUtil.stringify(result));
		// SDK get-contacts-fields END
	}

	public static void getContactsDetail() {
		// SDK get-contacts-detail START
		// 创建请求参数
		CrmContactsDetailReqVO vo = new CrmContactsDetailReqVO();
		// 设置获取类型
		vo.setContactsId("9662f5e997914a9ea0e81751b5feac47");
		System.out.println(JSONUtil.stringify(vo));
		CrmApi api = QwSdkUtil.getInter(CrmApi.class);
		// 调用接口
		ApiCrmContactsDetailsResultVO contactsInfo = api.getContactsDetail(QwSdkUtil.getCacheToken(), vo);
		System.out.println(JSONUtil.stringify(contactsInfo));
		// SDK get-contacts-detail END
	}

	public static void main(String[] args) {
		// 测试方法
//        addContacts();
//		getClientInfo();
		getClientPoolClientInfo();
//		getBusinessInfo();
//		getContactsInfo();
//		getOutsideWorkInfo();
//		getContractInfo();
//		getContactsFields();
//		getContactsDetail();
//		updateContactsInfo();
	}
}
