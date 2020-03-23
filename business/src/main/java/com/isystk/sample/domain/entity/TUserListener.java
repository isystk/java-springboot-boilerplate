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
public class TUserListener implements EntityListener<TUser> {

    @Override
    public void preInsert(TUser entity, PreInsertContext<TUser> context) {
    }

    @Override
    public void preUpdate(TUser entity, PreUpdateContext<TUser> context) {
    }

    @Override
    public void preDelete(TUser entity, PreDeleteContext<TUser> context) {
    }

    @Override
    public void postInsert(TUser entity, PostInsertContext<TUser> context) {
    }

    @Override
    public void postUpdate(TUser entity, PostUpdateContext<TUser> context) {
    }

    @Override
    public void postDelete(TUser entity, PostDeleteContext<TUser> context) {
    }
}