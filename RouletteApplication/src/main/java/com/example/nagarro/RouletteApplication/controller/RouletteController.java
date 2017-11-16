package com.example.nagarro.RouletteApplication.controller;

import java.awt.PageAttributes.MediaType;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.nagarro.RouletteApplication.models.Bet;
import com.example.nagarro.RouletteApplication.models.User;
import com.example.nagarro.RouletteApplication.services.Service;

@RestController
public class RouletteController {

	RestTemplate restTemplate = new RestTemplate();
	
	@CrossOrigin("*")
	@GetMapping("/users/all")
	 public String getEntity(){
		String Uri = "http://localhost:8080/all";
		return restTemplate.getForObject(Uri, String.class);
	}
	
	@CrossOrigin("*")
	@GetMapping("/user/{id}")
	 public String getUserById(@PathVariable String id){
		String Uri = "http://localhost:8080/user/"+id;
		String jsonUser = restTemplate.getForObject(Uri, String.class);
		if(jsonUser==null)
		{
			return "Error: Enter valid user";
		}
		return jsonUser;
	}

	@CrossOrigin("*")
	@PostMapping(path = "/amount/block/{id}")
	public String blockAmount(@PathVariable Long id  , @RequestBody Bet bet) {
		System.out.println(id);
		int block_amt = Service.getTotalBet(bet);
		final String uri = "http://localhost:8080/amount/block/"+id+"/"+block_amt;
		RestTemplate restTemplate = new RestTemplate();
		String jsonUser = restTemplate.getForObject(uri, String.class);
		if(jsonUser==null)
		{
			return "Error: Not enough amount";
		}
		int randomnum = Service.generateRandom();
		int winning_amt = Service.calculateProfit(bet, randomnum);
		final String uri1 = "http://localhost:8080/amount/winning/"+id+"/"+winning_amt;
		jsonUser = restTemplate.getForObject(uri1, String.class);
		return "Random number is : "+ randomnum + "\nYou won "+ winning_amt + " Rupee!, blockamt:"+block_amt;
	}

}
