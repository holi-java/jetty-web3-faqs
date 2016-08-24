package com.holi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by selonj on 16-8-23.
 */
@Controller
public class TouchController {
  @RequestMapping("/touch")
  public @ResponseBody String touch() {
    return "success";
  }
}
