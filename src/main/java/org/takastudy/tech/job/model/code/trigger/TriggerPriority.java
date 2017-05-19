package org.takastudy.tech.job.model.code.trigger;

public enum TriggerPriority {
	
	NONE(0,"������"),
	INFO(1,"���"),
	WARNING(2,"�x��"),
	LIGHT(3,"�y�x�̏�Q"),
	ERROR(4,"�d�x�̏�Q"),
	CRITICAL(5,"�v���I�ȏ�Q")
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
