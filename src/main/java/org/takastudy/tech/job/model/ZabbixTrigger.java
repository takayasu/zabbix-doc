package org.takastudy.tech.job.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.takastudy.tech.job.model.code.common.Status;
import org.takastudy.tech.job.model.code.trigger.CorrelationMode;
import org.takastudy.tech.job.model.code.trigger.ManualClose;
import org.takastudy.tech.job.model.code.trigger.RecoveryMode;
import org.takastudy.tech.job.model.code.trigger.TriggerPriority;
import org.takastudy.tech.job.model.code.trigger.TriggerType;

@XmlRootElement(name = "trigger")
public class ZabbixTrigger extends ZabbixDocModel {
	private String expression;
	private String recoveryMode;
	private String recoveryExpression;
	private String name;
	private String correlationMode;
	private String correlationTag;
	private String url;
	private String status;
	private String priority;
	private String description;
	private String type;
	private String manualClose;
	private String dependencies;
	private String tags;

	public static final String[] NAMES = { "name", "type","expression", "recoveryMode", "recoveryExpression", "status"
			,"priority", "description", "manualClose", "correlationMode", "correlationTag", "dependencies", "tags" };

	public String getExpression() {
		return "\"" + convertCommma(expression) + "\"";
	}
	
	private String convertCommma(String org){
		return org.replaceAll(",", ";");
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	@XmlElement(name = "recovery_mode")
	public String getRecoveryMode() {
		return RecoveryMode.getType(Integer.parseInt(recoveryMode)).toString();
	}

	public void setRecoveryMode(String recoveryMode) {
		this.recoveryMode = recoveryMode;
	}

	@XmlElement(name = "recovery_expression")
	public String getRecoveryExpression() {
		return "\"" + recoveryExpression + "\"";
	}

	public void setRecoveryExpression(String recoveryExpression) {
		this.recoveryExpression = recoveryExpression;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "correlation_mode")
	public String getCorrelationMode() {
		return CorrelationMode.getType(Integer.parseInt(correlationMode)).toString();
	}

	public void setCorrelationMode(String correlationMode) {
		this.correlationMode = correlationMode;
	}

	@XmlElement(name = "correlation_tag")
	public String getCorrelationTag() {
		return correlationTag;
	}

	public void setCorrelationTag(String correlationTag) {
		this.correlationTag = correlationTag;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getStatus() {
		return Status.getType(Integer.parseInt(status)).toString();
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPriority() {
		return TriggerPriority.getType(Integer.parseInt(priority)).toString();
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return TriggerType.getType(Integer.parseInt(type)).toString();
	}

	public void setType(String type) {
		this.type = type;
	}

	@XmlElement(name = "manual_close")
	public String getManualClose() {
		return ManualClose.getType(Integer.parseInt(manualClose)).toString();
	}

	public void setManualClose(String manualClose) {
		this.manualClose = manualClose;
	}

	public String getDependencies() {
		return dependencies;
	}

	public void setDependencies(String dependencies) {
		this.dependencies = dependencies;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

}
