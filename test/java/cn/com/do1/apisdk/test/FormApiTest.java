package cn.com.do1.apisdk.test;

import cn.com.do1.apisdk.inter.FormApi;
import cn.com.do1.apisdk.inter.form.vo.*;
import cn.com.do1.apisdk.inter.rep.vo.ApiFormCreateResult;
import cn.com.do1.apisdk.inter.rep.vo.ApiFormPushResult;
import cn.com.do1.apisdk.inter.req.vo.ApiFormCreateVO;
import cn.com.do1.apisdk.inter.req.vo.FormDataPushVO;
import cn.com.do1.apisdk.util.FormFieldTypeUtil;
import cn.com.do1.apisdk.util.JSONUtil;
import cn.com.do1.apisdk.util.QwSdkUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormApiTest {

	/**
	 * 新增表单接口测试
	 */
	public static void createForm() {
		// SDK create-form START
		ApiFormCreateVO vo = new ApiFormCreateVO();

		// 控制设置 --- START
		FormControl formControl = new FormControl();
		// 表单分组
		formControl.setTypeName("测试审批单");

		// 表单类型 0普通单 1任务单 2审批单 3外部单
		formControl.setIsTask("2");

		// 标题模板
		formControl.setTitleTemplate("{create_user_name}的订单{yyyyMMdd}");

		formControl.setIsBuildTitle("2");
		formControl.setIsUpdaeTitle(2);
		// 支持相关人
		formControl.setIsRelevants("1");
		// 填单时生成标题
		formControl.setIsBuildTitle("1");
		// 支持负责人
		formControl.setIsRelatives("1");
		vo.setFormControl(formControl);
		// 控制设置 --- END

		// 控制设置 --- START
		FormDetails formDetails = new FormDetails();
		formDetails.setDefinitionVersionsId("fca9dcc3-423d-4334-8bba-181ca85ba785");
		formDetails.setTitle("订单中心");
		formDetails.setFormName("订单中心");
		vo.setFormDetails(formDetails);
		// 控制设置 --- END


		List<Fields> list = new ArrayList<Fields>();

		// 单行文本
		Fields f = new Fields();
		f.set_id("customerName");
		f.set_type(FormFieldTypeUtil.TEXTFIELD);
		f.setLabel("客户姓名");
		// 最大长度
		f.setMaximum_length(10);
		// 最小长度
		f.setMinimum_length(2);
		// 必填
		f.setValidations(new String[] { "presence" });
		// 提示
		f.setNotes("请输入客户名称，开发票用");
		list.add(f);


		// 手机
		f = new Fields();
		f.set_id("mobile");
		f.set_type(FormFieldTypeUtil.MOBILEFIELD);
		f.setLabel("手机号码");
		list.add(f);

		// 电话
		f = new Fields();
		f.set_id("tel");
		f.set_type(FormFieldTypeUtil.TELEPHONEFIELD);
		f.setLabel("联系电话");
		list.add(f);

		// 邮箱
		f = new Fields();
		f.set_id("mail");
		f.set_type(FormFieldTypeUtil.EMAILFIELD);
		f.setLabel("邮箱");
		list.add(f);

		// 单项选择
		f = new Fields();
		f.set_id("channel");
		f.set_type(FormFieldTypeUtil.RADIOBUTTON);
		f.setLabel("渠道");
		// 一行三列
		f.setLine_row(3);
		list.add(f);

		Choices c1 = new Choices();
		c1.set_id("tianmao");
		c1.setSelected(true);
		c1.setValue("天猫");

		Choices c2 = new Choices();
		c2.set_id("jd");
		c2.setValue("京东");

		Choices c3 = new Choices();
		c3.set_id("else");
		c3.setValue("其他");

		f.setChoices(new Choices[] { c1, c2, c3 });

		// 多项选择
		f = new Fields();
		f.set_id("favor");
		f.set_type(FormFieldTypeUtil.CHECKBOX);
		f.setLabel("优惠");

		c1 = new Choices();
		c1.set_id("efp");
		c1.setSelected(true);
		c1.setValue("包邮");

		c2 = new Choices();
		c2.set_id("discount");
		c2.setValue("满减");

		c3 = new Choices();
		c3.set_id("etper");
		c3.setValue("八折");

		f.setChoices(new Choices[] { c1, c2, c3 });
		list.add(f);


		// 下拉框
		f = new Fields();
		f.set_id("customLevel");
		f.set_type(FormFieldTypeUtil.DROPDOWN);
		f.setLabel("客户等级");

		c1 = new Choices();
		c1.set_id("0");
		c1.setSelected(true);
		c1.setValue("普通客户");

		c2 = new Choices();
		c2.set_id("1");
		c2.setValue("银卡VIP");

		c3 = new Choices();
		c3.set_id("2");
		c3.setValue("金卡VIP");

		Choices c4 = new Choices();
		c4.set_id("3");
		c4.setValue("铂金VIP");

		Choices c5 = new Choices();
		c5.set_id("4");
		c5.setValue("钻石VIP");

		f.setChoices(new Choices[] { c1, c2, c3, c4, c5 });
		list.add(f);

		// 两级下拉框
		f = new Fields();
		f.set_id("orderCategory");
		f.set_type(FormFieldTypeUtil.CASCADEDROPDOWN);
		f.setLabel("订单分类");

		c1 = new Choices();
		c1.set_id("0");
		c1.setSelected(true);
		c1.setValue("实物类");

		c1.setSub_choices(new SubChoices[] { new SubChoices("办公用品"),
				new SubChoices("日用品"), new SubChoices("食品") });

		c2 = new Choices();
		c2.set_id("1");
		c2.setValue("虚拟类");
		c2.setSub_choices(new SubChoices[]{new SubChoices("交通费"),new SubChoices("服务类")});

		c3 = new Choices();
		c3.set_id("2");
		c3.setValue("其他");
		c3.setSub_choices(new SubChoices[]{new SubChoices("其它")});

		f.setChoices(new Choices[] { c1, c2, c3});
		list.add(f);

		// 地理位置
		f = new Fields();
		f.set_id("tradeLoc");
		f.set_type(FormFieldTypeUtil.GEOFIELD);
		f.setLabel("商家地址");
		list.add(f);

		// 省市区
		f = new Fields();
		f.set_id("proCityArea");
		f.set_type(FormFieldTypeUtil.CITYFIELD);
		f.setLabel("配送地址");
		list.add(f);

		// 多行文本
		f = new Fields();
		f.set_id("address");
		f.set_type(FormFieldTypeUtil.TEXTAREA);
		f.setLabel("详细地址");
		list.add(f);

		// 日期
		f = new Fields();
		f.set_id("buyDate");
		f.set_type(FormFieldTypeUtil.DATEFIELD);
		f.setLabel("购买日期");
		list.add(f);

		// 时间
		f = new Fields();
		f.set_id("deliverTime");
		f.set_type(FormFieldTypeUtil.TIMEFIELD);
		f.setLabel("送货时间");
		list.add(f);

		// 日期时间
		f = new Fields();
		f.set_id("createTime");
		f.set_type(FormFieldTypeUtil.DATETIMEFIELD);
		f.setLabel("订单生成时间");
		list.add(f);

		// 评分
		f = new Fields();
		f.set_id("score");
		f.set_type(FormFieldTypeUtil.RATINGFIELD);
		f.setLabel("客户评价");
		// 评分样式
		f.setRating_type(FormFieldTypeUtil.STAR);
		// 最多10分
		f.setMaximum_length(10);
		list.add(f);

		// 图片
		f = new Fields();
		f.set_id("picList");
		f.set_type(FormFieldTypeUtil.IMAGEFIELD);
		f.setLabel("订单晒图");
		list.add(f);

		// 说明项
		f = new Fields();
		f.set_id("commentary");
		f.set_type(FormFieldTypeUtil.IMAGECHECKBOX);
		f.setLabel("请填写订单项");
		f.setNotes("请填写项目，用于打印发票明细");
		list.add(f);


		// 子表单的设计 --- START
		{
			Fields childF = new Fields();
			childF.set_id("items");
			childF.set_type(FormFieldTypeUtil.CHILDFIELD);
			childF.setLabel("订单项");
			childF.setChildren(new Fields[5]);
			list.add(childF);

			f = new Fields();
			f.set_id("itemPic");
			f.set_type(FormFieldTypeUtil.IMAGEFIELD);
			f.setLabel("商品图片");
			childF.getChildren()[0] = f;

			f = new Fields();
			f.set_id("itemName");
			f.set_type(FormFieldTypeUtil.TEXTFIELD);
			f.setLabel("商品名称");
			childF.getChildren()[1] = f;


			f = new Fields();
			f.set_id("price");
			f.set_type(FormFieldTypeUtil.NUMBERFIELD);
			f.setLabel("价格");
			// 精度
			f.setAccurate_num(2);
			childF.getChildren()[2] = f;

			f = new Fields();
			f.set_id("buyNum");
			f.set_type(FormFieldTypeUtil.NUMBERFIELD);
			f.setLabel("数量");
			// 精度
			f.setAccurate_num(-1);
			childF.getChildren()[3] = f;

			// 计算式
			f = new Fields();
			f.set_id("amount");
			f.set_type(FormFieldTypeUtil.EQUATIONFIELD);
			f.setLabel("合计");
			// 计算公式
			f.setCalculator("price*buyNum");
			f.setNotes("价格*数量");
			// 精度
			f.setAccurate_num(2);
			childF.getChildren()[4] = f;
		}
		// 子表单的设计 --- END

		// 统计式
		f = new Fields();
		f.set_id("total");
		f.set_type(FormFieldTypeUtil.STATISTICSFIELD);
		f.setLabel("价格");
		// 求和
		f.setLine_row(FormFieldTypeUtil.STATISTICSFIELD_SUM);
		// 统计公式
		f.setCalculator("items|amount");
		// 精度
		f.setAccurate_num(2);
		f.setLabel("总计");
		list.add(f);

		f = new Fields();
		f.set_id("postage");
		f.set_type(FormFieldTypeUtil.NUMBERFIELD);
		f.setLabel("运费");
		// 默认值
		f.setPredefined_value("6.00");
		// 精度
		f.setAccurate_num(2);
		list.add(f);

		// 计算式
		f = new Fields();
		f.set_id("payAmount");
		f.set_type(FormFieldTypeUtil.EQUATIONFIELD);
		f.setLabel("支付总金额");
		f.setNotes("总计+运费");
		// 计算公式
		f.setCalculator("total+postage");
		// 精度
		f.setAccurate_num(2);
		list.add(f);

		vo.setFormField(list.toArray(new Fields[list.size()]));
		System.out.println(JSONUtil.stringify(vo));
		FormApi api = QwSdkUtil.getInter(FormApi.class);
		// 调用接口
		ApiFormCreateResult re = api.createForm(QwSdkUtil.getCacheToken(), vo);

		// 表单id
		System.out.println(re.getDefinitionVersionsId());
		// 版本号
		System.out.println(re.getVersions());
		// 版本id
		System.out.println(re.getDefinitionId());
		// 填单地址
		System.out.println(re.getUrl());
		// SDK create-form END
	}

	public static void pushForm(){
		// SDK push-form-data START
		FormDataPushVO vo = new FormDataPushVO();
		// 提单时间，不填则用企微云的系统时间
//		vo.setCreateTime("2018-06-07 12:00:31");
		// 提单人账号
		vo.setCreator("qixiaowei");
		// 工单标题
		vo.setInstanceTitle("企小微的订单20180607");
		// 相关人账号
		vo.setCcList(new String[]{"qixiaowei"});
		// 负责人账号
		vo.setToList(new String[]{"qixiaowei"});

		// 字段数据
		Map<String,Object> fieldMap = new HashMap<String,Object>();
		fieldMap.put("customerName", "企小微");
		fieldMap.put("channel", "天猫");
		fieldMap.put("favor", new String[]{"包邮"});
		fieldMap.put("proCityArea", "广东省:广州市:天河区");
		fieldMap.put("address", "员村一横路3号华颖轩");
		fieldMap.put("buyDate", "2018-06-07");
		fieldMap.put("deliverTime", "18:30");
		fieldMap.put("score", "9");
		fieldMap.put("mobile", "13700000000");
		fieldMap.put("tel", "02000000000");
		fieldMap.put("mail", "qixiaowei@do1.com.cn");
		fieldMap.put("customLevel", "金卡VIP");
		fieldMap.put("orderCategory", "虚拟类:服务类");
		GeoFieldVO gf = new GeoFieldVO();
		gf.setLatitude(23.127874);
		gf.setLongitude(113.359926);
		gf.setValue("道一信息");
		fieldMap.put("createTime", "2018-06-12 12:13");
		fieldMap.put("tradeLoc", gf);
		Map<String,Object> item = new HashMap<String,Object>();
		item.put("itemName", "企微云考勤机");
		item.put("price", "499.00");
		item.put("buyNum", "2");
		item.put("amount", "998.00");

		Map<String,Object> item2 = new HashMap<String,Object>();
		item2.put("itemName", "金卡VIP");
		item2.put("price", "8999.00");
		item2.put("buyNum", "1");
		item2.put("amount", "8999.00");


		fieldMap.put("items", new Map[]{item,item2} );
		fieldMap.put("total", "9997.00");
		fieldMap.put("postage", "8.00");
		fieldMap.put("payAmount", "10005.00");
		// 字段数据
		vo.setFieldMap(fieldMap);

		System.out.println(JSONUtil.stringify(vo));
		FormApi api = QwSdkUtil.getInter(FormApi.class);
		// 调用接口
		ApiFormPushResult re = api.pushFormData(QwSdkUtil.getCacheToken(),
				"fca9dcc3-423d-4334-8bba-181ca85ba785",1, new FormDataPushVO[]{vo});

		System.out.println(JSONUtil.stringify(re));
		// SDK push-form-data END
	}

	public static void updateFormData(){
		// SDK update-form-data START
		FormDataPushVO vo = new FormDataPushVO();
		// 提单时间，不填则用企微云的系统时间
//		vo.setCreateTime("2018-06-07 12:00:31");
		// 提单人账号
		vo.setCreator("qixiaowei");
		// 工单标题
		vo.setInstanceTitle("企小微的订单20180607");
		// 相关人账号
		vo.setCcList(new String[]{"qixiaowei"});
		// 发起时返回的工单id
		vo.setId("34b610ac12ad40458e8aba2fcc200260");

		// 字段数据
		Map<String,Object> fieldMap = new HashMap<String,Object>();
		fieldMap.put("score", "10");
		Map<String,Object> item = new HashMap<String,Object>();
		item.put("itemName", "企微云考勤机");
		item.put("price", "499.00");
		item.put("buyNum", "20");
		item.put("amount", "9980.00");

		Map<String,Object> item2 = new HashMap<String,Object>();
		item2.put("itemName", "金卡VIP");
		item2.put("price", "8999.00");
		item2.put("buyNum", "1");
		item2.put("amount", "8999.00");


		fieldMap.put("items", new Map[]{item,item2} );
		fieldMap.put("total", "18979.00");
		fieldMap.put("postage", "0.00");
		fieldMap.put("payAmount", "18979.00");
		// 字段数据
		vo.setFieldMap(fieldMap);

		System.out.println(JSONUtil.stringify(vo));
		FormApi api = QwSdkUtil.getInter(FormApi.class);
		// 调用接口
		ApiFormPushResult re = api.updateFormData(QwSdkUtil.getCacheToken(),
				"fca9dcc3-423d-4334-8bba-181ca85ba785", new FormDataPushVO[]{vo});

		System.out.println(JSONUtil.stringify(re));
		// SDK update-form-data END
	}

	public static void deleteFormData(){
		// SDK delete-form-data START
		FormApi api = QwSdkUtil.getInter(FormApi.class);
		// 调用接口
		ApiFormPushResult re = api.deleteFormData(QwSdkUtil.getCacheToken(),
				// 表单id
				"fca9dcc3-423d-4334-8bba-181ca85ba785",
				// 发起时返回的工单id
				new String[]{"34b610ac12ad40458e8aba2fcc200260"});

		System.out.println(JSONUtil.stringify(re));
		// SDK delete-form-data END
	}

	public static void ajaxGetFormFieldInfoSimple(){
		// SDK ajax-get-form-field-info-simple START
		FormApi api = QwSdkUtil.getInter(FormApi.class);
		// 调用接口
		FormFieldInfoSimpleResultVO result = api.ajaxGetFormFieldInfoSimple(QwSdkUtil.getCacheToken(),
				// 表单id
				"9c3f6a18-5f1f-4bbb-b7d7-81331f238352");
		System.out.println(JSONUtil.stringify(result));
		// SDK ajax-get-form-field-info-simple END
	}

	public static void getFormOrder(){
		// SDK get-form-order START
		FormApi api = QwSdkUtil.getInter(FormApi.class);
		// 请求参数data
		GetFormOrderParamVO data = new GetFormOrderParamVO();
		//获取第几页信息（非必须）
		data.setPageNO(1);
		//每页显示数据条数（非必须）
		data.setPageSize(10);
		// 调用接口
		GetFormOrderResultVO result = api.getFormOrder(QwSdkUtil.getCacheToken(),
				// 请求参数data
				data);
		System.out.println(JSONUtil.stringify(result));
		// SDK get-form-order END
	}

	public static void getFormDetails(){
		// SDK get-form-details START
		FormApi api = QwSdkUtil.getInter(FormApi.class);
		// 请求参数data
		GetFormDetailsParamVO data = new GetFormDetailsParamVO();
		// 获取第几页信息（非必须）
		data.setPageNO(1);
		// 每页显示数据条数（非必须）
		data.setPageSize(10);
		// 开始时间（非必须）
		data.setStartDate("2018-06-01 00:00:00");
		// 结束时间（非必须）
		data.setEndDate("2018-06-30 00:00:00");
		// 版本id（必须）
		data.setDefinitionId("316eb481-57ec-46d7-b2d3-38a361bf9b96");
		// 提单人账号（非必须）
		data.setWxUserId("daoyiyun");
		// 是否导出评论列表和审批明细列表（非必须）
		data.setToSearchCommentAndAudit(true);
		// 调用接口
		GetFormDetailsResultVO result = api.getFormDetails(QwSdkUtil.getCacheToken(),
				// 请求参数data
				data);
		System.out.println(JSONUtil.stringify(result));
		// SDK get-form-details END
	}

	public static void getFormData(){
		// SDK get-form-data START
		FormApi api = QwSdkUtil.getInter(FormApi.class);
		// 调用接口
		GetFormDataResultVO formData = api.getFormData(QwSdkUtil.getCacheToken(),
				//corpId
				"wx07ad350b0dfd7747",
				//表单id
				"formacc562a5bd6c49429a9b59c42855bb33"
				// 工单id数组
				,new String[]{"work0386b4e038a643b2856b0693b7e87dd9"});

		System.out.println(JSONUtil.stringify(formData));
		// SDK get-form-data END
	}

	public static void main(String args[]) throws Exception {
		// get tests
		createForm();
//		ajaxGetFormFieldInfoSimple();
//		getFormOrder();
//		getFormDetails();
//		getFormData();
	}

}
