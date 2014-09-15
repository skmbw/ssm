package com.vteba.user.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vteba.sequence.SequenceGenerator;
import com.vteba.user.model.User;
import com.vteba.user.service.UserService;
import com.vteba.web.action.BaseAction;

/**
 * 用户操作相关的action控制器。
 * @author yinlei
 * 2014-2-25 上午11:19:42
 */
@RequestMapping("/user")//拦截所有的url中含有/user的请求
@Controller//标识这是一个Spirng MVC的控制器
public class UserAction extends BaseAction {
	
	@Autowired//将UserService的实现注入进来，也可使用setter方法注入
	private UserService userServiceImpl;
	
	@Autowired
	private SequenceGenerator sequenceGenerator;
	
	/**
	 * 初始化页面信息
	 * @return 逻辑视图名
	 * @throws Exception
	 */
	@RequestMapping("/initial")
	public String initial(Map<String, Object> map) {
		List<User> userList = userServiceImpl.queryForList(null);
		// 方法Map/ModelMap参数中的数据会自动推送到视图页面，供jsp等使用
		map.put("userList", userList);//将userList放入视图中，供jsp使用
		return "/user/initial";
	}
	
	/**
	 * 跳转到新增页面
	 * @return 新增页面逻辑视图
	 * @throws Exception
	 */
	@RequestMapping("/add")
	public String add() {
		return "user/add";
	}
	
	/**
	 * 执行实际的新增操作
	 * @param model 要新增的数据
	 * @return 新增页面逻辑视图
	 * @throws Exception
	 */
	//spring mvc会自动将表单中的数据绑定到变量model中，表单的name属性要和User中的属性名一致
	@RequestMapping("/doAdd")
	public String doAdd(User model) {
		model.setCreateDate(new Date());
		model.setId(sequenceGenerator.nextSeqLong());
		userServiceImpl.save(model);
		return "user/add";
	}
	
	/**
	 * 查看用户详情页面。
	 * @param model 查询参数，携带用户ID
	 * @return 用户详情页
	 */
	@RequestMapping("/detail")
	public String detail(User model, Map<String, Object> maps) {
		model = userServiceImpl.get(model.getId());
		maps.put("model", model);//将model放入视图中，供页面视图使用
		return "user/detail";
	}
	
	/**
	 * 跳转到编辑用户信息页面
	 * @param model 查询参数，携带用户ID
	 * @return 编辑用户页面
	 */
	@RequestMapping("/edit")
	public String edit(User model, Map<String, Object> maps) {
		model = userServiceImpl.get(model.getId());
		maps.put("model", model);//将model放入视图中，供页面视图使用
		return "user/edit";
	}
	
	/**
	 * 更新用户信息
	 * @param model 要更新的用户信息，含有用户ID信息
	 * @return 跳到列表页面
	 */
	@RequestMapping("/update")
	public String update(User model, Map<String, Object> maps) {
		userServiceImpl.updateById(model);
		maps.put("model", model);//将model放入视图中，供页面视图使用
		return "user/detail";
	}
	
	/**
	 * ajax删除用户信息
	 * @param model 要删除的用户，用户ID不为空
	 */
	@RequestMapping("/delete")
	@ResponseBody//将数据以json的形式返回
	public void delete(User model) {
		userServiceImpl.deleteById(model.getId());
		renderText("删除成功！");
	}
}
