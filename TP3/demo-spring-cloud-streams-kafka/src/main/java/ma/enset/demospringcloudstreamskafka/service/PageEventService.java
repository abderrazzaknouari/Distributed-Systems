package ma.enset.demospringcloudstreamskafka.service;

import ma.enset.demospringcloudstreamskafka.entities.PageEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;


@Service
public class PageEventService {
    @Bean
    public Consumer<PageEvent> pageEventConsumer() {
        return (event) -> {
            System.out.println("***********");
            System.out.println("Received event: " + event.toString());
            System.out.println("***********");
        };
    }

    @Bean
    public Supplier<PageEvent> pageEventSupplier() {
        return () -> {
            PageEvent pageEvent = new PageEvent();
            pageEvent.setName(Math.random() > 0.5 ? "page1" : "page2");
            pageEvent.setUser(Math.random() > 0.5 ? "user1" : "user2");
            pageEvent.setDuration((int) (Math.random() * 1000));
            pageEvent.setDate(new java.util.Date());
            System.out.println("***********");
            System.out.println("Sent event: " + pageEvent.toString());
            System.out.println("***********");
            return pageEvent;
        };
    }

    @Bean
    public Function<PageEvent, PageEvent> pageEventFunction() {
        return (event) -> {
            event.setName(event.getName().toUpperCase());
            event.setUser(event.getUser().toUpperCase());
            event.setDuration(event.getDuration() * 2);
            System.out.println("***********");
            System.out.println("Transformed event: " + event.toString());
            System.out.println("***********");
            return event;
        };
    }

}
