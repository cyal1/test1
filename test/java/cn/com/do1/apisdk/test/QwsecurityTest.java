package cn.com.do1.apisdk.test;

import cn.com.do1.apisdk.inter.Qwsecurity;
import cn.com.do1.apisdk.inter.rep.vo.GetTokenResult;
import cn.com.do1.apisdk.util.QwSdkUtil;

public class QwsecurityTest {
	
	public static void getToken(){
		// SDK get-token START
		Qwsecurity sec = QwSdkUtil.getInter(Qwsecurity.class);
		GetTokenResult result = sec.getToken("qw34f6f67bb6df48e0a4037b1cfb03888c",
				"YjUwYmUwMmItNzU4MS00N2U3LWIwMTgtN2I4MTkzYjY0NWUw");
		System.out.println(result.getToken());
		// SDK get-token END
	}
	
	public static void main(String args[])throws Exception{
		getToken();
	}
}
