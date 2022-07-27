package cn.com.do1.apisdk.test;

import cn.com.do1.apisdk.inter.CheckWorkApi;
import cn.com.do1.apisdk.inter.checkwork.vo.UserCheckVO;
import cn.com.do1.apisdk.inter.req.vo.*;
import cn.com.do1.apisdk.util.QwSdkUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckWorkApiTest {

    public static void registerVirtualService() {
        // SDK register-virtual-service START
        CheckWorkApi api = QwSdkUtil.getInter(CheckWorkApi.class);
        //调用接口
        api.registerVirtualService(QwSdkUtil.getCacheToken());
        // SDK register-virtual-service END
    }

    public static void addVirtualDevices() {
        // SDK add-virtual-devices START
        //创建请求的参数
        VirtualMachineNamesVO vo = new VirtualMachineNamesVO();
        //设置虚拟考勤机名数组
        String[] machineNames = new String[]{"machineA", "machineB", "machineC"};
        vo.setMachineNames(machineNames);
        CheckWorkApi api = QwSdkUtil.getInter(CheckWorkApi.class);
        //调用接口
        api.addVirtualDevices(QwSdkUtil.getCacheToken(), vo);
        // SDK add-virtual-devices END
    }

    public static void delVirtualDevices() {
        // SDK del-virtual-devices START
        //创建请求的参数
        VirtualMachineIdsVO vo = new VirtualMachineIdsVO();
        //设置虚拟考勤机ID
        String[] machineIds = new String[]{"535898b0a1284552bbd79856d00e3aba"};
        vo.setMachineIds(machineIds);
        CheckWorkApi api = QwSdkUtil.getInter(CheckWorkApi.class);
        //调用接口
        api.delVirtualDevices(QwSdkUtil.getCacheToken(), vo);
        // SDK del-virtual-devices END
    }

    public static void addVirtualDeviceCheck() {
        // SDK add-virtual-devices-check START
        //创建请求的参数
        VirtualMachineCheckVO vo = new VirtualMachineCheckVO();
        List<UserCheckVO> list = new ArrayList<UserCheckVO>();
        UserCheckVO checkVO = new UserCheckVO();
        //设置虚拟考勤机ID
        checkVO.setMachineId("535898b0a1284552bbd79856d00e3aba");
        //设置固定格式的日期参数
        Date date = new Date();
        //String dateStr = DateUtil.formatDate(date, "yyyyMMddHHmmSS");
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmSS");
        String dateStr = sf.format(date);
        checkVO.setCheckTime(dateStr);
        //设置微信ID
        checkVO.setWxUserId("xiaoxiaoma");
        list.add(checkVO);
        checkVO = new UserCheckVO();
        checkVO.setDeviceId("535898b0a1284552bbd79856d00e3aba");
        checkVO.setCheckTime(dateStr);
        checkVO.setWxUserId("chenming");
        list.add(checkVO);
        vo.setUserCheckList(list.toArray(new UserCheckVO[list.size()]));
        CheckWorkApi api = QwSdkUtil.getInter(CheckWorkApi.class);
        //调用接口
        api.addVirtualDeviceCheck(QwSdkUtil.getCacheToken(), vo);
        // SDK add-virtual-devices-check END
    }

    public static void getCheckRuleSchedulingList() {
        // SDK get-checkrule-scheduling-list START
        //创建请求的参数
        CheckRuleSchedulingVO vo = new CheckRuleSchedulingVO();
        //设置虚拟考勤机ID
        vo.setCheckWorkId("383A18DE-C3F4-4565-ADDC-96C32B8F317C");
        //设置当前页数
        vo.setCurrentPage("1");
        //设置开始时间
        vo.setStartTime("20180524103700");
        //设置结束时间
        vo.setEndTime("20180624103700");
        //设置页面大小
        vo.setPageSize("100");
        CheckWorkApi api = QwSdkUtil.getInter(CheckWorkApi.class);
        //调用接口
        api.getCheckRuleSchedulingList(QwSdkUtil.getCacheToken(), vo);
        // SDK get-checkrule-scheduling-list END
    }

    public static void getOrgCheckRuleList() {
        // SDK get-org-check-rule-list START
        //创建请求的参数
        CheckWorkRuleListVO vo = new CheckWorkRuleListVO();
        //设置获取规则类型
        vo.setCheckType("0");
        //设置获取第几页
        vo.setCurrentPage("1");
        //设置每页数量
        vo.setPageSize("100");
        //调用接口
        CheckWorkApi api = QwSdkUtil.getInter(CheckWorkApi.class);
        api.getOrgCheckRuleList(QwSdkUtil.getCacheToken(), vo);
        // SDK get-org-check-rule-list END
    }

    public static void getCheckFixedRuleDataList() {
        // SDK get-check-fixed-rule-data-list START
        //创建请求的参数
        CheckWorkInfoListVO vo = new CheckWorkInfoListVO();
        //设置规则id
        vo.setCheckWorkId("a601091be0d1875ce0321b9ca5009dbb");
        //设置获取规则类型
        vo.setCheckType("0");
        //设置开始时间
        vo.setStartTime("20180526003700");
        //设置结束时间
        vo.setEndTime("20180626233700");
        //设置获取第几页
        vo.setCurrentPage("1");
        //设置每页数量
        vo.setPageSize("100");
        //调用接口
        CheckWorkApi api = QwSdkUtil.getInter(CheckWorkApi.class);
        api.getCheckFixedRuleDataList(QwSdkUtil.getCacheToken(), vo);
        // SDK get-check-fixed-rule-data-list END
    }

    public static void getCheckDetailDataList() {
        // SDK get-check-detail-data-list START
        //创建请求的参数
        CheckWorkDailyListVO vo = new CheckWorkDailyListVO();
        //设置规则id
        vo.setCheckWorkId("a601091be0d1875ce0321b9ca5009dbb");
        //设置开始时间
        vo.setStartTime("20180526003700");
        //设置结束时间
        vo.setEndTime("20180626233700");
        //设置获取第几页
        vo.setCurrentPage("1");
        //设置每页数量
        vo.setPageSize("100");

        //调用接口
        CheckWorkApi api = QwSdkUtil.getInter(CheckWorkApi.class);
        api.getCheckDetailDataList(QwSdkUtil.getCacheToken(), vo);
        // SDK get-check-detail-data-list END
    }

    public static void getCheckWorkRepByDate(){
        // SDK get-check-work-rep-by-date START
        //创建请求的参数
        CheckWorkRepVO vo = new CheckWorkRepVO();
        //设置开始时间
        vo.setStartTime("2018-07-01");
        //设置结束时间
        vo.setEndTime("2018-07-04");
        //设置获取第几页
        vo.setCurrentPage("1");
        //设置每页数量
        vo.setPageSize("100");

        //调用接口
        CheckWorkApi api = QwSdkUtil.getInter(CheckWorkApi.class);
        api.getCheckWorkRepByDate(QwSdkUtil.getCacheToken(), vo);
        // SDK get-check-work-rep-by-date END
    }

    public static void main(String[] args) {
        //测试方法
        //registerVirtualService();
        //addVirtualDevices();
        //delVirtualDevices();
        //addVirtualDeviceCheck();
        //getCheckRuleSchedulingList();
        //getOrgCheckRuleList();
        //getCheckFixedRuleDataList();
		 getCheckDetailDataList();
       //getCheckWorkRepByDate();
	}

}
