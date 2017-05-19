package org.takastudy.tech.job.model.code.item;

public enum MultiPlierFlag {
	NONE(0,""),
	USE(1,"—˜—p"),
	;
	
	
	private int code;
	private String value;
	
	private MultiPlierFlag(int _code,String _value){
		this.code = _code;
		this.value = _value;
	}
	
	public static MultiPlierFlag getType(int value){
		for(MultiPlierFlag rm : MultiPlierFlag.values()){
			if(rm.code == value){
				return rm;
			}
		}
		return MultiPlierFlag.NONE;
	}
	
	public String toString(){
		return this.value;
	}


}
