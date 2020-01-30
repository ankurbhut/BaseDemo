package com.ankur.basedemo.network.model;

import com.google.gson.annotations.SerializedName;

public class BaseResponse<T>{

	@SerializedName("data")
	private T data;

	@SerializedName("status")
	private boolean status;

	@SerializedName("errorMsg")
	private String errorMsg;

	public void setData(T data){
		this.data = data;
	}

	public T getData(){
		return data;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	public void setErrorMsg(String errorMsg){
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg(){
		return errorMsg;
	}

    @Override
    public String toString() {
        return "BaseResponse{" +
                "data=" + data +
                ", status=" + status +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}