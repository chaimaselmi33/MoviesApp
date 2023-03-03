package com.autry.spring.InterfacesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autry.spring.Interfaces.ActorInterface;
import com.autry.spring.dao.actorRepo;
import com.autry.spring.models.Actor;

@Service
public class ActorInterfaceImp implements ActorInterface{
	
	@Autowired
	actorRepo ac_repo;

	@Override
	public Actor saveActor(Actor ac) {
		return ac_repo.save(ac);
	}

	@Override
	public List<Actor> getActors() {
		return ac_repo.findAll();
	}

	@Override
	public void deleteActor(long id) {
		ac_repo.deleteById(id);
		
	}

}
