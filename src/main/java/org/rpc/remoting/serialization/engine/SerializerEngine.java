package org.rpc.remoting.serialization.engine;

import java.util.Map;

import org.rpc.remoting.helper.Maps;
import org.rpc.remoting.serialization.impl.DefaultJavaSerializer;
import org.rpc.remoting.serialization.impl.FastJSONSerializer;
import org.rpc.remoting.serialization.impl.HessianSerializer;
import org.rpc.remoting.serialization.impl.JSONSerializer;
import org.rpc.remoting.serialization.impl.ProtoStuffSerializer;
import org.rpc.remoting.serialization.impl.XmlJavaDefaultSerializer;
import org.rpc.remoting.serialization.impl.XmlSerializer;
import org.rpc.remoting.serialization.itf.Iserializer;

/**
 * @author xingg
 * 序列化工具引擎
 */
public class SerializerEngine {

	public static final Map<SerializeType, Iserializer> serializerMap = Maps.newConcurrentMap();

	//注册序列化工具类到serializerMap
	static{
		serializerMap.put(SerializeType.DefaultJavaSerializer, new DefaultJavaSerializer());
		serializerMap.put(SerializeType.FastJSONSerializer, new FastJSONSerializer());
		serializerMap.put(SerializeType.HessianSerializer, new HessianSerializer());
		serializerMap.put(SerializeType.JSONSerializer, new JSONSerializer());
		serializerMap.put(SerializeType.ProtoStuffSerializer, new ProtoStuffSerializer());
		serializerMap.put(SerializeType.XmlJavaDefaultSerializer, new XmlJavaDefaultSerializer());
		serializerMap.put(SerializeType.XmlSerializer, new XmlSerializer());
	}
	
	/**
	 * 对象序列化
	 * @param obj:需要序列化的对象
	 * @param serializeType:使用序列化的类型
	 * @return
	 */
	public static <T> byte[] serialize(T obj,SerializeType serializeType){
		Iserializer serializer = serializerMap.get(serializeType);
		if(serializer == null){
			throw new RuntimeException("serialize error");
		}
		try {
			return serializer.serialize(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 对象反序列化
	 * @param data:字节数组
	 * @param clazz:类类型
	 * @param serializeType:使用反序列化类型
	 * @return
	 */
	public static <T> T deserialize(byte[] data,Class<T> clazz,SerializeType serializeType){
		Iserializer serializer = serializerMap.get(serializeType);
		if(serializer == null){
			throw new RuntimeException("serialize error");
		}
		try {
			return serializer.deSerialize(data, clazz);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
