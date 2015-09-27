package io.vertx.example;

import io.vertx.core.AbstractVerticle;

public class HelloWorldVerticle extends AbstractVerticle {

    @Override
    public void start() {
        vertx.createHttpServer().requestHandler(req -> req.response().end("Hello World!")).listen(8080);
        vertx.eventBus().consumer("test-channel", inboundMessage -> System.out.println("got message: " + inboundMessage.body()));
        vertx.setPeriodic(1000, periodicContext -> vertx.eventBus().publish("test-channel", "Hello from Java verticle"));
    }
}
