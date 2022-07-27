package cn.com.do1.apisdk.test;

import cn.com.do1.apisdk.inter.CrmApi;
import cn.com.do1.apisdk.inter.crm.vo.CrmCommonCustomFieldValueVO;
import cn.com.do1.apisdk.inter.crm.vo.CrmSeniorFieldVO;
import cn.com.do1.apisdk.inter.rep.vo.ApiCrmBusinessDetailsResultVO;
import cn.com.do1.apisdk.inter.rep.vo.ApiCrmBusinessFieldsResultVO;
import cn.com.do1.apisdk.inter.rep.vo.ApiCrmInsertBusinessResultVO;
import cn.com.do1.apisdk.inter.rep.vo.ApiGetBusinessStageResultVO;
import cn.com.do1.apisdk.inter.req.vo.BusinessInfoReqVO;
import cn.com.do1.apisdk.inter.req.vo.CrmBusinessDetailReqVO;
import cn.com.do1.apisdk.inter.req.vo.CrmBusinessStageReqVO;
import cn.com.do1.apisdk.inter.req.vo.CrmUpdateBusinessStageReqVO;
import cn.com.do1.apisdk.util.JSONUtil;
import cn.com.do1.apisdk.util.QwSdkUtil;

import java.util.ArrayList;
import java.util.List;

public class CrmBusinessApiTest {
    public static void getBusinessStageOrType() {
        // SDK get-business-stage-or-type START
        // 创建请求参数
        CrmBusinessStageReqVO vo = new CrmBusinessStageReqVO();
        // 设置获取类型
        vo.setOptionType("0");
        System.out.println(JSONUtil.stringify(vo));
        CrmApi api = QwSdkUtil.getInter(CrmApi.class);
        // 调用接口
        ApiGetBusinessStageResultVO result = api.getBusinessStageOrType(
                QwSdkUtil.getCacheToken(), vo);
        System.out.println(JSONUtil.stringify(result));
        // SDK get-business-stage-or-type END
    }

    public static void getBusinessDetail() {
        // SDK get-business-detail START
        // 创建请求参数
        CrmBusinessDetailReqVO vo = new CrmBusinessDetailReqVO();
        // 设置获取类型
        vo.setBusinessId("8a99d77f-62a1-4107-9a16-87e37c0447bc");
        System.out.println(JSONUtil.stringify(vo));
        CrmApi api = QwSdkUtil.getInter(CrmApi.class);
        // 调用接口
        ApiCrmBusinessDetailsResultVO contractInfo = api.getBusinessDetail(
                QwSdkUtil.getCacheToken(), vo);
        System.out.println(JSONUtil.stringify(contractInfo));
        // SDK get-business-detail END
    }

    public static void getBusinessFields() {
        // SDK get-business-fields START
        CrmApi api = QwSdkUtil.getInter(CrmApi.class);
        // 调用接口
        ApiCrmBusinessFieldsResultVO result = api.getBusinessFields(
                QwSdkUtil.getCacheToken());
        System.out.println(JSONUtil.stringify(result));
        // SDK get-business-fields END
    }

    public static void updateBusinessStage() {
        // SDK update-business-stage START
        // 创建请求参数
        CrmUpdateBusinessStageReqVO vo = new CrmUpdateBusinessStageReqVO();
        // 设置获取类型
        vo.setBusinessId("ee1b8b2227cc46dca8b3a4975b72e4e8");
        vo.setBusinessStage("1");
        System.out.println(JSONUtil.stringify(vo));
        CrmApi api = QwSdkUtil.getInter(CrmApi.class);
        // 调用接口
        api.updateBusinessStage(
                QwSdkUtil.getCacheToken(), vo);
        // SDK update-business-stage END
    }

