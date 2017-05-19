package org.takastudy.tech.job.model.code.item;

import org.takastudy.tech.job.model.code.trigger.TriggerPriority;

public enum ItemType {
	ZABBIXAGENT(0,"Zabbixエージェント"),
	SNMPV1(1,"SNMPv1エージェント"),
	ZABBIXTRAPPER(2,"Zabbixトラッパー"),
	SIMPLE(3,"シンプルチェック"),
	SNMPV2(4,"SNMPv2エージェント"),
	ZABBIXIN(5,"Zabbixインターナル"),
	SNMPV3(6,"SNMPv3エージェント"),
	ZABBIXAGENTACTIVE(7,"Zabbixエージェント（アクティブ）"),
	ZABBIXAGREE(8,"Zabbixアグリゲート"),
	WEBITEM(9,"Webシナリオ"),
	EXTCHECK(10,"外部チェック"),
	DBMON(11,"データベースモニタ"),
	IPMI(12,"IPMIエージェント"),
	SSH(13,"SSHエージェント"),
	TELNET(14,"TELNETエージェント"),
	CALC(15,"計算"),
	JMX(16,"JMXエージェント"),
	SNMPTRAP(17,"SNMPトラップ"),
	NONE(99,""),
	;
	
	
	private int code;
	private String value;
	
	private ItemType(int _code,String _value){
		this.code = _code;
		this.value = _value;
	}
	
	public static ItemType getType(int value){
		for(ItemType rm : ItemType.values()){
			if(rm.code == value){
				return rm;
			}
		}
		return ItemType.NONE;
	}
	
	public String toString(){
		return this.value;
	}

}
