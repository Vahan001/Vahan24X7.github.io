package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.entity.Login;

@Controller
public class LoginController {
 @GetMapping("/")
 public String showLogin() {
  return "index";
 }
 //Check for Credentials
 @PostMapping("/challan")
 public String login(@ModelAttribute(name="loginForm") Login login, Model m) {
  String uname = login.getUsername();
  String pass = login.getPassword();
  if(uname.equals("admin") && pass.equals("admin")) {
   m.addAttribute("uname", uname);
   m.addAttribute("pass", pass);
   return "redirect:/challans";
  }
  m.addAttribute("error", "Incorrect Username & Password");
  return "index";
  
 }
}