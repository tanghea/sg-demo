package com.yonyou.sg.basedoc.basedata.dao.impl;

import com.yonyou.cpu.commons.dao.GenericDAOImpl;

import java.util.List;

/**
 * Created by ck on 2017/5/25.
 */
public class GenericExtCKDAOImpl<E, PK> extends GenericDAOImpl<E, PK> {
    protected int insertBatch(String statement, List<E> entity) {
        return getSqlSession().insert(addNameSpace(statement), entity);
    }
    protected int updateBatch(String statement, List<E> entity) {
        return getSqlSession().update(addNameSpace(statement), entity);
    }
    protected int deleteBatch(String statement, List<PK> entity) {
        return getSqlSession().update(addNameSpace(statement), entity);
    }

}
