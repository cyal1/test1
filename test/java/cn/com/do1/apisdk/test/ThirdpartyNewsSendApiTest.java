package cn.com.do1.apisdk.test;


import cn.com.do1.apisdk.inter.SdkAnnotation;
import cn.com.do1.apisdk.inter.ThirdpartyNewsSendApi;
import cn.com.do1.apisdk.inter.Thirdpartynewssend.vo.SendNewsVO;
import cn.com.do1.apisdk.inter.Thirdpartynewssend.vo.SendTextVO;
import cn.com.do1.apisdk.util.JSONUtil;
import cn.com.do1.apisdk.util.QwSdkUtil;

public class ThirdpartyNewsSendApiTest {

    @SdkAnnotation("send-text-message")
    public static void sendTextMessage(){
        // SDK send-text-message-data START
        SendTextVO sendTextVO = new SendTextVO();
        //设置应用为dynamic，即新闻公告
        sendTextVO.setAgentCode("dynamic");
        //设置特定部门 多个部门用|隔开
        sendTextVO.setDepaId("6bcdc9");
        //设置用户ID，多个用户用|隔开
        sendTextVO.setWxUserId("18321215943");
        sendTextVO.setText("这是一条文本消息推送测试1.0");
        System.out.println(JSONUtil.stringify(sendTextVO));
        ThirdpartyNewsSendApi sendNewsApi = QwSdkUtil.getInter(ThirdpartyNewsSendApi.class);
        sendNewsApi.sendTextMessage(QwSdkUtil.getCacheToken(),sendTextVO);
        // SDK send-text-message-data END
    }

    @SdkAnnotation("send-news-message")
    public static void sendNewsMessage(){
        // SDK send-pic-message-data START
        SendNewsVO sendNewsVO = new SendNewsVO();
        //设置应用为dynamic，即新闻公告
        sendNewsVO.setAgentCode("dynamic");
        //设置部门为空 多个部门用|隔开
        sendNewsVO.setDepaId("6bcdc904-3843-4ff4-acd0-824be1304847");
        //设置标题
        sendNewsVO.setTitle("标题");
        //设置正文
        sendNewsVO.setSummary("正文");
        //设置用户id 多个用户用|隔开
        sendNewsVO.setWxUserId("18321215943");
        //点击后跳转的链接
        sendNewsVO.setUrl("www.baidu.com");
        //设置图片地址
        sendNewsVO.setPicurl("http://img1.imgtn.bdimg.com/it/u=1047640764,1894277665&fm=21&gp=0.jpg");
        ThirdpartyNewsSendApi sendNewsApi = QwSdkUtil.getInter(ThirdpartyNewsSendApi.class);
        sendNewsApi.sendNewsMessage(QwSdkUtil.getCacheToken(),sendNewsVO);
        // SDK send-pic-message-data END
    }
    public static void main(String[] args) {
//        sendTextMessage();
        sendNewsMessage();
    }
}
