package hu.jupi.teaching.springasync;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

/**
 */
public class SimpleTask implements Runnable, ApplicationListener<ContextClosedEvent> {

    private boolean shutdown;

    @Override
    public void run() {
        while (!shutdown) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello Async");
        }
    }

    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        shutdown = true;
    }
}
