package com.shipa.newage.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import static com.shipa.newage.constants.Constants.SHIPA_ASYNC_THREAD_POOL_NAME;
import static com.shipa.newage.constants.Constants.SHIPA_ASYNC_THREAD_NAME_PREFIX;

/**
 * @author SureshKumar
 * 16-Sep-2023
 */

@EnableAsync
@Configuration
public class AsyncTaskExecutor {

	@Bean(SHIPA_ASYNC_THREAD_POOL_NAME)
	public TaskExecutor getAsyncExecutor() {

		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(20);
		executor.setMaxPoolSize(1000);
		executor.setWaitForTasksToCompleteOnShutdown(true);
		executor.setThreadNamePrefix(SHIPA_ASYNC_THREAD_NAME_PREFIX);
		return executor;
	}

}