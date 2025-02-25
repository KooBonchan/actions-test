package com.example.actions_test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class DiceController {
  @GetMapping("dice")
  public void dice(Model model){
    Random random = new Random();
    model.addAttribute("diceResult", random.nextInt(1,7));
  }
}
