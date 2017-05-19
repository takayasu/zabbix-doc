package org.takastudy.tech.job.model.code.item;

public enum ItemValueType {
	FLOAT(0,"数値（浮動小数）"),
	CHAR(1,"文字列"),
	LOG(2,"ログ"),
	NUM(3,"数値（整数）"),
	TEXT(4,"テキスト"),
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
