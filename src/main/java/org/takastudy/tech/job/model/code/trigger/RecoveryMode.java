package org.takastudy.tech.job.model.code.trigger;

public enum RecoveryMode {
	
	CODITION(0,"������"),
	RECOVERYCONDITION(1,"����������"),
	NONE(2,"�Ȃ�");
	
	
	private int code;
	private String value;
	
	private RecoveryMode(int _code,String _value){
		this.code = _code;
		this.value = _value;
	}
	
	public static RecoveryMode getType(int value){
		for(RecoveryMode rm : RecoveryMode.values()){
			if(rm.code == value){
				return rm;
			}
		}
		return RecoveryMode.NONE;
	}
	
	public String toString(){
		return this.value;
	}

}
