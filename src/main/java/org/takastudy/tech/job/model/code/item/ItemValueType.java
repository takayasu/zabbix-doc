package org.takastudy.tech.job.model.code.item;

public enum ItemValueType {
	FLOAT(0,"���l�i���������j"),
	CHAR(1,"������"),
	LOG(2,"���O"),
	NUM(3,"���l�i�����j"),
	TEXT(4,"�e�L�X�g"),
	NONE(99,""),
	;
	
	
	private int code;
	private String value;
	
	private ItemValueType(int _code,String _value){
		this.code = _code;
		this.value = _value;
	}
	
	public static ItemValueType getType(int value){
		for(ItemValueType rm : ItemValueType.values()){
			if(rm.code == value){
				return rm;
			}
		}
		return ItemValueType.NONE;
	}
	
	public String toString(){
		return this.value;
	}


}
