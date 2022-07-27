package cn.com.do1.apisdk.test;

import cn.com.do1.apisdk.inter.UserApi;
import cn.com.do1.apisdk.inter.addressbook.vo.*;
import cn.com.do1.apisdk.inter.rep.vo.*;
import cn.com.do1.apisdk.inter.req.vo.ApiGetUserListVO;
import cn.com.do1.apisdk.inter.req.vo.DimissionDataVO;
import cn.com.do1.apisdk.util.JSONUtil;
import cn.com.do1.apisdk.util.QwSdkUtil;

import java.util.List;

public class UserApiTest {


    public static void addUser(){
        // SDK add-user START
        InterfaceUser user = new InterfaceUser();
        //用户名称
        user.setName("张三");
        //部门ID
        user.setDepartmentId("03263e813a7801d41a7ccff9fc319331");
        //职位
        user.setPosition("经理");
        //手机号码  手机号，微信号，邮箱三者不可同时为空
        user.setMobile("13012365523");
        //性别（1，男；2，女） 默认为1
        user.setGender("1");
        //电话
        user.setTel("0968-123456");
        //邮箱  手机号，微信号，邮箱三者不可同时为空
        user.setEmail("daoyiyun543@qq.com");
        //QQ号码
        user.setQq("10000");
        //微信号  手机号，微信号，邮箱三者不可同时为空
        user.setWeixinNum("name12ss");
        //阳历生日
        user.setBirthday("1999-10-12");
        //入职时间
        user.setEntryTime("2018-12-12");
        //wxUserId
        user.setWxUserId("wxn3213123");
        //成员类型
        user.setAttribute(0);
        //身份证
        user.setIdentity("44522419950401432X");
        //昵称
        user.setNickName("小明");
        //排序值
        user.setSort(1000);
        //用户编号
        user.setUserNo("1231213");
        //身份
        user.setIsLeader(1);
        //座机2
        user.setTel2("020-88886366");
        //地址
        user.setAddress("广州市天河区");
        //农历生日
        user.setLunarCalendar("09-01");
        //生日祝福提醒
        user.setRemindType("1");
        //备注
        user.setMark("备注说明");

        //设置自定义字段信息
        UserListJsonVo userListJsonVo = JSONUtil.stringToObject("{\"list\":[{\"optionId\":\"082a0260688f4402967e41de22af4d00\",\"content\":\"广州员村\"},{\"optionId\":\"ff5f6ad211cf4ae2a471649205d4ecc0\",\"content\":\"2019-05-23\"}]}",
                UserListJsonVo.class);
        user.setListJson(userListJsonVo);

        UserApi api = QwSdkUtil.getInter(UserApi.class);
        ApiUserResultVO result = api.addUser(QwSdkUtil.getCacheToken(),user);
        System.out.println(JSONUtil.stringify(result));
        // SDK add-user END
    }

    public static void updateUser(){
        // SDK edit-user START
        InterfaceUser user = new InterfaceUser();
        //用户ID
        user.setUserId("6e53cc3431996f5a3bdbcd280f2954fc");
        //用户名称
        user.setName("张三");
        //部门ID
        user.setDepartmentId("03263e813a7801d41a7ccff9fc319331");
        //职位
        user.setPosition("经理助理");
        //手机号码  手机号，微信号，邮箱三者不可同时为空
        user.setMobile("13241214321");
        //性别（1，男；2，女）默认为1
        user.setGender("1");
        //电话
        user.setTel("0968-123456");
        //邮箱  手机号，微信号，邮箱三者不可同时为空
        user.setEmail("daoyiyun543@qq.com");
        //QQ号码
        user.setQq("10000");
        //微信号  手机号，微信号，邮箱三者不可同时为空。已关注的用户不可修改微信号
        user.setWeixinNum("name12ss");
        //阳历生日
        user.setBirthday("1999-10-12");
        //入职时间
        user.setEntryTime("2018-12-12");
        //成员类型
        user.setAttribute(0);
        //身份证
        user.setIdentity("44522419950401432X");
        //昵称
        user.setNickName("小明");
        //排序值
        user.setSort(1000);
        //用户编号
        user.setUserNo("1302313");
        //身份
        user.setIsLeader(1);
        //座机2
        user.setTel2("020-88886666");
        //地址
        user.setAddress("广州市天河区");
        //农历生日
        user.setLunarCalendar("09-01");
        //生日祝福提醒
        user.setRemindType("1");
        //备注
        user.setMark("备注说明");

        //设置自定义字段信息
        UserListJsonVo userListJsonVo = JSONUtil.stringToObject("{\"list\":[{\"id\":\"3c0afa85d5e24820af6f78b67c8e4b57\",\"optionId\":\"082a0260688f4402967e41de22af4d00\",\"content\":\"广州潭村广园快速路\"},{\"optionId\":\"5ceaa07b1383468ab7bd31c8aa9360d8\",\"content\":\"多选2\"}]}",
                UserListJsonVo.class);
        user.setListJson(userListJsonVo);

        UserApi api = QwSdkUtil.getInter(UserApi.class);
        ApiUserResultVO result = api.updateUser(QwSdkUtil.getCacheToken(),user);
        System.out.println(JSONUtil.stringify(result));
        // SDK edit-user END
    }

