package com.republicasmp.cdm;

public class Value<T extends Object> {
	public final T value;
	public final boolean cares;
	
	public Value(T value) {
		this.value = value;
		this.cares = true;
	}
	
	public Value() {
		this.value = null;
		this.cares = false;
	}
	
	public static <T extends Object> Value<T> make(T obj) {
		return new Value<T>(obj);
	}
}
