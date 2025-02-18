package org.openwebflow.mgr.common;

import org.openwebflow.identity.UserDetailsEntity;

import java.util.HashMap;
import java.util.Map;

public class SimpleUserDetailsEntity extends UserDetailsEntitySupport {
    private Map<String, Object> _map = new HashMap<String, Object>();

    public SimpleUserDetailsEntity() {
    }

    public SimpleUserDetailsEntity(UserDetailsEntity src) {
        super.copyProperties(src);
    }

    public SimpleUserDetailsEntity(String userId, String nickName, String email, String mobilePhoneNumber) {
        _map.put(STRING_PROPERTY_USER_ID, userId);
        _map.put(STRING_PROPERTY_EMAIL, email);
        _map.put(STRING_PROPERTY_MOBILE_PHONE_NUMBER, mobilePhoneNumber);
        _map.put(STRING_PROPERTY_NICK_NAME, nickName);
    }

    public String getEmail() {
        return getProperty(STRING_PROPERTY_EMAIL);
    }

    public void setEmail(String email) {
        setProperty(STRING_PROPERTY_EMAIL, email);
    }

    public String getMobilePhoneNumber() {
        return getProperty(STRING_PROPERTY_MOBILE_PHONE_NUMBER);
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        setProperty(STRING_PROPERTY_MOBILE_PHONE_NUMBER, mobilePhoneNumber);
    }

    public String getNickName() {
        return getProperty(STRING_PROPERTY_NICK_NAME);
    }

    public void setNickName(String nickName) {
        setProperty(STRING_PROPERTY_NICK_NAME, nickName);
    }

    public <T> T getProperty(String name) {
        return (T) _map.get(name);
    }

    @Override
    public String[] getPropertyNames() {
        return _map.keySet().toArray(new String[0]);
    }

    public String getUserId() {
        return getProperty(STRING_PROPERTY_USER_ID);
    }

    public void setUserId(String userId) {
        setProperty(STRING_PROPERTY_USER_ID, userId);
    }

    public <T> void setProperty(String name, T value) {
        _map.put(name, value);
    }

    @Override
    public String toString() {
        return _map.toString();
    }
}