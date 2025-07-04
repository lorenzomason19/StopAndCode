package it.lorenzo.StopAndCode1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TemperatureController {

  @GetMapping("/index")
  public String index(@RequestParam(value = "temp", required = false) String temp, Model model) {
    Double celsius = null;
    Double fahrenheit = null;
    Double kelvin = null;
    String error = null;

    if (temp != null && !temp.isEmpty()) {
      try {
        celsius = Double.parseDouble(temp);
        fahrenheit = celsius * 9 / 5 + 32;
        kelvin = celsius + 273.15;
      } catch (NumberFormatException e) {
        error = "Il valore inserito non è un numero valido.";
      }
    }

    model.addAttribute("celsius", celsius);
    model.addAttribute("fahrenheit", fahrenheit);
    model.addAttribute("kelvin", kelvin);
    model.addAttribute("error", error);

    return "index";
  }
}
