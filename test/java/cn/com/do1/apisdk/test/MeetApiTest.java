package cn.com.do1.apisdk.test;


import cn.com.do1.apisdk.inter.MeetApi;
import cn.com.do1.apisdk.inter.SdkAnnotation;
import cn.com.do1.apisdk.inter.meet.req.vo.ApiMeetGetMeetDetailVO;
import cn.com.do1.apisdk.inter.meet.req.vo.ApiMeetGetMeetingListVO;
import cn.com.do1.apisdk.inter.meet.req.vo.ApiMeetGetRoomDetailVO;
import cn.com.do1.apisdk.inter.meet.req.vo.ApiMeetGetRoomListVO;
import cn.com.do1.apisdk.inter.meet.resp.vo.ApiMeetingPager;
import cn.com.do1.apisdk.inter.meet.resp.vo.MeetDetailVO;
import cn.com.do1.apisdk.inter.meet.resp.vo.RegionList;
import cn.com.do1.apisdk.inter.meet.resp.vo.RoomPager;
import cn.com.do1.apisdk.inter.meet.resp.vo.RoomVO;
import cn.com.do1.apisdk.inter.meet.resp.vo.SummaryDetailVO;
import cn.com.do1.apisdk.util.JSONUtil;
import cn.com.do1.apisdk.util.QwSdkUtil;


public class MeetApiTest {
    @SdkAnnotation("get_meeting_detail")
    public static void getMeetingDetail() {
        // SDK get_meeting_detail START
        ApiMeetGetMeetDetailVO paramVO = new ApiMeetGetMeetDetailVO();
        // 会议id
        paramVO.setMeetingId("a37c7d78-13d6-42b8-90a8-134b73624dfd");
        // 查询评论的页码
        paramVO.setCurrentPage(1);
        // 查询评论的分页大小
        paramVO.setSize(10);
        // 是否返回人员的邮箱和手机号：0-否，1-是
        paramVO.setIsShowPrivacy(1);
        MeetApi meetApi = QwSdkUtil.getInter(MeetApi.class);
        // 调用接口
        MeetDetailVO resultVO = meetApi.getMeetingDetail(QwSdkUtil.getCacheToken(), paramVO);
        // 打印输出结果
        System.out.println(JSONUtil.stringify(resultVO));
        // SDK get_meeting_detail END
    }

    @SdkAnnotation("get_meeting_summary_info")
    public static void getMeetingSummaryInfo() {
        // SDK get_meeting_summary_info START
        ApiMeetGetMeetDetailVO paramVO = new ApiMeetGetMeetDetailVO();
        // 会议id
        paramVO.setMeetingId("a37c7d78-13d6-42b8-90a8-134b73624dfd");
        // 查询评论的页码
        paramVO.setCurrentPage(1);
        // 查询评论的分页大小
        paramVO.setSize(10);
        // 是否返回人员的邮箱和手机号：0-否，1-是
        paramVO.setIsShowPrivacy(1);
        MeetApi meetApi = QwSdkUtil.getInter(MeetApi.class);
        // 调用接口
        SummaryDetailVO resultVO = meetApi.getMeetingSummaryInfo(QwSdkUtil.getCacheToken(), paramVO);
        // 打印输出结果
        System.out.println(JSONUtil.stringify(resultVO));
        // SDK get_meeting_summary_info END
    }

    @SdkAnnotation("get_room_detail")
    public static void getRoomDetail(){
        // SDK get_room_detail START
        ApiMeetGetRoomDetailVO paramVO = new ApiMeetGetRoomDetailVO();
        // 会议室id
        paramVO.setRoomId("8416cd62-771d-4d75-ac91-2f507014b0e4");
        /** 查询该会议室某段时间内的会议，所用到的时间段, 输入满足yyyy-MM-dd **/
        // 开始时间，实际为 yyyy-MM-dd 00:00:00
        paramVO.setStartTime("2018-12-23");
        // 结束时间，实际为 yyyy-MM-dd 23:59:59
        paramVO.setEndTime("2018-12-27");

        MeetApi meetApi = QwSdkUtil.getInter(MeetApi.class);
        // 调用接口
        RoomVO resultVO = meetApi.getRoomDetail(QwSdkUtil.getCacheToken(), paramVO);
        // 打印输出结果
        System.out.println(JSONUtil.stringify(resultVO));
        // SDK get_room_detail END
    }

    @SdkAnnotation("ajax_region_list")
    public static void ajaxRegionList() {
        // SDK ajax_region_list START
        MeetApi meetApi = QwSdkUtil.getInter(MeetApi.class);
        // 调用接口
        RegionList resultList = meetApi.ajaxRegionList(QwSdkUtil.getCacheToken());
        // 打印输出结果
        System.out.println(JSONUtil.stringify(resultList));
        // SDK ajax_region_list END
    }

    @SdkAnnotation("ajax_region_rooms")
    public static void ajaxRegionRooms() {
        // SDK ajax_region_rooms START
        ApiMeetGetRoomListVO paramVO = new ApiMeetGetRoomListVO();
        // 区域id
        paramVO.setRegionId("b17efb43-292e-4cc9-ac5d-0b46bce059c4");
        // 查询会议室的页码
        paramVO.setCurrentPage(1);
        // 查询会议室的分页大小
        paramVO.setSize(10);

        MeetApi meetApi = QwSdkUtil.getInter(MeetApi.class);
        // 调用接口
        RoomPager resultVO = meetApi.ajaxRegionRooms(QwSdkUtil.getCacheToken(), paramVO);
        // 打印输出结果
        System.out.println(JSONUtil.stringify(resultVO));
        // SDK ajax_region_rooms END
    }

    @SdkAnnotation("get_meeting_list")
    public static void getMeetingList() {
        // SDK get_meeting_list START
        ApiMeetGetMeetingListVO paramVO = new ApiMeetGetMeetingListVO();
        // 分页页码
        paramVO.setCurrentPage(1);
        // 分页大小
        paramVO.setPageSize(10);
        // 更新时间下限
        paramVO.setStartTime("2020-01-01");
        // 更新时间上限
        paramVO.setEndTime("2020-01-31");
        // 需要返回人员的邮箱和手机号
        paramVO.setIsShowPrivacy(1);

        MeetApi meetApi = QwSdkUtil.getInter(MeetApi.class);
        // 调用接口
        ApiMeetingPager resultVO = meetApi.getMeetingList(QwSdkUtil.getCacheToken(), paramVO);
        // 打印输出结果
        System.out.println(JSONUtil.stringify(resultVO));
        // SDK get_meeting_list END
    }

    public static void main(String[] args) {
//        getMeetingDetail();
//        getMeetingSummaryInfo();
//        getRoomDetail();
//        ajaxRegionList();
//        ajaxRegionRooms();
        getMeetingList();
    }

}