package com.imooc.shenzhouyh.web.mvc;

import java.lang.annotation.*;

/**
 * @author: yinhao
 * @email:286817442@qq.com
 * @date:2019/10/17
 * @time:20:31
 * @desciption
 */
@Documented @Retention(RetentionPolicy.RUNTIME) @Target(ElementType.METHOD) public @interface RequestMapping {
	String value();
}
