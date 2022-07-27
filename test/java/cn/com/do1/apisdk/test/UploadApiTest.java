package cn.com.do1.apisdk.test;

import java.io.File;

import cn.com.do1.apisdk.inter.SdkAnnotation;
import cn.com.do1.apisdk.inter.UploadApi;
import cn.com.do1.apisdk.inter.rep.vo.UploadResultVO;
import cn.com.do1.apisdk.util.JSONUtil;
import cn.com.do1.apisdk.util.QwSdkUtil;
import cn.com.do1.apisdk.util.WxAgentUtil;

/**
 * 附件文件上传sdk
 * @author chenhandong
 *
 */
public class UploadApiTest {
    @SdkAnnotation("upload")
    public static void uploadApi(){
    	// SDK upload START
        UploadApi uploadApi = QwSdkUtil.getInter(UploadApi.class);
        UploadResultVO resultVO = uploadApi.upload(QwSdkUtil.getCacheToken(), new File("d:/1.png"),"qixiaowei",WxAgentUtil.getFormCode(),true);
        System.out.println(JSONUtil.stringify(resultVO));
        // SDK upload END
    }


    public static void main(String[] args) {
        uploadApi();
    }
}
