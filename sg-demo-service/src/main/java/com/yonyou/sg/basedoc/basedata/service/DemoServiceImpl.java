package com.yonyou.sg.basedoc.basedata.service;

import com.alibaba.fastjson.JSONObject;
import com.yonyou.cpu.commons.domain.PageBean;
import com.yonyou.sg.basedoc.basedata.api.IDemoService;
import com.yonyou.sg.basedoc.basedata.dao.DemoDAO;
import com.yonyou.sg.basedoc.basedata.domain.Demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by ck on 2018\3\13 0013.
 */
@Service
public class DemoServiceImpl implements IDemoService {
    // 日志
    private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);
    @Autowired
    private DemoDAO dao;

    @Override
    public JSONObject pageQuery(PageBean pagebean, Demo criteria) {
        logger.error("--专业技术系列--查询分页开始");
        JSONObject result = new JSONObject();

        try{
            PageBean<Demo> rePageBean = dao.pageQuery(criteria,pagebean);
            List<Map<String, Integer>> stateItems = dao.getStateItems(criteria);

            result.put("status","1");//状态 1 成功， 0 失败
            result.put("msg","查询数据成功");
            JSONObject data =new JSONObject();
//            data.put("arrange",expertMajorRange);//将专业范围显示在下拉列狂里面
            if(rePageBean != null ){
                data.put("pageIndex",rePageBean.getPageNo());
                data.put("pageSize",rePageBean.getPageSize());
                data.put("totalPage",rePageBean.getTotalPage());
                data.put("totalCount",rePageBean.getTotalCount());
//                int t= rePageBean.getData()==null? 0:rePageBean.getData().length;
                data.put("result", rePageBean.getData());
                data.put("stateItems", stateItems);
            }else{
                data.put("result","{}");
            }
            result.put("data",data);
            logger.info("pageQuery查询结果 " + result.toString());
        }catch (Exception ex){
            result.put("status","0");//状态 1 成功， 0 失败
            result.put("msg","查询数据出错");
            logger.error("查询分页出错 pageQuery" + ex.getMessage());
        }
        return result;
    }

    @Override
    public Long savedata(Demo vo) {
        Long id = vo.getId();
        if(vo.getId() == null){
            id = dao.savedata(vo);
        }
        else{
           dao.update(vo);
        }
        return id;
    }

    @Override
    public int delete(List<Long> pks) {
        return dao.delete(pks);
    }

    @Override
    public int update(Demo vo) {
        return dao.update(vo);
    }
}
