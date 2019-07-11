package org.openwebflow.alarm.impl;

import org.activiti.engine.impl.scripting.JuelScriptEngineFactory;
import org.activiti.engine.task.Task;
import org.h2.util.IOUtils;
import org.openwebflow.alarm.MessageNotifier;
import org.openwebflow.identity.UserDetailsEntity;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;

import javax.script.ScriptEngine;
import java.io.InputStreamReader;

public class MailMessageNotifier implements MessageNotifier, InitializingBean {
    MailSender _mailSender;

    String _messageTemplate;

    Resource _messageTemplateResource;

    String _subject;

    private String _subjectTemplate;

    @Override
    public void afterPropertiesSet() throws Exception {
        _messageTemplate = IOUtils.readStringAndClose(new InputStreamReader(_messageTemplateResource.getInputStream()),
                (int) _messageTemplateResource.contentLength());
    }

    public MailSender getMailSender() {
        return _mailSender;
    }

    public void setMailSender(MailSender mailSender) {
        _mailSender = mailSender;
    }

    public Resource getMessageTemplateResource() {
        return _messageTemplateResource;
    }

    public void setMessageTemplateResource(Resource messageTemplateResource) {
        _messageTemplateResource = messageTemplateResource;
    }

    public String getSubject() {
        return _subject;
    }

    public void setSubject(String subject) {
        _subject = subject;
    }

    public String getSubjectTemplate() {
        return _subjectTemplate;
    }

    public void setSubjectTemplate(String subjectTemplate) {
        _subjectTemplate = subjectTemplate;
    }

    @Override
    public void notify(UserDetailsEntity[] users, Task task) throws Exception {
        for (UserDetailsEntity user : users) {
            if (user == null)
                continue;

            ScriptEngine scriptEngine = new JuelScriptEngineFactory().getScriptEngine();
            scriptEngine.put("user", user);
            scriptEngine.put("task", task);
            String email = user.getProperty(UserDetailsEntity.STRING_PROPERTY_EMAIL);
            if (email != null) {
                _mailSender.sendMail(email, (String) scriptEngine.eval(_subjectTemplate),
                        (String) scriptEngine.eval(_messageTemplate));
            }
        }
    }
}
