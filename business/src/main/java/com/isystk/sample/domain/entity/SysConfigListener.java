package com.isystk.sample.domain.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * 
 */
public class SysConfigListener implements EntityListener<SysConfig> {

    @Override
    public void preInsert(SysConfig entity, PreInsertContext<SysConfig> context) {
    }

    @Override
    public void preUpdate(SysConfig entity, PreUpdateContext<SysConfig> context) {
    }

    @Override
    public void preDelete(SysConfig entity, PreDeleteContext<SysConfig> context) {
    }

    @Override
    public void postInsert(SysConfig entity, PostInsertContext<SysConfig> context) {
    }

    @Override
    public void postUpdate(SysConfig entity, PostUpdateContext<SysConfig> context) {
    }

    @Override
    public void postDelete(SysConfig entity, PostDeleteContext<SysConfig> context) {
    }
}