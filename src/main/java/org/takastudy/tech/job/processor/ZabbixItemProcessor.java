package org.takastudy.tech.job.processor;

import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.takastudy.tech.job.model.ZabbixItem;
import org.takastudy.tech.job.model.ZabbixTemplate;

public class ZabbixItemProcessor implements ItemProcessor<ZabbixTemplate, List<ZabbixItem>>{

	@Override
	public List<ZabbixItem> process(ZabbixTemplate item) throws Exception {
		
		item.getItems().stream().forEach(elm -> elm.setTemplateName(item.getName()));
		
		return item.getItems();
		
		
	}

}
