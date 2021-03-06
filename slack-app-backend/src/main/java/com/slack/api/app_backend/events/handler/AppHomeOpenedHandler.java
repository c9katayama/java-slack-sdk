package com.slack.api.app_backend.events.handler;

import com.slack.api.app_backend.events.EventHandler;
import com.slack.api.app_backend.events.payload.AppHomeOpenedPayload;
import com.slack.api.model.event.AppHomeOpenedEvent;

public abstract class AppHomeOpenedHandler extends EventHandler<AppHomeOpenedPayload> {

    @Override
    public String getEventType() {
        return AppHomeOpenedEvent.TYPE_NAME;
    }
}
