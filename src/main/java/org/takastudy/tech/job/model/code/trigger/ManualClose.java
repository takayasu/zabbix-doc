package org.takastudy.tech.job.model.code.trigger;

public enum ManualClose {

	ENABLE(0,"–³Œø"),
	DISABLE(1,"‰Â”\"),
	NONE(2,""),
	;
	
	
	private int code;
	private String value;
	
	private ManualClose(int _code,String _value){
		this.code = _code;
		this.value = _value;
	}
	
	public static ManualClose getType(int value){
		for(ManualClose rm : ManualClose.values()){
			if(rm.code == value){
				return rm;
			}
		}
		return ManualClose.NONE;
	}
	
	public String toString(){
		return this.value;
	}

	
}
