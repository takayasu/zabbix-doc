package org.takastudy.tech.job.model.code.item;

public enum Delta {
	ASIS(0,"なし"),
	SECOND(1,"差分/時間"),
	SIMPLE(2,"差分"),
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
