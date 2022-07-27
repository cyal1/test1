package cn.com.do1.apisdk.test;

import cn.com.do1.apisdk.inter.TagApi;
import cn.com.do1.apisdk.inter.rep.vo.ApiGetTagListResultVO;
import cn.com.do1.apisdk.inter.rep.vo.ApiGetTagRefListResultVO;
import cn.com.do1.apisdk.inter.rep.vo.ApiTagRefListResultVO;
import cn.com.do1.apisdk.inter.rep.vo.ApiTagResultVO;
import cn.com.do1.apisdk.inter.addressbook.vo.InterfaceTag;
import cn.com.do1.apisdk.inter.req.vo.TagRefVO;
import cn.com.do1.apisdk.util.JSONUtil;
import cn.com.do1.apisdk.util.QwSdkUtil;

public class TagApiTest {


	public static void searchTag() {
		// SDK get-tag-data START
		TagApi api = QwSdkUtil.getInter(TagApi.class);
		ApiGetTagListResultVO result = api.searchTag(QwSdkUtil.getCacheToken());
		System.out.println(JSONUtil.stringify(result));
		// SDK get-tag-data END
	}

	public static void addTag() {
		// SDK add-tag START
		InterfaceTag tag = new InterfaceTag();
		// 标签名称 名称不得大于32个字
		tag.setTagName("道一");
		// 标签排序号 排序号 1 - 2147483647 默认200
		tag.setShowNum(2);
		// 标签使用范围 1.后台 3.手机端+后台 5.手机端 默认1.后台
		tag.setRang(1);
		// 标签状态 1.启用 0.禁用 默认1.启用
		tag.setStatus(1);
		TagApi api = QwSdkUtil.getInter(TagApi.class);
		ApiTagResultVO result = api.addTag(QwSdkUtil.getCacheToken(), tag);
		System.out.println(JSONUtil.stringify(result));
		// SDK add-tag END
	}

	public static void updateTag() {
		// SDK update-tag START
		/**
		 * 根据wxTagId进行标签的编辑，推荐使用此方式
		 */
		InterfaceTag tag = new InterfaceTag();
		// 标签微信ID
		tag.setWxTagId("110");
		// 标签名称 名称不得大于32个字
		tag.setTagName("企微云1");
		// 标签排序号 排序号 1 - 2147483647 默认200
		tag.setShowNum(2);
		// 标签使用范围 1.后台 3.手机端+后台 5.手机端 默认1.后台
		tag.setRang(1);
		// 标签状态 1.启用 0.禁用 默认1.启用
		tag.setStatus(1);
		// 推荐使用此方法管理标签
		TagApi api = QwSdkUtil.getInter(TagApi.class);
		ApiTagResultVO result = api.updateTag(QwSdkUtil.getCacheToken(), tag);
		System.out.println(JSONUtil.stringify(result));

		/**
		 * 根据id进行标签的编辑，无wxTagId时使用此方式
		 */
		InterfaceTag tag2 = new InterfaceTag();
		// 标签ID
		tag2.setId("d497aa213test9dad920c58");
		// 标签名称 名称不得大于32个字
		tag2.setTagName("企微云2");
		// 标签排序号 排序号 1 - 2147483647 默认200
		tag2.setShowNum(2);
		// 标签使用范围 1.后台 3.手机端+后台 5.手机端 默认1.后台
		tag2.setRang(1);
		// 标签状态 1.启用 0.禁用 默认1.启用
		tag2.setStatus(1);
		// 无wxTagId时，使用id管理标签
		ApiTagResultVO result2 = api.updateTag(QwSdkUtil.getCacheToken(),tag2);
		System.out.println(JSONUtil.stringify(result2));
		// SDK update-tag END
	}

	public static void delTag() {
		// SDK del-tag START
		/**
		 * 根据wxTagId删除标签信息，推荐使用此方式，
		 */
		// 标签微信ID
		TagRefVO vo = new TagRefVO();
		vo.setWxTagId("41");
		TagApi api = QwSdkUtil.getInter(TagApi.class);
		String result = api.delTag(QwSdkUtil.getCacheToken(), vo);
		System.out.println(result);
		/**
		 * 根据id删除标签信息，无wxTagId时使用此方式
		 */
		// 标签id
		TagRefVO vo2 = new TagRefVO();
		vo2.setId("e5399b7ad30d48438f8f8ac6c7d6dc37");
		String result2 = api.delTag(QwSdkUtil.getCacheToken(), vo2);
		System.out.println(result2);
		// SDK del-tag END
	}

