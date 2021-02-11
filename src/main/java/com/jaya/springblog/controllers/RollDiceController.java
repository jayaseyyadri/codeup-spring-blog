package com.jaya.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class RollDiceController {
    @GetMapping("/roll-dice/{userChoice}")
    public String roll(@PathVariable int userChoice, Model model) {
        String message;
        //Generate random number
        Random random = new Random();
        int randomNumber = random.nextInt(((6 - 1) + 1) + 1);

        //check logic
        if (userChoice == randomNumber) {
            message = " You guessed right !";
        } else {
            message = "you guessed wrong!";
        }

        model.addAttribute("userChoice", userChoice);
        model.addAttribute("randomNumber", randomNumber);
        model.addAttribute("message", message);

        return "roll-dice-n";
    }
    @GetMapping("roll-dice")
    public String showRollDice(){
        return "roll-dice";
    }
}

