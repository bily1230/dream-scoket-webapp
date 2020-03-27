package com.dream.socket;

import org.springframework.context.SmartLifecycle;

/**
 * @Description TODO.
 * @Auther nb
 * @Date 18-12-7 下午4:15
 **/
public abstract class AutoRunnable implements SmartLifecycle {

    int DEFAULT_PHASE = 2000;

    protected boolean running = false;

    @Override
    public void start() {
        autoRun();
        running = true;
    }

    @Override
    public void stop() {
        running = false;
    }

    @Override
    public int getPhase() {
        return DEFAULT_PHASE;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    public abstract void autoRun();
}
