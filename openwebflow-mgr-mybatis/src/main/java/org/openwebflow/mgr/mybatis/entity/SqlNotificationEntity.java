package org.openwebflow.mgr.mybatis.entity;

import java.sql.Date;

public class SqlNotificationEntity {
    int _id;

    Date _opTime;

    String _taskId;

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        _id = id;
    }

    public Date getOpTime() {
        return _opTime;
    }

    public void setOpTime(Date opTime) {
        _opTime = opTime;
    }

    public String getTaskId() {
        return _taskId;
    }

    public void setTaskId(String taskId) {
        _taskId = taskId;
    }
}
