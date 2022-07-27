package cn.com.do1.apisdk.test;

import cn.com.do1.apisdk.inter.CrmApi;
import cn.com.do1.apisdk.inter.crm.vo.CrmCommonCustomFieldValueVO;
import cn.com.do1.apisdk.inter.crm.vo.CrmSeniorFieldVO;
import cn.com.do1.apisdk.inter.rep.vo.ApiCrmBusinessFieldsResultVO;
import cn.com.do1.apisdk.inter.rep.vo.ApiCrmClientDetailsResultVO;
import cn.com.do1.apisdk.inter.rep.vo.ApiCrmContractDetailsResultVO;
import cn.com.do1.apisdk.inter.rep.vo.ApiCrmContractFieldsResultVO;
import cn.com.do1.apisdk.inter.rep.vo.ApiCrmInsertContractResultVO;
import cn.com.do1.apisdk.inter.req.vo.CrmClientDetailReqVO;
import cn.com.do1.apisdk.inter.req.vo.CrmContractDetailReqVO;
import cn.com.do1.apisdk.inter.req.vo.CrmContractInfoReqVO;
import cn.com.do1.apisdk.util.JSONUtil;
import cn.com.do1.apisdk.util.QwSdkUtil;

import java.util.ArrayList;
import java.util.List;

public class CrmContractTest {

    public static void insertContractInfo() {
        // SDK insert-contract-info START
        // 创建请求参数
        CrmContractInfoReqVO vo = new CrmContractInfoReqVO();
        // 设置基础字段
        vo.setTitle("0");
        vo.setClient("0f7aa6bdc71f42f7b66ef063aef01b21");
        vo.setBusiness("d6825c297b4e452493d2b704f78e00f8");
        vo.setContractAmount("23333");
        vo.setStartTime("2019-12-04");
        vo.setEndTime("2019-12-25");
        vo.setContractType("这是合同类型");
        vo.setStatus("流转中");
        vo.setPayment("支付宝");
        vo.setContent("这是合同正文。");
        vo.setSignTime("2019-12-25");
        vo.setOurSignatory("zhangsan");
        vo.setSignatory("3856a2d672fa4d368f549ac67b096bcd");
        vo.setRemark("这是备注");
        vo.setChargePersonWxIds("zhangsan");
        vo.setRelativePersonWxIds("lisi");
        vo.setSubmitType("1");
        // 设置每一个自定义字段
        CrmCommonCustomFieldValueVO dateTime = new CrmCommonCustomFieldValueVO("2f33bb8dbb242b4cc6be3653b39a14eb", "2019-12-03 12:00");
        CrmCommonCustomFieldValueVO textArea = new CrmCommonCustomFieldValueVO("799e90edc846894d7e077f6f1cfaa2c1", "132\\n456\\n789\\n");
        CrmCommonCustomFieldValueVO phoneNumber = new CrmCommonCustomFieldValueVO("88e5411991e5f4c4010257611ac4aa9a", "13344445555");
        CrmCommonCustomFieldValueVO doubleType = new CrmCommonCustomFieldValueVO("60539fa786a1801b172182849da04fbc", "123.45");
        CrmCommonCustomFieldValueVO selectField = new CrmCommonCustomFieldValueVO("e88b441f0bf31d93bce64dc18762d81f", "1");
        CrmCommonCustomFieldValueVO intType = new CrmCommonCustomFieldValueVO("31afb4319c55a3af9cf3bd34899c2735", "100000");
        CrmCommonCustomFieldValueVO textField = new CrmCommonCustomFieldValueVO("ea4f60fdf4540b45fab6d3e664f2c691", "单行内容");
        CrmCommonCustomFieldValueVO percentType = new CrmCommonCustomFieldValueVO("5f17acad9afbf1872630902dbab996e2", "50%");
        // 添加到list
        List<CrmCommonCustomFieldValueVO> customFields = new ArrayList<CrmCommonCustomFieldValueVO>();
        customFields.add(textField);
        customFields.add(textArea);
        customFields.add(selectField);
        customFields.add(phoneNumber);
        customFields.add(dateTime);
        customFields.add(intType);
        customFields.add(doubleType);
        customFields.add(percentType);
        vo.setCustomFields(customFields);
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
        ApiCrmInsertContractResultVO result = api.insertContractInfo(QwSdkUtil.getCacheToken(), vo);
        System.out.println(JSONUtil.stringify(result));
        // SDK insert-contract-info END
    }

