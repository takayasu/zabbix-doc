package org.takastudy.tech.job.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.takastudy.tech.job.model.code.common.Status;
import org.takastudy.tech.job.model.code.item.Delta;
import org.takastudy.tech.job.model.code.item.ItemType;
import org.takastudy.tech.job.model.code.item.ItemValueType;
import org.takastudy.tech.job.model.code.item.MultiPlierFlag;

@XmlRootElement(name = "item")
public class ZabbixItem extends ZabbixDocModel {
	private String name;
	private String type;
	private String snmpCommunity;
	private String multiplier;
	private String snmpOid;
	private String key;
	private String delay;
	private String history;
	private String trends;
	private String status;
	private String valueType;
	private String allowedHost;
	private String units;
	private String delta;
	private String formula;
	
	private String templateName;
	
	public static final String[] NAMES = {"templateName","name","type","key",
						"valueType","units","multiplier","formula","delay",
						"history","trends","delta","status","snmpOid","snmpCommunity"};
	
	public String toString(){
		StringBuilder build = new StringBuilder();
		build.append(templateName);
		build.append(",");
		build.append(name);
		build.append(",");
		build.append(type);
		build.append(",");
		build.append(",");
		build.append(key);
		build.append(",");
		build.append(valueType);
		build.append(",");
		build.append(",");
		build.append(units);
		build.append(",");
		build.append(multiplier);
		build.append(",");
		build.append(formula);
		build.append(",");
		build.append(delta);
		build.append(",");
		build.append(delay);
		build.append(",");
		build.append(history);
		build.append(",");
		build.append(trends);
		build.append(",");
		build.append(snmpOid);
		build.append(",");
		build.append(snmpCommunity);
		build.append(",");
		build.append(status);
		
		
		return build.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return ItemType.getType(Integer.parseInt(type)).toString();
	}

	public void setType(String type) {
		this.type = type;
	}

	@XmlElement(name="snmp_community")
	public String getSnmpCommunity() {
		return snmpCommunity;
	}

	public void setSnmpCommunity(String snmpCommunity) {
		this.snmpCommunity = snmpCommunity;
	}

	public String getMultiplier() {
		return MultiPlierFlag.getType(Integer.parseInt(multiplier)).toString();
	}

	public void setMultiplier(String multiplier) {
		this.multiplier = multiplier;
	}

	@XmlElement(name="snmp_oid")
	public String getSnmpOid() {
		return snmpOid;
	}

	public void setSnmpOid(String snmpOid) {
		this.snmpOid = snmpOid;
	}

	public String getKey() {
		return "\""+convertCommma(key)+"\"";
	}
	
	private String convertCommma(String org){
		return org.replaceAll(",", ";");
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getDelay() {
		return delay;
	}

	public void setDelay(String delay) {
		this.delay = delay;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getTrends() {
		return trends;
	}

	public void setTrends(String trends) {
		this.trends = trends;
	}

	public String getStatus() {
		return Status.getType(Integer.parseInt(status)).toString();
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@XmlElement(name="value_type")
	public String getValueType() {
		return ItemValueType.getType(Integer.parseInt(valueType)).toString();
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public String getAllowedHost() {
		return allowedHost;
	}

	public void setAllowedHost(String allowedHost) {
		this.allowedHost = allowedHost;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getDelta() {
		return Delta.getType(Integer.parseInt(delta)).toString();
	}

	public void setDelta(String delta) {
		this.delta = delta;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public String getTemplateName(){
		return templateName;
	}
	
	public void setTemplateName(String _name) {
		this.templateName = _name;
	}
	
	
	

}
