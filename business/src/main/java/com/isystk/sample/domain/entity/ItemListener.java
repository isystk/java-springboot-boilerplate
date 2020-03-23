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
public class ItemListener implements EntityListener<Item> {

    @Override
    public void preInsert(Item entity, PreInsertContext<Item> context) {
    }

    @Override
    public void preUpdate(Item entity, PreUpdateContext<Item> context) {
    }

    @Override
    public void preDelete(Item entity, PreDeleteContext<Item> context) {
    }

    @Override
    public void postInsert(Item entity, PostInsertContext<Item> context) {
    }

    @Override
    public void postUpdate(Item entity, PostUpdateContext<Item> context) {
    }

    @Override
    public void postDelete(Item entity, PostDeleteContext<Item> context) {
    }
}