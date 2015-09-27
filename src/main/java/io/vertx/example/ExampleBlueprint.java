package io.vertx.example;

import io.vertx.core.AbstractVerticle;

public class ExampleBlueprint  extends AbstractVerticle {

    @Override
    public void start() {

        // http server
        // eventbuc consumer
        // periodic publisher
        vertx.setPeriodic(1000, periodicContext -> vertx.eventBus().send("test-channel", "Hello from Java verticle"));
    }

}
