package org.takastudy.tech.job.model.code.trigger;

public enum TriggerPriority {
	
	NONE(0,"–¢•ª—Ş"),
	INFO(1,"î•ñ"),
	WARNING(2,"Œx"),
	LIGHT(3,"Œy“x‚ÌáŠQ"),
	ERROR(4,"d“x‚ÌáŠQ"),
	CRITICAL(5,"’v–½“I‚ÈáŠQ")
	;
	
	
	public int code;
	private String value;
	
	private TriggerPriority(int _code,String _value){
		this.code = _code;
		this.value = _value;
	}
	
	public static TriggerPriority getType(int value){
		for(TriggerPriority rm : TriggerPriority.values()){
			if(rm.code == value){
				return rm;
			}
		}
		return TriggerPriority.NONE;
	}
	
	public String toString(){
		return this.value;
	}


}