    public static void insertBusinessInfo() {
        // SDK insert-business-info START
        // 创建请求参数
        BusinessInfoReqVO vo = new BusinessInfoReqVO();
        // 设置获取类型
        vo.setBusinessStage("2");
        vo.setBusinessType("12");
        vo.setChargePersonId("wx_mr_zhao");
        vo.setClientId("9a2fb91e1fef48b7a582a34968bd9925");
        vo.setContactIds("1bb3eeb54e2844598189272adbfd6d35,874a21aa4a4f423da64cb0c8a20f72d4");
        vo.setContent("这是商机内容");
        vo.setEstimatedDate("2019-12-03");
        vo.setEstimatedSale("100000000.0");
        vo.setPartnersIds("33ee9ac3dc194d8ba7341ffbc16208df,1ea6a30f40014f8eb363afdb857ce710");
        vo.setRelativePersonsIds("wx_miss_li,wx_mr_liu");
        vo.setSubmitType("1");
        vo.setTitle("这是商机标题");
        // 设置每一个自定义字段
        CrmCommonCustomFieldValueVO textField = new CrmCommonCustomFieldValueVO("ad3383676ae1090cf39bdc9e6fa20676", "这是单行文本");
        CrmCommonCustomFieldValueVO textArea = new CrmCommonCustomFieldValueVO("c1bec3b07dfc8f7e350afc8da30e5cb1", "这是多行文本\\n这是多行文本\\n");
        CrmCommonCustomFieldValueVO selectField = new CrmCommonCustomFieldValueVO("6cae2f16cd2a67b2b4613b3719527a47", "1");
        CrmCommonCustomFieldValueVO phoneNumber = new CrmCommonCustomFieldValueVO("21e7c172cc7a1bec704b793d5e739beb", "13312031200");
        CrmCommonCustomFieldValueVO dateTime = new CrmCommonCustomFieldValueVO("4e4eb8cba8a0d9e72a085f2f36d861a0", "2019-07-10 14:00:00");
        CrmCommonCustomFieldValueVO intType = new CrmCommonCustomFieldValueVO("73504817cff862f1748b2735a852fbfe", "100000");
        CrmCommonCustomFieldValueVO doubleType = new CrmCommonCustomFieldValueVO("bf459fb4837c9a6b161ddac72dd7c836", "1000000.00");
        CrmCommonCustomFieldValueVO percentType = new CrmCommonCustomFieldValueVO("5c8fe1262515a435e6eb004f540d1c5f", "80%");
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
        ApiCrmInsertBusinessResultVO businessInfo = api.insertBusinessInfo(QwSdkUtil.getCacheToken(), vo);
        System.out.println(JSONUtil.stringify(businessInfo));
        // SDK insert-business-info END
    }

    public static void updateBusinessInfo() {
        // SDK update-business-info START
        // 创建请求参数
        BusinessInfoReqVO vo = new BusinessInfoReqVO();
        vo.setId("9f18f306-f34c-4b42-bfc1-41a4bba7fa26");
        // 设置获取类型
        vo.setBusinessStage("2");
        vo.setBusinessType("12");
        vo.setChargePersonId("wx_mr_zhao");
        vo.setClientId("9a2fb91e1fef48b7a582a34968bd9925");
        vo.setContactIds("1bb3eeb54e2844598189272adbfd6d35,874a21aa4a4f423da64cb0c8a20f72d4");
        vo.setContent("这是商机内容");
        vo.setEstimatedDate("2019-12-03");
        vo.setEstimatedSale("100000000.0");
        vo.setPartnersIds("33ee9ac3dc194d8ba7341ffbc16208df,1ea6a30f40014f8eb363afdb857ce710");
        vo.setRelativePersonsIds("wx_miss_li,wx_mr_liu");
        vo.setSubmitType("1");
        vo.setTitle("这是商机标题");
        // 设置每一个自定义字段
        CrmCommonCustomFieldValueVO textField = new CrmCommonCustomFieldValueVO("ad3383676ae1090cf39bdc9e6fa20676", "这是单行文本");
        CrmCommonCustomFieldValueVO textArea = new CrmCommonCustomFieldValueVO("c1bec3b07dfc8f7e350afc8da30e5cb1", "这是多行文本\\n这是多行文本\\n");
        CrmCommonCustomFieldValueVO selectField = new CrmCommonCustomFieldValueVO("6cae2f16cd2a67b2b4613b3719527a47", "1");
        CrmCommonCustomFieldValueVO phoneNumber = new CrmCommonCustomFieldValueVO("21e7c172cc7a1bec704b793d5e739beb", "13312031200");
        CrmCommonCustomFieldValueVO dateTime = new CrmCommonCustomFieldValueVO("4e4eb8cba8a0d9e72a085f2f36d861a0", "2019-07-10 14:00:00");
        CrmCommonCustomFieldValueVO intType = new CrmCommonCustomFieldValueVO("73504817cff862f1748b2735a852fbfe", "100000");
        CrmCommonCustomFieldValueVO doubleType = new CrmCommonCustomFieldValueVO("bf459fb4837c9a6b161ddac72dd7c836", "1000000.00");
        CrmCommonCustomFieldValueVO percentType = new CrmCommonCustomFieldValueVO("5c8fe1262515a435e6eb004f540d1c5f", "80%");
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
        api.updateBusinessInfo(QwSdkUtil.getCacheToken(), vo);
        // SDK insert-business-info END
    }


    public static void main(String[] args) {
        getBusinessStageOrType();
        getBusinessDetail();
        getBusinessFields();
        updateBusinessStage();
        insertBusinessInfo();
        getBusinessFields();
        getBusinessDetail();
        updateBusinessInfo();
    }
}
