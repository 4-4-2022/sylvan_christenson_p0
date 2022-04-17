package com.p0.serialization;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import com.p0.model.Rings;

public class CustomKryoSerializer{

	
	public static void main(String[] args) {
		
		
		
	}
	
	
	
	public void write(Kryo kryo, Output output, Rings object) {
		output.writeString("the" + object.getMaterial());
		
		
	}
}




