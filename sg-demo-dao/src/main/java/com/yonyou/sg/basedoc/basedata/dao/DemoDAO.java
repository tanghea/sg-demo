package com.yonyou.sg.basedoc.basedata.dao;

import com.alibaba.fastjson.JSONObject;
import com.yonyou.cpu.commons.dao.GenericDAO;
import com.yonyou.cpu.commons.domain.PageBean;
import com.yonyou.sg.basedoc.basedata.domain.Demo;

import java.util.List;
import java.util.Map;

/**
 * Created by ck on 2018\3\13 0013.
 */
public interface DemoDAO extends GenericDAO<Demo, Long> {
    Long savedata(Demo vo);
    int delete(List<Long> pks);
    int update(Demo vo);
    List<Map<String, Integer>> getStateItems(Demo vo);
}
