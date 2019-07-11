package org.openwebflow.mgr.mybatis.entity;

public class SqlMembershipEntity {
    String _groupId;

    int _id;

    String _userId;

    public String getGroupId() {
        return _groupId;
    }

    public void setGroupId(String groupId) {
        _groupId = groupId;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        _id = id;
    }

    public String getUserId() {
        return _userId;
    }

    public void setUserId(String userId) {
        _userId = userId;
    }
}
