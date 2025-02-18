package org.openwebflow.mgr.mybatis.entity;

import org.openwebflow.mgr.common.SimpleActivityPermissionEntity;
import org.springframework.util.StringUtils;

public class SqlActivityPermissionEntity extends SimpleActivityPermissionEntity {
    private String _grantedGroupString;

    private String _grantedUserString;

    public String getGrantedGroupString() {
        return _grantedGroupString;
    }

    public void setGrantedGroupString(String grantedGroupString) {
        _grantedGroupString = grantedGroupString;
        super.setGrantedGroupIds(StringUtils.delimitedListToStringArray(grantedGroupString, ";"));
    }

    public String getGrantedUserString() {
        return _grantedUserString;
    }

    public void setGrantedUserString(String grantedUserString) {
        _grantedUserString = grantedUserString;
        super.setGrantedUserIds(StringUtils.delimitedListToStringArray(grantedUserString, ";"));
    }

    @Override
    public void setGrantedGroupIds(String[] grantedGroupIds) {
        super.setGrantedGroupIds(grantedGroupIds);
        setGrantedGroupString(StringUtils.arrayToDelimitedString(grantedGroupIds, ";"));
    }

    @Override
    public void setGrantedUserIds(String[] grantedUserIds) {
        super.setGrantedUserIds(grantedUserIds);
        setGrantedUserString(StringUtils.arrayToDelimitedString(grantedUserIds, ";"));
    }
}
