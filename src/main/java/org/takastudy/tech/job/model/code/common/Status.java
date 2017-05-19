package org.takastudy.tech.job.model.code.common;

public enum Status {
	ENABLE(0,"—LŒø"),
	DISABLE(1,"–³Œø"),
	NONE(2,""),
	;
	
	
	private int code;
	private String value;
	
	private Status(int _code,String _value){
		this.code = _code;
		this.value = _value;
	}
	
	public static Status getType(int value){
		for(Status rm : Status.values()){
			if(rm.code == value){
				return rm;
			}
		}
		return Status.NONE;
	}
	
	public String toString(){
		return this.value;
	}


}
