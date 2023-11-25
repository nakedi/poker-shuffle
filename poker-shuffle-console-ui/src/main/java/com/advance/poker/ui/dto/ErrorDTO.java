package com.advance.poker.ui.dto;

import java.io.Serializable;

public class ErrorDTO implements Serializable {

    private String message;
    private String exception;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public static class Builder{
        private String message;
        private String exception;
        private Builder(){
            super();
        }
        public static Builder forError(){
            return new Builder();
        }
        public Builder withMessage(String message){
            this.message = message;
            return this;
        }
        public Builder withException(String exception){
            this.exception = exception;
            return this;
        }
        public ErrorDTO build(){
            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setException(this.exception);
            errorDTO.setMessage(this.message);
            return errorDTO;
        }
    }
}
