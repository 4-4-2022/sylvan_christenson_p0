package com.p0.ringRepository;

import java.util.ArrayList;
import java.util.List;

import com.p0.model.Rings;

public interface RingRepository {
	
	public void seeMenu();
	public void giveRing(String receivingUser);
	public Rings customRing();
	public void buyRing();
	public void setEngraving();
	public void printRings();
	public List<Rings> findAllRings();
	
	List <Rings> ringList = new ArrayList<Rings>();

}