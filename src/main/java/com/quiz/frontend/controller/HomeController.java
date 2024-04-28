package com.quiz.frontend.controller;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.quiz.frontend.dto.Game;
import com.quiz.frontend.dto.Quiz;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Controller
public class HomeController {

  public Optional<String> readServletCookie(HttpServletRequest request, String name){
    return Arrays.stream(request.getCookies())
      .filter(cookie->name.equals(cookie.getName()))
      .map(Cookie::getValue)
      .findAny();
  }

  @GetMapping("/")
  public String root(HttpServletRequest request, Model model) {
    return "root";
  }

  @GetMapping("/login")
  public String login(HttpServletRequest request, Model model) {
    return "login";
  }

  @GetMapping("/hello")
  public String hello(HttpServletRequest request, Model model) {
    return "hello";
  }

  private Quiz quizData = new Quiz("category name", 2);
  @GetMapping("/create")
  @PostMapping("/create")
  public String helloWorld(Model model){
      model.addAttribute("gameData", quizData);
      model.addAttribute("game", new Game());
      return "create";
  }
  @PostMapping("/game")
  public String gameSubmit(@ModelAttribute Game game, Model model, HttpServletResponse response) {
    System.out.printf("FORM -- getCategoryName " + " " + game.getCategoryName());
    System.out.printf("FORM --- getGameMode " + " " + game.getGameMode());
    System.out.printf("FORM --- getGamePlayers " + " " + game.getGamePlayers());
    
    Cookie gameCategoryCookie = new Cookie("gameCategory", game.getCategoryName());
    gameCategoryCookie.setMaxAge(-1);
    gameCategoryCookie.setHttpOnly(true);

    Cookie gameModeCookie = new Cookie("gameMode", game.getGameMode());
    gameModeCookie.setMaxAge(-1);
    gameModeCookie.setHttpOnly(true);
    response.addCookie(gameModeCookie);
    response.addCookie(gameModeCookie);

    Cookie gamePlayersCookie = new Cookie("gamePlayers", String.valueOf(game.getGamePlayers()));
    gamePlayersCookie.setMaxAge(-1);
    gamePlayersCookie.setHttpOnly(true);
    response.addCookie(gamePlayersCookie);
    response.addCookie(gamePlayersCookie);

    return "redirect:/lobby";
  }

  @GetMapping("/lobby")
  public String gameSubmit(HttpServletRequest request, Model model) {
    final Optional<String> gameCategory = readServletCookie(request, "gameCategory");
    final Optional<String> gameMode = readServletCookie(request, "gameMode");
    final Optional<String> gamePlayers = readServletCookie(request, "gamePlayers");
    if(gameCategory.isEmpty()) return "redirect:/home";
    model.addAttribute("gameMode", gameMode);
    model.addAttribute("gameCategory", gameCategory);
    model.addAttribute("gamePlayers", gamePlayers);
    return "lobby";
  }
}
