package com.alpha.sns.controller;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SNSController {

    private final String topicArn = "arn:aws:sns:ap-south-1:927105565293:alpha-topic";

    @Autowired
    private AmazonSNSClient amazonSNSClient;

    @GetMapping("/addSubscription/{email}")
    public String addSubscription(@PathVariable String email) {
        SubscribeRequest subscribeRequest = new SubscribeRequest(topicArn, "email", email);
        amazonSNSClient.subscribe(subscribeRequest);
        return "Subscription request is pending.To confirm the subscription check your mail :" + email;
    }

    @GetMapping("/sendNotification")
    public String publishToTopic(){
        PublishRequest publishRequest = new PublishRequest(topicArn,getEmailBody(),"Notification : Network connectivity issue");
        amazonSNSClient.publish(publishRequest);
        return "Notification Sent Successfully !!";
    }

    private String getEmailBody(){
        return "Dear Employee Connection is down. Kindly try after sometime";
    }

}
