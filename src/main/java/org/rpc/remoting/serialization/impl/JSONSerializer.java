package org.rpc.remoting.serialization.impl;

import java.io.IOException;
import java.util.Date;

import org.rpc.remoting.serialization.impl.persona.FDateJsonDeserializer;
import org.rpc.remoting.serialization.impl.persona.FDateJsonSerializer;
import org.rpc.remoting.serialization.itf.Iserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * @author xingg
 *　json序列化(jackson)api较复杂
 *　优点：可读性好，适用于轻量级数据
 */
public class JSONSerializer implements Iserializer{

	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	static{
		objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
		objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		SimpleModule  module = new SimpleModule("DateTimeModule",Version.unknownVersion());
		module.addSerializer(Date.class, new FDateJsonSerializer());
		module.addDeserializer(Date.class, new FDateJsonDeserializer());
		objectMapper.registerModule(module);
	}
	
	public <T> byte[] serialize(T obj) {
		if(obj == null){
			return new byte[0];
		}
		try {
			String json = objectMapper.writeValueAsString(obj);
			return json.getBytes();
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	public <T> T deSerialize(byte[] data, Class<T> clazz) {
		String json = new String(data);
		try {
			return objectMapper.readValue(json, clazz);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} 
	}

}
