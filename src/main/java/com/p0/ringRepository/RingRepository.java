package com.p0.ringRepository;

import com.p0.model.Rings;

public class RingRepository {
	private Rings[] ring = new Rings[10];
	

	public RingRepository() {

		super();
		this.ring[0] = new Rings("Iron", "Ruby", "Peppies", "Iron Band", 50);
		this.ring[1] = new Rings("Silver", "Ruby", "Peppies", "Silver Band", 150);
		this.ring[2] = new Rings("Gold", "Ruby", "Peppies", "Gold Band", 300);
		this.ring[3] = new Rings("Platinum", "Ruby", "Peppies", "Platinum Band", 600);
	}

	public Rings[] findAllRings() {

		return this.ring;
	}

	public Rings findRingByMaterial(String material) {
		for (Rings ring : ring) {
			if (ring.getMaterial().equalsIgnoreCase(material))
				return ring;
			
		}
		return null;
	}
}
