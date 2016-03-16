package com.sunway.ws.core.quartz;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.SchedulerListener;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.springframework.stereotype.Component;

/**
 * quartz 监听
 */
@Component
public class QuartzSchedulerListener implements SchedulerListener {
	
	private static final Logger logger = LogManager.getLogger(QuartzSchedulerListener.class);

	@Override
	public void jobAdded(JobDetail jobDetail) {
		logger.info("jobAdd, key:{}, des:{}", jobDetail.getKey(), jobDetail.getDescription());
	}

	@Override
	public void jobDeleted(JobKey jobKey) {
		logger.info("jobDeleted, group:{}, name:{}", jobKey.getGroup(), jobKey.getName());
	}

	@Override
	public void jobPaused(JobKey jobKey) {
		
	}

	@Override
	public void jobResumed(JobKey jobKey) {
		
	}

	@Override
	public void jobScheduled(Trigger trigger) {
		
	}

	@Override
	public void jobUnscheduled(TriggerKey triggerKey) {
		
	}

	@Override
	public void jobsPaused(String string) {
		
	}

	@Override
	public void jobsResumed(String string) {
		
	}

	@Override
	public void schedulerError(String string, SchedulerException schedulerException) {
		// TODO 存储异常
		
		
	}

	@Override
	public void schedulerInStandbyMode() {
		
	}

	@Override
	public void schedulerShutdown() {
		
	}

	@Override
	public void schedulerShuttingdown() {
		
	}

	@Override
	public void schedulerStarted() {
		
	}

	@Override
	public void schedulerStarting() {
		
	}

	@Override
	public void schedulingDataCleared() {
		
	}

	@Override
	public void triggerFinalized(Trigger trigger) {
		
	}

	@Override
	public void triggerPaused(TriggerKey triggerKey) {
		
	}

	@Override
	public void triggerResumed(TriggerKey triggerKey) {
		
	}

	@Override
	public void triggersPaused(String string) {
		
	}

	@Override
	public void triggersResumed(String string) {
		
	}

}
