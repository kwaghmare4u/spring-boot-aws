package com.alpha.sns.configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AwsSNSConfig {

    private static final String ACCESS_KEY_ID = "AKIAIVQF7JX2RDNT4YUQ";
    private static final String SECRET_ACCESS_KEY = "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";


    @Primary
    @Bean
    public AmazonSNSClient getAmazonSNSClient(){
        return (AmazonSNSClient) AmazonSNSClientBuilder.
                standard().
                withRegion(Regions.AP_SOUTH_1).
                withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(
                        ACCESS_KEY_ID,SECRET_ACCESS_KEY)))
                .build();

    }


}
