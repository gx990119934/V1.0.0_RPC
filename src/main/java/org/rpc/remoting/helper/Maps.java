package org.rpc.remoting.helper;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xingg
 *	Map工具类
 */
public class Maps {
	
	public static <K, V> ConcurrentHashMap<K, V> newConcurrentMap(){
		return new ConcurrentHashMap<>(16);
	}
}
