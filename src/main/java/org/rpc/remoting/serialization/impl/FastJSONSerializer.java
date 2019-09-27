package org.rpc.remoting.serialization.impl;

import org.rpc.remoting.serialization.itf.Iserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author xingg
 * json序列化(fastjsonn)稳定性较差,api简单
 *　优点：可读性好，适用于轻量级数据
 */
public class FastJSONSerializer implements Iserializer{

	@Override
	public <T> byte[] serialize(T obj) {
		return JSON.toJSONString(obj, SerializerFeature.WriteDateUseDateFormat).getBytes();
	}

	@Override
	public <T> T deSerialize(byte[] data, Class<T> clazz) {
		return JSON.parseObject(new String(data), clazz);
	}

}
