package com.xujian.bizProduct.utils.schedulers;

import android.support.annotation.NonNull;

import io.reactivex.Scheduler;
import io.reactivex.internal.schedulers.ImmediateThinScheduler;

/**
 * Implementation of the {@link BaseSchedulerProvider} making all {@link Scheduler}s immediate.
 */
public class ImmediateSchedulerProvider implements BaseSchedulerProvider {

    @NonNull
    @Override
    public Scheduler computation() {
        return ImmediateThinScheduler.INSTANCE;
    }

    @NonNull
    @Override
    public Scheduler io() {
        return ImmediateThinScheduler.INSTANCE;
    }

    @NonNull
    @Override
    public Scheduler ui() {
        return ImmediateThinScheduler.INSTANCE;
    }
}
