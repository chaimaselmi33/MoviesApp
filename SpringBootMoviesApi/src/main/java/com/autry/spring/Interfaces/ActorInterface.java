package com.autry.spring.Interfaces;

import java.util.List;

import com.autry.spring.models.Actor;

public interface ActorInterface {
	
	Actor saveActor(Actor ac);
	
	List<Actor> getActors();
	
	void deleteActor(long id);

}
