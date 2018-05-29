package com.lcxs.utils;

public class JsonResult {
	    /**状态*/
	    private int result;
	    /**对应状态的消息*/
	    private String message;
	    /**具体业务数据*/
	    private Object data;
	    /**此构造方法应用于data为null的场景*/
	    public JsonResult(){
	        this.result=1;//1
	        this.message="OK";
	    }
	    /**有具体业务数据返回时,使用此构造方法*/
	    public JsonResult(Object data){
	        this();
	        this.data=data;
	    }
	    public Object getData() {
	        return data;
	    }
	    public int getResult() {
	        return result;
	    }
	    public String getMessage() {
	        return message;
	    }
	    public void setResult(int result) {
	        this.result = result;
	    }
	    public void setMessage(String str){
	        this.message=str;
	    }
}
