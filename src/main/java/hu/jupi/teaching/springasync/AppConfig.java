package hu.jupi.teaching.springasync;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

/**
 */
@Configuration
public class AppConfig {

    @Bean
    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
        taskExecutor.setConcurrencyLimit(1);
        taskExecutor.execute(simpleTask());
        return taskExecutor;
    }

    @Bean
    public SimpleTask simpleTask() {
        return new SimpleTask();
    }
}
