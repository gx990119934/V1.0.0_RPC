package org.rpc.remoting.util;

import java.util.concurrent.ConcurrentHashMap;

public class Maps {
	
	public static <K, V> ConcurrentHashMap<K, V> newConcurrentMap(){
		return new ConcurrentHashMap<>(16);
	}
}
