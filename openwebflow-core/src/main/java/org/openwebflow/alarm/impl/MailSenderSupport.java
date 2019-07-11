package org.openwebflow.alarm.impl;

public class MailSenderSupport {
    protected String _authPassword;

    protected String _authUserName;

    protected String _mailFrom;

    protected String _serverHost;

    protected int _serverPort;

    public String getAuthPassword() {
        return _authPassword;
    }

    public void setAuthPassword(String authPassword) {
        _authPassword = authPassword;
    }

    public String getAuthUserName() {
        return _authUserName;
    }

    public void setAuthUserName(String authUserName) {
        _authUserName = authUserName;
    }

    public String getMailFrom() {
        return _mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        _mailFrom = mailFrom;
    }

    public String getServerHost() {
        return _serverHost;
    }

    public void setServerHost(String serverHost) {
        _serverHost = serverHost;
    }

    public int getServerPort() {
        return _serverPort;
    }

    public void setServerPort(int serverPort) {
        _serverPort = serverPort;
    }

}