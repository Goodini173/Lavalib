package com.lavamen.lavalib.config;

import javax.annotation.Nullable;

public class ConfigLoadResult<T> {

    private final @Nullable T result;
    private final @Nullable Exception exception;
    private final @Nullable String message;

    public ConfigLoadResult(@Nullable T result,
                            @Nullable Exception exception,
                            @Nullable String message) {
        this.result = result;
        this.exception = exception;
        this.message = message;
    }

    @Nullable
    public T getResult() {
        return result;
    }

    @Nullable
    public Exception getException() {
        return exception;
    }

    @Nullable
    public String getMessage() {
        return message;
    }
}
