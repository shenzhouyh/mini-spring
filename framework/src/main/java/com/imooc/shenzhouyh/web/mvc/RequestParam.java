package com.imooc.shenzhouyh.web.mvc;

import java.lang.annotation.*;

/**
 * @author: yinhao
 * @email:286817442@qq.com
 * @date:2019/10/18
 * @time:9:11
 * @desciption
 */
@Documented @Retention(RetentionPolicy.RUNTIME) @Target(ElementType.PARAMETER) public @interface RequestParam {
	String value();
}
