package com.imooc.shenzhouyh.controller;

import com.imooc.shenzhouyh.web.mvc.RequestMapping;
import com.imooc.shenzhouyh.web.mvc.RequestParam;

/**
 * @author: yinhao
 * @email:286817442@qq.com
 * @date:2019/10/18
 * @time:15:23
 * @desciption
 */
public class SalaryController {
	@RequestMapping("/test") public Integer getSalary(
			@RequestParam("name") String name,
			@RequestParam("experience") String experience) {
		return 10000;
	}
}
