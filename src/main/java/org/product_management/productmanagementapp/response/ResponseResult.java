package org.product_management.productmanagementapp.response;

import java.util.List;

public class ResponseResult<T> {
    private int status;
    private String message;
    private List<T> data;

    public ResponseResult() { }

    public ResponseResult(int status, String message, List<T> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
    
}
