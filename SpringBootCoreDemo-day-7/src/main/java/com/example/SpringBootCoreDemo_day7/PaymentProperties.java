package com.example.SpringBootCoreDemo_day7;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("payment-property")
public class PaymentProperties {
    private String type;
    private int retryCount;
    private boolean enabled;
    private int timeout;

    public String getType () {
        return this.type;
    }

    public void setType (String type) {
        this.type = type;
    }

    public int getRetryCount () {
        return this.retryCount;
    }

    public void setRetryCount (int count) {
        this.retryCount = count;
    }

    public boolean isEnabled () {
        return this.enabled;
    }

    public void setEnabled (boolean enabled) {
        this.enabled = enabled;
    }

    public int getTimeout () {
        return this.timeout;
    }

    public void setTimeout (int timeout) {
        this.timeout = timeout;
    }

}