    public static void deleteUser(){
        // SDK delete-user START
        //用户ID
        String userId = "ab44f020aaaaa6e24b89";
        UserApi api = QwSdkUtil.getInter(UserApi.class);
        String result = api.deleteUser(QwSdkUtil.getCacheToken(), userId);
        System.out.println(result);
        // SDK delete-user END
    }

    public static void getUserByDepartId(){
        // SDK get-user-by-departid START
        //部门ID
        String departId = "173f023ffc5604e63dc5a8974728851c";
        UserApi api = QwSdkUtil.getInter(UserApi.class);
        ApiUserGetResultVO result = api.getUserByDepartId(QwSdkUtil.getCacheToken(), departId);
        System.out.println(JSONUtil.stringify(result));
        // SDK get-user-by-departid END
    }

    public static void getUserList(){
        // SDK address-sysc START
        ApiGetUserListVO vo = new ApiGetUserListVO();
        //当前版本的页数
        vo.setCurrentPage("1");
        /* 当前版本
         首次调用时，version填写0，currentPage填写1，表示初次调用该接口。
         开发 者需要存储接口返回的version和currentPage。
         版本号是0时，currentPage是1时，会返回1000条用户数据和全部的部门数据。
         当version号是0，页数大于1时，只会 返回用户数据。
         */
        vo.setVersion("0");
        UserApi api = QwSdkUtil.getInter(UserApi.class);
        ApiGetUserListResultVO result = api.getUserList(QwSdkUtil.getCacheToken(),vo);
        System.out.println(JSONUtil.stringify(result));
        // SDK address-sysc END
    }

    public static void dimission(){
        // SDK dimission-user START

        /**
         * 该接口支持批量操作，一次批量操作最大数量不超过50
         */

        /**
         *  建立一个dimission数组存放用户的离职信息
         *  注意：InterfaceDimission数组大小设置应该是与要处理离职信息数量对应
         */
        InterfaceDimission[] dimissions = new InterfaceDimission[1];
        InterfaceDimission vo = new InterfaceDimission();
        /**
         * 离职的微信UserId
         */
        vo.setWxUserId("1023-zy");
        /**
         * 离职时间 yyyy-MM-HH dd:mm:ss
         */
        vo.setLeaveTime("2018-10-13 17:18:43");
        /**
         * 离职的原因
         */
        vo.setLeaveRemark("离职Demo");
        /**
         * 将数据存放到数组中
         */
        dimissions[0] = vo;

        /**
         * 新建一个信息存储对象
         */
        ApiDimissionResultVO apiDimissionResultVO = new ApiDimissionResultVO();
        apiDimissionResultVO.setDimissions(dimissions);
        UserApi api = QwSdkUtil.getInter(UserApi.class);
        String result = api.dimission(QwSdkUtil.getCacheToken(),apiDimissionResultVO);
        System.out.println(result);
        // SDK dimission-user END
    }


    public static void rehab(){
        // SDK rehab-user START
        ApiRehabResultVO vo = new ApiRehabResultVO();
        InterfaceRehab rehab = new InterfaceRehab();
        /**
         * 复职的微信UserId
         */
        rehab.setWxUserId("1023-zy");
        /**
         * 复职人员名称
         */
        rehab.setPersonName("黎明");
        /**
         * 邮箱
         */
        rehab.setEmail("91562c2226@qq.com");
        /**
         * 入职时间
         */
        rehab.setEntryTime("2018-10-23 17:18:43");
        /**
         * 部门id
         */
        rehab.setDeptId("40ac852057ad761bd7d699f621a793ff");
        /**
         * 手机号码
         */
        rehab.setMobile("13008898989");
        /**
         * 座机
         */
        rehab.setTel("020-88888888");
        /**
         * 将复职人员信息放到消息类里
         */
        vo.setRehab(rehab);
        UserApi api = QwSdkUtil.getInter(UserApi.class);
        String result = api.rehab(QwSdkUtil.getCacheToken(),vo);
        System.out.println(result);
        // SDK rehab-user END
    }


    public static void getDimissionDataByWxUserId(){
        // SDK get-dimission-data START
        //微信wxUserId
        String wxUserId = "1023-zy";
        UserApi api = QwSdkUtil.getInter(UserApi.class);
        DimissionDataVO result = api.getDimissionDataByWxUserId(QwSdkUtil.getCacheToken(), wxUserId);
        System.out.println(JSONUtil.stringify(result));
        // SDK get-dimission-data END
    }

    public static void getExtendInfo(){
        // SDK get-extend-info START
        String corpId = "ww76540ea8781f31c5";
        UserApi api = QwSdkUtil.getInter(UserApi.class);
        ApiGetExtendInfoResultVo extendInfo = api.getExtendInfo(QwSdkUtil.getCacheToken(), corpId);
        System.out.println(JSONUtil.stringify(extendInfo));
        // SDK get-extend-info END
    }

    public static void main(String[] args) {
//          addUser();
        updateUser();
//        deleteUser();
//        getUserByDepartId();
//        getUserList();
//        dimission();
//        rehab();
//        getDimissionDataByWxUserId();
//        getExtendInfo();
    }
}
