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
public class TStaffListener implements EntityListener<TStaff> {

    @Override
    public void preInsert(TStaff entity, PreInsertContext<TStaff> context) {
    }

    @Override
    public void preUpdate(TStaff entity, PreUpdateContext<TStaff> context) {
    }

    @Override
    public void preDelete(TStaff entity, PreDeleteContext<TStaff> context) {
    }

    @Override
    public void postInsert(TStaff entity, PostInsertContext<TStaff> context) {
    }

    @Override
    public void postUpdate(TStaff entity, PostUpdateContext<TStaff> context) {
    }

    @Override
    public void postDelete(TStaff entity, PostDeleteContext<TStaff> context) {
    }
}