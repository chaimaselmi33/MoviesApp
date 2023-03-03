package com.autry.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autry.spring.Interfaces.ActorInterface;
import com.autry.spring.models.Actor;

@RestController
@RequestMapping("/actor")
public class ActorController {

	@Autowired
	ActorInterface ac_interf;
	
	@GetMapping("/get-actors")
	List<Actor> getActors(){
		return ac_interf.getActors();
	}
	
}