    public static void updateContractInfo() {
        // SDK update-contract-info START
        // 创建请求参数
        CrmContractInfoReqVO vo = new CrmContractInfoReqVO();
        vo.setId("c5c17525-0ff2-4425-a57b-b075290f738f");
        // 设置基础字段
        vo.setTitle("更新合同标题");
        vo.setClient("0f7aa6bdc71f42f7b66ef063aef01b21");
        vo.setBusiness("d6825c297b4e452493d2b704f78e00f8");
        vo.setContractAmount("23333");
        vo.setStartTime("2019-12-04");
        vo.setEndTime("2019-12-25");
        vo.setContractType("这是合同类型");
        vo.setStatus("流转中");
        vo.setPayment("支付宝");
        vo.setContent("这是合同正文。");
        vo.setSignTime("2019-12-25");
        vo.setOurSignatory("zhangsan");
        vo.setSignatory("3856a2d672fa4d368f549ac67b096bcd");
        vo.setRemark("这是备注");
        vo.setChargePersonWxIds("zhangsan");
        vo.setRelativePersonWxIds("lisi");
        vo.setSubmitType("1");
        vo.setContractVersion("1");
        // 设置每一个自定义字段
        CrmCommonCustomFieldValueVO dateTime = new CrmCommonCustomFieldValueVO("2f33bb8dbb242b4cc6be3653b39a14eb", "2019-12-03 12:00");
        CrmCommonCustomFieldValueVO textArea = new CrmCommonCustomFieldValueVO("799e90edc846894d7e077f6f1cfaa2c1", "132\\n456\\n789\\n");
        CrmCommonCustomFieldValueVO phoneNumber = new CrmCommonCustomFieldValueVO("88e5411991e5f4c4010257611ac4aa9a", "13344445555");
        CrmCommonCustomFieldValueVO doubleType = new CrmCommonCustomFieldValueVO("60539fa786a1801b172182849da04fbc", "123.45");
        CrmCommonCustomFieldValueVO selectField = new CrmCommonCustomFieldValueVO("e88b441f0bf31d93bce64dc18762d81f", "1");
        CrmCommonCustomFieldValueVO intType = new CrmCommonCustomFieldValueVO("31afb4319c55a3af9cf3bd34899c2735", "100000");
        CrmCommonCustomFieldValueVO textField = new CrmCommonCustomFieldValueVO("ea4f60fdf4540b45fab6d3e664f2c691", "单行内容");
        CrmCommonCustomFieldValueVO percentType = new CrmCommonCustomFieldValueVO("5f17acad9afbf1872630902dbab996e2", "50%");
        // 添加到list
        List<CrmCommonCustomFieldValueVO> customFields = new ArrayList<CrmCommonCustomFieldValueVO>();
        customFields.add(textField);
        customFields.add(textArea);
        customFields.add(selectField);
        customFields.add(phoneNumber);
        customFields.add(dateTime);
        customFields.add(intType);
        customFields.add(doubleType);
        customFields.add(percentType);
        vo.setCustomFields(customFields);
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
        seniorFields.add(new CrmSeniorFieldVO("foc95fc853e5984552a77dc582a68e8962", "nbq"));
        // 部门
        seniorFields.add(new CrmSeniorFieldVO("foa19a6a39b6d3402a870fc7987ae40e13", "一级部门A->二级部门B,一级部门B->二级部门C->三级部门D"));

        vo.setSeniorFields(seniorFields);

        System.out.println(JSONUtil.stringify(vo));
        CrmApi api = QwSdkUtil.getInter(CrmApi.class);
        // 调用接口
        api.updateContractInfo(QwSdkUtil.getCacheToken(), vo);
        // SDK update-contract-info END
    }

    public static void getContractFields() {
        // SDK get-contract-fields START
        CrmApi api = QwSdkUtil.getInter(CrmApi.class);
        // 调用接口
        ApiCrmContractFieldsResultVO result = api.getContractFields(QwSdkUtil.getCacheToken());
        System.out.println(JSONUtil.stringify(result));
        // SDK get-contract-fields END
    }

    public static void getContractDetail() {
        // SDK get-contract-detail START
        // 创建请求参数
        CrmContractDetailReqVO vo = new CrmContractDetailReqVO();
        // 设置获取类型
        vo.setContractId("555f75876eab410da33ac33f8f1613e0");
        System.out.println(JSONUtil.stringify(vo));
        CrmApi api = QwSdkUtil.getInter(CrmApi.class);
        // 调用接口
        ApiCrmContractDetailsResultVO contractInfo = api.getContractDetail(QwSdkUtil.getCacheToken(), vo);
        System.out.println(JSONUtil.stringify(contractInfo));
        // SDK get-contract-detail END
    }

    public static void main(String[] args) {
        getContractFields();
        getContractDetail();
        insertContractInfo();
        updateContractInfo();
    }
}
