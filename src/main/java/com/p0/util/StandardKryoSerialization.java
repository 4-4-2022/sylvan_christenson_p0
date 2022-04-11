package com.p0.util;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import com.p0.model.Rings;

public class StandardKryoSerialization {

	
	public static void main(String[] args) {
		
		Kryo kryo = new Kryo();
		kryo.register(Rings.class);
		
		Rings ring = new Rings("Iron", "Ruby", "Peppies", "Iron Band", 50);
		
		Output output = new Output(System.out);
		kryo.writeObject(output, ring);
		output.close();
	}
}
