package org.takastudy.tech;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class ZabbxdocApplication {

	public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException, InterruptedException {
		
		Log log = LogFactory.getLog(ZabbxdocApplication.class);
		
		SpringApplication app = new SpringApplication(ZabbxdocApplication.class);
		app.setWebEnvironment(false);
		
		ConfigurableApplicationContext ctx = app.run(args);
		JobLauncher runner = ctx.getBean(JobLauncher.class);
		
		Job job = ctx.getBean("docgen",Job.class);
		
		Map<String, JobParameter> jobParameterMap = new HashMap<>();
		jobParameterMap.put("inputFile", new JobParameter(args[1]));
		jobParameterMap.put("outputItemFile", new JobParameter(args[2]));
		jobParameterMap.put("outputTriggerFile", new JobParameter(args[3]));
		
		JobParameters jobParameters = new JobParameters(jobParameterMap);
				
		log.info("Job Start");
		
		JobExecution ex = runner.run(job, jobParameters);
		BatchStatus status = ex.getStatus();
		
		while(status.isRunning()){
			log.info("Stull Running");
			Thread.sleep(1000);
		}
		
		log.info(String.format("Exit Status: %s",ex.getExitStatus().getExitCode() ));

		log.info(String.format("Job Name:%s JobId:%s", ex.getJobInstance().getJobName(),ex.getJobInstance().getId()));
		
		System.exit(0);
	}
}
