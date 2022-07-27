package cn.com.do1.apisdk.test;

import cn.com.do1.apisdk.inter.DeptApi;
import cn.com.do1.apisdk.inter.addressbook.vo.InterfaceDept;
import cn.com.do1.apisdk.inter.rep.vo.ApiDeptResultVO;
import cn.com.do1.apisdk.inter.rep.vo.ApiGetDeptListResultVO;
import cn.com.do1.apisdk.inter.rep.vo.ApigetAllDeptResultVo;
import cn.com.do1.apisdk.inter.req.vo.DeptListReqVo;
import cn.com.do1.apisdk.util.JSONUtil;
import cn.com.do1.apisdk.util.QwSdkUtil;

public class DeptApiTest {

	public static void addDept() {
		// SDK add-depart START
		InterfaceDept deptInfo = new InterfaceDept();
		// 部门名称
		deptInfo.setDepartmentName("企小微");
		// 父级部门编号(顶级部门此字段为空)
		deptInfo.setParentDepart("");
		// 显示顺序
		deptInfo.setShowOrder(1);
		// 可见权限 1：全公司（可以看到全公司通讯录） 2：仅本部门（可以看到同一部门下所有子组织通讯录）
		// 3：仅子部门（可以看到所在子部门及下属子组织通讯录）
		deptInfo.setPermission("3");
		// 部门负责人账号，多个负责人以" |"进行分割
		deptInfo.setReceiveWxUserId("qy_15906191328|khh666");
		DeptApi deptApi = QwSdkUtil.getInter(DeptApi.class);
		ApiDeptResultVO depart = deptApi.addDepart(QwSdkUtil.getCacheToken(),
				deptInfo);
		System.out.println(JSONUtil.stringify(depart));
		// SDK add-depart END
	}

	public static void updateDept() {
		// SDK update-depart START
		InterfaceDept deptInfo = new InterfaceDept();
		// 部门ID
		deptInfo.setId("124432543532453");
		// 部门名称
		deptInfo.setDepartmentName("道一企微云");
		// 父级部门编号(顶级部门此字段为空)
		deptInfo.setParentDepart("fc036-test96d9d");
		// 显示顺序
		deptInfo.setShowOrder(1);
		// 可见权限 1：全公司（可以看到全公司通讯录） 2：仅本部门（可以看到同一部门下所有子组织通讯录）
		// 3：仅子部门（可以看到所在子部门及下属子组织通讯录）
		deptInfo.setPermission("3");
		// 部门负责人账号，多个负责人以" |"进行分割
		deptInfo.setReceiveWxUserId("qyfffff328|fffff6");
		DeptApi deptApi = QwSdkUtil.getInter(DeptApi.class);
		ApiDeptResultVO depart = deptApi.updateDept(QwSdkUtil.getCacheToken(),
				deptInfo);
		System.out.println(JSONUtil.stringify(depart));
		// SDK update-depart END

	}

	public static void delDept() {
		// SDK delete-depart START
		// 部门ID
		String deptId = "14875a140b86d2cf56c579022f8498e0";
		DeptApi deptApi = QwSdkUtil.getInter(DeptApi.class);
		String result = deptApi.deleteDept(QwSdkUtil.getCacheToken(), deptId);
		System.out.println(result);
		// SDK delete-depart END
	}

	public static void getDeptByDeptId() {
		// SDK get-depart-data START
		// 部门ID，多部门以“|”隔开
		String deptIds = "4f3a441ceffff654c3c89|3c7851fffff6f973dbac7c";
		DeptApi deptApi = QwSdkUtil.getInter(DeptApi.class);
		ApiGetDeptListResultVO apiDeptGetResult = deptApi.getDeptByDeptIds(
				QwSdkUtil.getCacheToken(), deptIds);
		System.out.println(JSONUtil.stringify(apiDeptGetResult));
		// SDK get-depart-data END
	}

	public static void getAllDept() {
		// SDK get-depart START
		DeptListReqVo deptListReqVo = new DeptListReqVo();
		DeptApi deptApi = QwSdkUtil.getInter(DeptApi.class);
		//设置当前页数
		deptListReqVo.setCurrentPage("1");
		//设置页面大小
		deptListReqVo.setPageSize("3");
		ApigetAllDeptResultVo apigetAllDeptResultVo = deptApi.getAllDept(
				QwSdkUtil.getCacheToken(), deptListReqVo);
		System.out.println(JSONUtil.stringify(apigetAllDeptResultVo));
		// SDK get-depart END
	}

	public static void main(String[] args) {
		// addDept();
		//updateDept();
		// delDept();
		// getDeptByDeptId();
		getAllDept();
	}
}
