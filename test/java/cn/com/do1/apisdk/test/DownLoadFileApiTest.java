package cn.com.do1.apisdk.test;

import cn.com.do1.apisdk.inter.rep.vo.DownloadResultVO;
import cn.com.do1.apisdk.util.HttpDownloadUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DownLoadFileApiTest {

    public static File downLoadFileApi() throws IOException {
        // SDK download-file START
        Map<String, String> params = new HashMap<String, String>();
        params.put("corpId", "wx05ab253814890c89");
//        params.put("fileUrl", "/upload/img/b17efb43292e4cc9ac5d0b46bce059c4/20190705/00118727ba5e4b3f8fe25db998420059.jpeg");
        params.put("fileUrl", "/upload/img/b17efb43292e4cc9ac5d0b46bce059c4/20171025/0000e36aaaca43aebe3efc3b3c0c682c.jpeg");
        // 文件保存的路径
        String savePath = "D:/temp";
        // 返回一个文件File
        File file = HttpDownloadUtil.sendGet(savePath, params);
        return file;
        // SDK download-file END
    }

    public static DownloadResultVO downLoadFileBatchApi() throws IOException {
        // SDK download-file-batch START
        List<String> fileUrls = new ArrayList<String>();
        fileUrls.add("/upload/img/b17efb43292e4cc9ac5d0b46bce059c4/20171025/0000e36aaaca43aebe3efc3b3c0c682c.jpeg");
        fileUrls.add("/upload/file/b17efb43292e4cc9ac5d0b46bce059c4/20190619/00042ab9cd7d4caab11be9286dc6519b.png");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("corpId", "wx05ab253814890c89");
        params.put("fileUrls", fileUrls);
        // 文件保存的路径
        String savePath = "D:/temp";
        DownloadResultVO downloadResultVO = HttpDownloadUtil.sendPost(savePath, params);
        // 获取文件下载结果
        String resultString = downloadResultVO.getResultString();
        System.out.println(resultString);
        // 下载结果对象，包含files与resultString
        return downloadResultVO;
        // SDK download-file-batch END
    }


    public static void main(String[] args) throws IOException {
//        downLoadFileApi();
        downLoadFileBatchApi();
    }
}
