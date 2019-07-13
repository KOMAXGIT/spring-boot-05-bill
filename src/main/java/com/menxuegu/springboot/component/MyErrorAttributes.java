package com.menxuegu.springboot.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**\
 * 自定义数据进行响应
 */
//向改容器中添加组件
@Component
public class MyErrorAttributes extends DefaultErrorAttributes  {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String,Object> map= super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company","KOMAX");
        return map;
    }
}
