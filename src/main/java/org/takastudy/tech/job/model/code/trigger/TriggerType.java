package org.takastudy.tech.job.model.code.trigger;

public enum TriggerType {
	
	SINGLE(0,"íPàÍ"),
	SOME(1,"ï°êî"),
	NONE(2,"Ç»Çµ");
	
	
	private int code;
	private String value;
	
	private TriggerType(int _code,String _value){
		this.code = _code;
		this.value = _value;
	}
	
	public static TriggerType getType(int value){
		for(TriggerType rm : TriggerType.values()){
			if(rm.code == value){
				return rm;
			}
		}
		return TriggerType.NONE;
	}
	
	public String toString(){
		return this.value;
	}

}
