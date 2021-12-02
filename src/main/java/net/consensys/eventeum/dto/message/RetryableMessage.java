package net.consensys.eventeum.dto.message;

public  interface RetryableMessage {
  
     java.lang.Integer getRetries();
    
    void setRetries(java.lang.Integer numRetries);
  }