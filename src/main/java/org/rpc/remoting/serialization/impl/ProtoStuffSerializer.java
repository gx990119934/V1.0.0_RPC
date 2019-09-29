package org.rpc.remoting.serialization.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;
import org.rpc.remoting.serialization.itf.Iserializer;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

/**
 * @author xingg
 * 基于protobuf的protostuff序列化，使用在无需跨语言的场景
 * 优点:空间开销小，高性能解析，适用于对性能要求较高的RPC调用
 */
public class ProtoStuffSerializer implements Iserializer{

	private static Map<Class<?>, Schema<?>> cachedSchema = new ConcurrentHashMap<>();
	
	private static Objenesis objenesis = new ObjenesisStd(true);
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> byte[] serialize(T obj) {
		Class<T> cls = (Class<T>) obj.getClass();
		LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
		try {
			Schema<T> schema = getSchema(cls);
			return ProtostuffIOUtil.toByteArray(obj, schema, buffer);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			buffer.clear();
		}
	}

	@Override
	public <T> T deSerialize(byte[] data, Class<T> clazz) {
		try {
			T message =	objenesis.newInstance(clazz);
			Schema<T> schema = getSchema(clazz);
			ProtostuffIOUtil.mergeFrom(data, message, schema);
			return message;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	/**
	 * 获取Schema
	 * @param cls：序列化类类型
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static <T> Schema<T> getSchema(Class<T> cls){
		Schema<T> schema = (Schema<T>) cachedSchema.get(cls);
		if(schema == null){
			schema = RuntimeSchema.createFrom(cls);
			cachedSchema.put(cls, schema);
		}
		return schema;		
	}
}
