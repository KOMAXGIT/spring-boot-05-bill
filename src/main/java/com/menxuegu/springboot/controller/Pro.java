package com.menxuegu.springboot.controller;

import com.menxuegu.springboot.dao.ProviderDao;
import com.menxuegu.springboot.entities.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Controller
public class Pro {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    ProviderDao providerDao;

    @GetMapping("/providers")
    public String list(Map<String,Object> map,@RequestParam(value = "providerName",required = false) String providerName) {
        logger.info("供应商列表查询"+providerName);
        Collection<Provider> providers=providerDao.getAll(providerName);
        map.put("providers",providers);
        map.put("providerName",providerName);
        //classpath:/template
        return "provider/list";
    }
    @GetMapping("/provider/{pid}")
    public String view(@PathVariable("pid") Integer pid,
                       @RequestParam(value = "type",defaultValue = "view") String type,
                       Map<String ,Object>map){
        logger.info("查询"+pid);
       Provider  provider= providerDao.getProvider(pid);
       map.put("provider",provider);

      //  return "provider/view";
        //type 为空的时候进入 view type=update 则进去update页面
        return "provider/"+type;
    }
    @PutMapping("/provider")
    public String update(Provider provider){
        logger.info("更改供应商"+provider);
        //更新操作
        providerDao.save(provider);
        return "redirect:providers";
    }
    //前往添加页面
    @GetMapping("/provider")
    public String toAddPage(){
        return "provider/add";
    }
    //添加数据
    @PostMapping("/provider")
    public String Add(Provider provider){
        logger.info("添加供应商");
        //保存数据操作
        providerDao.save(provider);
        return "redirect:/providers";
    }
    @DeleteMapping("/provider/{pid}")
    public String Delete(@PathVariable("pid") Integer pid){
        logger.info("删除操作 "+pid);
        providerDao.delete(pid);
        return "redirect:/providers";
    }
}
