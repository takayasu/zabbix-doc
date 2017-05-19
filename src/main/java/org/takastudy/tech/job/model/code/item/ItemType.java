package org.takastudy.tech.job.model.code.item;

import org.takastudy.tech.job.model.code.trigger.TriggerPriority;

public enum ItemType {
	ZABBIXAGENT(0,"Zabbix�G�[�W�F���g"),
	SNMPV1(1,"SNMPv1�G�[�W�F���g"),
	ZABBIXTRAPPER(2,"Zabbix�g���b�p�["),
	SIMPLE(3,"�V���v���`�F�b�N"),
	SNMPV2(4,"SNMPv2�G�[�W�F���g"),
	ZABBIXIN(5,"Zabbix�C���^�[�i��"),
	SNMPV3(6,"SNMPv3�G�[�W�F���g"),
	ZABBIXAGENTACTIVE(7,"Zabbix�G�[�W�F���g�i�A�N�e�B�u�j"),
	ZABBIXAGREE(8,"Zabbix�A�O���Q�[�g"),
	WEBITEM(9,"Web�V�i���I"),
	EXTCHECK(10,"�O���`�F�b�N"),
	DBMON(11,"�f�[�^�x�[�X���j�^"),
	IPMI(12,"IPMI�G�[�W�F���g"),
	SSH(13,"SSH�G�[�W�F���g"),
	TELNET(14,"TELNET�G�[�W�F���g"),
	CALC(15,"�v�Z"),
	JMX(16,"JMX�G�[�W�F���g"),
	SNMPTRAP(17,"SNMP�g���b�v"),
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
