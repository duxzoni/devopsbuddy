package com.devopsbuddy.backend.service;

import com.devopsbuddy.web.domain.frontend.FeedbackPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

public abstract class AbstractEmailService implements EmailService{

    @Value("${default.to.adress}")
    private String defaultToAdress;

    protected SimpleMailMessage prepareSimpleMailMessageFromFeedbackPojo(FeedbackPojo feedbackPojo){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(defaultToAdress);
        message.setFrom(feedbackPojo.getEmail());
        message.setSubject("[DevOps Buddy]: Feedback Received from " + feedbackPojo.getFirstName() + " " + feedbackPojo.getLastName() + "!");
        message.setText(feedbackPojo.getFeedback());
        return message;
    }

    @Override
    public void sendFeedbackEmail(FeedbackPojo feedbackPojo) {
        sendGenericEmailMessage(prepareSimpleMailMessageFromFeedbackPojo(feedbackPojo));
    }
}
