package ma.enset.demospringcloudstreamskafka.web;

import lombok.AllArgsConstructor;
import ma.enset.demospringcloudstreamskafka.entities.PageEvent;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@AllArgsConstructor
public class PageEventRestController {

    private StreamBridge streamBridge;

    @GetMapping("/publish/{topic}/{name}")
    public PageEvent publish(@PathVariable String topic, @PathVariable String name) {
        PageEvent pageEvent = new PageEvent();
        pageEvent.setName(name);
        pageEvent.setUser(Math.random()>0.5?"user1":"user2");
        pageEvent.setDuration(new Random().nextInt(9000));
        pageEvent.setDate(new java.util.Date());
        streamBridge.send(topic, pageEvent);
        System.out.println("Sent event: " + pageEvent);
        return pageEvent;
    }

    @GetMapping("")
    public String home() {
        return "Hello";
    }
}
