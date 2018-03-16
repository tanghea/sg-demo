package com.yonyou.sg.basedoc.basedata.dao.impl;

import com.yonyou.cpu.commons.dao.annotation.TableDesc;
import com.yonyou.sg.basedoc.basedata.dao.DemoDAO;
import com.yonyou.sg.basedoc.basedata.domain.Demo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by ck on 2018\3\13 0013.
 */
@Repository
@TableDesc(nameSpace="demo", tableName="Demo")
public class DemoDAOImpl extends GenericExtCKDAOImpl<Demo,Long> implements DemoDAO{
    @Override
    public Long savedata(Demo vo) {
        insert("save", vo);
        return vo.getId();
    }

    @Override
    public int delete(List<Long> pks) {
        return deleteBatch("delete", pks);
    }

    @Override
    public int update(Demo vo){
       return update("update", vo);
    }

    @Override
    public List<Map<String, Integer>> getStateItems(Demo vo) {
        List<Map<String,Integer>> stateItemsList = this.queryForList("getStateItems", vo);
        return stateItemsList;
    }
}
