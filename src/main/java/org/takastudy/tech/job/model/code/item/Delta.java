package org.takastudy.tech.job.model.code.item;

public enum Delta {
	ASIS(0,"‚È‚µ"),
	SECOND(1,"·•ª/ŠÔ"),
	SIMPLE(2,"·•ª"),
	NONE(99,""),
	;
	
	
	private int code;
	private String value;
	
	private Delta(int _code,String _value){
		this.code = _code;
		this.value = _value;
	}
	
	public static Delta getType(int value){
		for(Delta rm : Delta.values()){
			if(rm.code == value){
				return rm;
			}
		}
		return Delta.NONE;
	}
	
	public String toString(){
		return this.value;
	}

}
