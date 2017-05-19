package org.takastudy.tech.job.model.code.trigger;

public enum CorrelationMode {
	ENABLE(0,"���ׂĂ̏�Q"),
	DISABLE(1,"�^�O�̈�v������Q"),
	NONE(2,""),
	;
	
	
	private int code;
	private String value;
	
	private CorrelationMode(int _code,String _value){
		this.code = _code;
		this.value = _value;
	}
	
	public static CorrelationMode getType(int value){
		for(CorrelationMode rm : CorrelationMode.values()){
			if(rm.code == value){
				return rm;
			}
		}
		return CorrelationMode.NONE;
	}
	
	public String toString(){
		return this.value;
	}


}
