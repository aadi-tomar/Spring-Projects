package com.aadi.ReactiveDemo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Stream;

@RestController
public class Demo {

    @GetMapping("/demo")
    public void demo(){

        //List<Integer> list = List.of(1,2,3,4);
        // Flux and Mono both are publisher. Publisher<Integer> f1 =
        Flux<Integer> f1 = Flux.just(1,2,3,4,5,6);
        //var f2 = Flux.fromStream(Stream.of(1,2,3,4,5,6,7));
        //var f3 = Flux.fromIterable(Set.of(1,2,34,5,61,68,66));
        f1.subscribe(c -> System.out.println(c));
        f1.doOnNext( i -> System.out.println(i)); // it simply wont do anything as there are no subscribers.
        f1.doOnNext(i -> System.out.println(i)).subscribe();


        Flux<String> flux = Flux.create(s ->{
            for(int i=0; i< 10; i++){
                s.next(UUID.randomUUID().toString());
            }
            s.complete();
        });

        flux.log()
                .subscribe(c -> System.out.println(c));


    }
}
