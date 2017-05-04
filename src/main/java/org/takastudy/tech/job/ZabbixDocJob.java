package org.takastudy.tech.job;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.takastudy.tech.job.io.MultiLineAggregate;
import org.takastudy.tech.job.model.ZabbixItem;
import org.takastudy.tech.job.model.ZabbixTemplate;
import org.takastudy.tech.job.model.ZabbixTrigger;
import org.takastudy.tech.job.processor.ZabbixItemProcessor;
import org.takastudy.tech.job.processor.ZabbixTriggerProcessor;

@Configuration
@EnableBatchProcessing
public class ZabbixDocJob {

	@Autowired
	private JobBuilderFactory jobs;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean(name = "docgen")
	public Job job() {

		return jobs.get("DocGen4").incrementer(new RunIdIncrementer()).flow(stepItem()).next(stepTrigger()).end()
				.build();
	}

	@SuppressWarnings("unchecked")
	@Bean
	public Step stepItem() {
		return stepBuilderFactory.get("stepItem").<ZabbixTemplate, ZabbixItem>chunk(100).reader(itemReader(null))
				.processor(itemProcessor()).writer(itemWriter(null)).build();
	}

	@SuppressWarnings("unchecked")
	@Bean
	public Step stepTrigger() {
		return stepBuilderFactory.get("stepTrigger").<ZabbixTrigger, ZabbixTrigger>chunk(100).reader(triggerReader(null))
				.processor(triggerProcessor()).writer(triggerWriter(null)).build();
	}

	@StepScope
	@Bean
	public StaxEventItemReader<ZabbixTemplate> itemReader(@Value("#{jobParameters[inputFile]}") String inputFile) {
		StaxEventItemReader<ZabbixTemplate> reader = new StaxEventItemReader<>();

		if(inputFile != null)
			reader.setResource(new FileSystemResource(inputFile));
		reader.setFragmentRootElementName("template");

		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(ZabbixTemplate.class);
		reader.setUnmarshaller(marshaller);

		return reader;
	}

	@SuppressWarnings("rawtypes")
	@Bean
	public ItemProcessor itemProcessor() {
		return new ZabbixItemProcessor();
	}

	@StepScope
	@Bean
	public FlatFileItemWriter<List<ZabbixItem>> itemWriter(@Value("#{jobParameters[outputItemFile]}") String outputFile) {
		FlatFileItemWriter<List<ZabbixItem>> writer = new FlatFileItemWriter<>();

		writer.setLineAggregator(getLineItemAggregator());

		if(outputFile != null)
			writer.setResource(new FileSystemResource(outputFile));

		return writer;
	}

	private LineAggregator<List<ZabbixItem>> getLineItemAggregator() {
		MultiLineAggregate<ZabbixItem> mLAgg = new MultiLineAggregate<>();

		DelimitedLineAggregator<ZabbixItem> agg = new DelimitedLineAggregator<>();

		BeanWrapperFieldExtractor<ZabbixItem> bwf = new BeanWrapperFieldExtractor<>();
		bwf.setNames(ZabbixItem.NAMES);

		agg.setFieldExtractor(bwf);
		mLAgg.setLineAggregate(agg);
		
		return mLAgg;
	}

	@StepScope
	@Bean
	public StaxEventItemReader<ZabbixTrigger> triggerReader(@Value("#{jobParameters[inputFile]}") String inputFile) {
		StaxEventItemReader<ZabbixTrigger> reader = new StaxEventItemReader<>();

		if(inputFile != null)
			reader.setResource(new FileSystemResource(inputFile));
		reader.setFragmentRootElementName("trigger");

		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(ZabbixTrigger.class);
		reader.setUnmarshaller(marshaller);

		return reader;
	}

	@SuppressWarnings("rawtypes")
	@Bean
	public ItemProcessor triggerProcessor() {
		return new ZabbixTriggerProcessor();
	}


	@StepScope
	@Bean
	public FlatFileItemWriter<ZabbixTrigger> triggerWriter(@Value("#{jobParameters[outputTriggerFile]}") String outputFile) {
		FlatFileItemWriter<ZabbixTrigger> writer = new FlatFileItemWriter<>();

		writer.setLineAggregator(getLineTriggerAggregator());

		if(outputFile != null)
			writer.setResource(new FileSystemResource("trigger.txt"));

		return writer;
	}

	private LineAggregator<ZabbixTrigger> getLineTriggerAggregator() {

		DelimitedLineAggregator<ZabbixTrigger> agg = new DelimitedLineAggregator<>();

		BeanWrapperFieldExtractor<ZabbixTrigger> bwf = new BeanWrapperFieldExtractor<>();
		bwf.setNames(ZabbixTrigger.NAMES);

		agg.setFieldExtractor(bwf);
		
		return agg;
	}
	
}
