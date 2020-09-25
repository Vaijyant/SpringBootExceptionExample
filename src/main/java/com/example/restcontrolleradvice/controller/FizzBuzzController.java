package com.example.restcontrolleradvice.controller;

import com.example.restcontrolleradvice.dto.FizzException;
import com.example.restcontrolleradvice.enums.FizzBuzzEnum;
import com.example.restcontrolleradvice.dto.BuzzException;
import com.example.restcontrolleradvice.dto.FizzBuzzException;
import com.example.restcontrolleradvice.dto.FizzBuzzResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FizzBuzzController {

  @RequestMapping(value = "/controller_advice/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<FizzBuzzResponse> getFizzBuzzResponse(@PathVariable("code") String code)
          throws FizzException, BuzzException, FizzBuzzException {
    if (FizzBuzzEnum.FIZZ.getValue().equals(code)) {
      throw new FizzException("Fizz Exception has been thrown", "Internal Server Error");
    } else if (FizzBuzzEnum.BUZZ.getValue().equals(code)) {
      throw new BuzzException("Buzz Exception has been thrown", "Bad Request");
    } else if (FizzBuzzEnum.FIZZBUZZ.getValue().equals(code)) {
      throw new FizzBuzzException("FizzBuzz Exception has been thrown", "Insufficient Storage");
    }
    return new ResponseEntity<>(new FizzBuzzResponse("Successfully completed fizzbuzz test",
            HttpStatus.OK.value()), HttpStatus.OK);
  }
}
