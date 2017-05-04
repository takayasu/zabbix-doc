package org.takastudy.tech.job.processor;

import org.springframework.batch.item.ItemProcessor;
import org.takastudy.tech.job.model.ZabbixTrigger;

public class ZabbixTriggerProcessor  implements ItemProcessor<ZabbixTrigger, ZabbixTrigger>{

	@Override
	public ZabbixTrigger process(ZabbixTrigger item) throws Exception {
		return item;
	}

}