	public static void searchTagRef() {
		// SDK get-tag-ref START
		/**
		 * 根据wxTagId获取标签下成员（人员和部门），推荐使用此方式
		 */
		// 标签微信ID
		String wxTagId = "271";
		TagApi api = QwSdkUtil.getInter(TagApi.class);
		ApiGetTagRefListResultVO result = api.searchTagRef(QwSdkUtil.getCacheToken(), wxTagId,null);
		System.out.println(JSONUtil.stringify(result));
		/**
		 * 根据id获取标签下成员，无wxTagId时使用此方式
		 */
		// 标签ID
		String id = "bf0422750511111eea35e4";
		ApiGetTagRefListResultVO result2 = api.searchTagRef(QwSdkUtil.getCacheToken(), null, id);
		System.out.println(JSONUtil.stringify(result2));
		// SDK get-tag-ref END
	}

	public static void addTagRef() {
		// SDK add-tag-ref START
		/**
		 * 根据wxTagId添加标签成员（人员和部门），推荐使用此方式
		 */
		TagRefVO vo = new TagRefVO();
		// 标签微信ID
		vo.setWxTagId("39");
		// 用户微信ID 需要传入字符串数组
		vo.setWxUserIdList(new String[]{"123","641","640"});
		// 部门微信ID 需要传入字符串数组
		vo.setWxDeptIdList(new String[]{"123","641","640"});
		TagApi api = QwSdkUtil.getInter(TagApi.class);
		ApiTagRefListResultVO result = api.addTagRef(QwSdkUtil.getCacheToken(), vo);
		System.out.println(JSONUtil.stringify(result));
		/**
		 * 根据id添加标签成员（人员和部门），无wxTagId时使用此方式
		 */
		TagRefVO refVO = new TagRefVO();
		// 标签ID
		refVO.setId("8d64d38138001380001ad9ab7625");
		// 用户微信ID 需要传入字符串数组
		refVO.setWxUserIdList(new String[]{"123","641","640"});
		// 部门微信ID 需要传入字符串数组
		refVO.setWxDeptIdList(new String[]{"123","641","640"});
		TagApi api2 = QwSdkUtil.getInter(TagApi.class);
		ApiTagRefListResultVO result2 = api2.addTagRef(QwSdkUtil.getCacheToken(), refVO);
		System.out.println(JSONUtil.stringify(result2));
		// SDK add-tag-ref END
	}

	public static void delTagRef() {
		// SDK del-tag-ref START
		/**
		 * 根据wxTagId删除标签成员（人员和部门），推荐使用此方式
		 */
		TagRefVO vo = new TagRefVO();
		// 标签微信ID
		vo.setWxTagId("39");
		// 用户微信ID 需要传入字符串数组
		vo.setWxUserIdList(new String[]{"123","641","640"});
		// 部门微信ID 需要传入字符串数组
		vo.setWxDeptIdList(new String[]{"123","641","640"});
		TagApi api = QwSdkUtil.getInter(TagApi.class);
		ApiTagRefListResultVO result = api.delTagRef(QwSdkUtil.getCacheToken(), vo);
		System.out.println(JSONUtil.stringify(result));
		/**
		 * 根据id删除标签成员（人员和部门），无wxTagId时使用此方式
		 */
		TagRefVO refVO = new TagRefVO();
		// 标签ID
		refVO.setId("8d64d38138001380001ad9ab7625");
		// 用户微信ID 需要传入字符串数组
		refVO.setWxUserIdList(new String[]{"123","641","640"});
		// 部门微信ID 需要传入字符串数组
		refVO.setWxDeptIdList(new String[]{"123","641","640"});
		TagApi api2 = QwSdkUtil.getInter(TagApi.class);
		ApiTagRefListResultVO result2 = api2.delTagRef(QwSdkUtil.getCacheToken(), refVO);
		System.out.println(JSONUtil.stringify(result2));
		// SDK del-tag-ref END
	}

	public static void getTagInfoByMemberId() {
		// SDK get-tag-info START
		/**
		 * 通过用户Id查询所有标签
		 */
		String wxUserId ="linrongqing";
		String wxDeptId = "694";
		TagApi api = QwSdkUtil.getInter(TagApi.class);

		ApiGetTagListResultVO result1 = api.getTagInfoByUserId(QwSdkUtil.getCacheToken(),wxUserId);
		System.out.println(JSONUtil.stringify(result1));
		/**
		 * 通过部门Id查询所有标签
		 */
		ApiGetTagListResultVO result2 = api.getTagInfoByDeptId(QwSdkUtil.getCacheToken(),wxDeptId);
		System.out.println(JSONUtil.stringify(result2));
		// SDK get-tag-info END
	}

	public static void main(String[] args) {
//		 searchTag();
//		 addTag();
		getTagInfoByMemberId();
//		 updateTag();
//		 delTag();
//		 searchTagRef();
//		 addTagRef();
//		 delTagRef();
	}
}
