package org.openwebflow.mgr.mybatis.entity;

import org.openwebflow.mgr.common.SimpleDelegationEntity;

import java.sql.Date;

public class SqlDelegationEntity extends SimpleDelegationEntity {
    long _id;

    Date _opTime;

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public Date getOpTime() {
        return _opTime;
    }

    public void setOpTime(Date opTime) {
        _opTime = opTime;
    }
}
