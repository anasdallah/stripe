package com.stripe.stripepayments.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;

@RestController
@RequestMapping("/stripe/v1")
@RequiredArgsConstructor
public class PaymentController {


    private static final int MAX_PROCESSING_TIME_MS = 7000;
    private static final int MIN_PROCESSING_TIME_MS = 2000;


    @PostMapping("/payment")
    public ResponseEntity<Object> processPayment() throws Exception {


        if (random() > 3000L) {
//            return ResponseEntity.badRequest().body("issue");

            throw new Exception();
        }

        System.out.println("Approved!");

        return ResponseEntity.created(new URI("")).body("Approved");
    }

    @GetMapping("/payments/{uuid}")
    public ResponseEntity<Object> paymentStatus(@PathVariable("uuid") String uuid) throws URISyntaxException {

        System.out.println("Payment with id: " + uuid + " is success");

        return ResponseEntity.created(new URI("")).body("Approved");
    }

    private int random() {
        Random rand = new Random();
        return MIN_PROCESSING_TIME_MS + rand.nextInt(MAX_PROCESSING_TIME_MS - MIN_PROCESSING_TIME_MS);
    }
}

