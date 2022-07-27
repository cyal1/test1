package cn.com.do1.apisdk.test;

import cn.com.do1.apisdk.inter.NewsApi;
import cn.com.do1.apisdk.inter.SdkAnnotation;
import cn.com.do1.apisdk.inter.news.req.vo.DynamicDetailParamVO;
import cn.com.do1.apisdk.inter.news.req.vo.DynamicListParamVO;
import cn.com.do1.apisdk.inter.news.req.vo.NewsJsonVO;
import cn.com.do1.apisdk.inter.news.resp.vo.ApiNewsGetDynamicTypeResultVO;
import cn.com.do1.apisdk.inter.news.resp.vo.DynamicDetailVO;
import cn.com.do1.apisdk.inter.news.resp.vo.DynamicPager;
import cn.com.do1.apisdk.util.JSONUtil;
import cn.com.do1.apisdk.util.QwSdkUtil;

public class NewsApiTest {

    @SdkAnnotation("get_dynamic_type")
    public static void getDynamicTypeList(){
        // SDK get_dynamic_type START
    	NewsApi newApi = QwSdkUtil.getInter(NewsApi.class);
        ApiNewsGetDynamicTypeResultVO resultVO = newApi.getDynamicTypeList(QwSdkUtil.getCacheToken());
        System.out.println(JSONUtil.stringify(resultVO));
        // SDK get_dynamic_type END
    }

    @SdkAnnotation("add_news")
    public static void addNews(){
        // SDK add_news START
        NewsJsonVO newsJsonVO = new NewsJsonVO();
        //设置后台账号,若为空，则默认为超管
        newsJsonVO.setCreator("123456");
        //设置是否开启外部分享
        newsJsonVO.setIsOpen(1);
        //设置外部分享是否显示评论
        newsJsonVO.setShareComment("1");
        //设置可见范围
        newsJsonVO.setRange("1");
        //设置用户账号id
        newsJsonVO.setUserIds("f4045fdbea8d7818f7da1c9c7ce99576");
        //设置公告类型id
        newsJsonVO.setDynamicTypeId("357d6d49a67040208eb91509b47a402a");
        //设置公告标题
        newsJsonVO.setTitle("这是标题title");
        //设置公告摘要
        newsJsonVO.setSummary("这是摘要summary");
        //设置公告正文
        newsJsonVO.setEditorContent("这是正文content");
        //设置封面图片地址
        newsJsonVO.setCoverImage("http://shp.qpic.cn/bizmp/ck4hSGq23RiaoFuE4XGD9OdXCicJBSDKsGZ8TF152Pt5icWRnPGfZKicWA/100");
        //设置是否允许评论：0可以，1不可以
        newsJsonVO.setIsComment("0");
        //设置是否将封面图片显示在正文中：0显示，1不显示
        newsJsonVO.setIsDisplayCoverImage("0");
        //设置是否保密，0非保密，1为保密
        newsJsonVO.setIsSecret("0");
        //设置是否推送消息:1-发送；0-不发
        newsJsonVO.setIsSendMsg(1);
        //设置消息类型(0: 图文消息,  1: 第三方页面)
        newsJsonVO.setMsgType(0);
        //设置第三方页面地址
        newsJsonVO.setThirdPartUrl("https://www.baidu.com/");
        //设置第三方提示语
        newsJsonVO.setThirdPartTips("第三方提示语");
        NewsApi newApi = QwSdkUtil.getInter(NewsApi.class);
        newApi.addNews(QwSdkUtil.getCacheToken(),newsJsonVO);
        // SDK add_news END
    }

    @SdkAnnotation("ajax_dynamic_list")
    public static void ajaxDynamicList(){
        // SDK ajax_dynamic_list START
        DynamicListParamVO paramVO = new DynamicListParamVO();
        //新闻类型id，可传空
        paramVO.setDynamicTypeId("");
        //查询新闻的页码
        paramVO.setCurrentPage(1);
        //查询新闻的分页大小
        paramVO.setPageSize(10);
        NewsApi newsApi = QwSdkUtil.getInter(NewsApi.class);
        // 调用接口
        DynamicPager resultVO = newsApi.ajaxDynamicList(QwSdkUtil.getCacheToken(), paramVO);
        // 打印输出结果
        System.out.println(JSONUtil.stringify(resultVO));
        // SDK ajax_dynamic_list END
    }

    @SdkAnnotation("get_dynamic_detail")
    public static void getDynamicDetail(){
        // SDK get_dynamic_detail START
        DynamicDetailParamVO paramVO = new DynamicDetailParamVO();
        //新闻id
        paramVO.setDynamicInfoId("30a3e9b2-285d-4f52-87b5-ca0781a039b3");
        //查询点赞列表的页码
        paramVO.setPraiseCurrPage(1);
        //查询点赞列表的分页大小
        paramVO.setPraisePageSize(10);
        //查询已阅列表的页码
        paramVO.setReadCurrPage(1);
        //查询已阅列表的分页大小
        paramVO.setReadPageSize(10);
        //查询未阅列表的页码
        paramVO.setUnreadCurrPage(1);
        //查询未阅列表的分页大小
        paramVO.setUnreadPageSize(10);
        //查询评论列表的页码
        paramVO.setCommentCurrPage(1);
        //查询评论列表的分页大小
        paramVO.setCommentPageSize(10);
        NewsApi newsApi = QwSdkUtil.getInter(NewsApi.class);
        // 调用接口
        DynamicDetailVO resultVO = newsApi.getDynamicDetail(QwSdkUtil.getCacheToken(), paramVO);
        // 打印输出结果
        System.out.println(JSONUtil.stringify(resultVO));
        // SDK get_dynamic_detail END
    }

    public static void main(String[] args) {
        //getDynamicTypeList();
        addNews();
//        ajaxDynamicList();
//        getDynamicDetail();
    }
}
