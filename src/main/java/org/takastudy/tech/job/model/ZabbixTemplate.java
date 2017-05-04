package org.takastudy.tech.job.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "template")
public class ZabbixTemplate {
	private String template;
	private String name;
	

	private List<ZabbixItem> items;

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElementWrapper(name="items")
	@XmlElements({
		@XmlElement(name="item",type=ZabbixItem.class)
	})
	public List<ZabbixItem> getItems() {
		return items;
	}

	public void setItems(List<ZabbixItem> items) {
		this.items = items;
	}
	
	public String toString(){
	
		StringBuilder build = new StringBuilder();
		for(ZabbixItem item : getItems()){
			build.append(name);
			build.append(",");
			build.append(item);
			build.append(System.lineSeparator());
		}
		
		return build.toString();
		
	}
	
	

}
