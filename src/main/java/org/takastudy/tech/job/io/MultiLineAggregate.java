package org.takastudy.tech.job.io;

import java.util.List;

import org.springframework.batch.item.file.transform.LineAggregator;

public class MultiLineAggregate<T> implements LineAggregator<List<T>> {
	
	private LineAggregator<T> line;
	@Override
	public String aggregate(List<T> item) {
		StringBuilder build = new StringBuilder();
		item.forEach(elm -> {
			build.append(line.aggregate(elm));
			build.append(System.lineSeparator());
			}
		);
		return build.toString();
	}
	
	public void setLineAggregate(LineAggregator<T> lagg){
		this.line = lagg;
	}

}
