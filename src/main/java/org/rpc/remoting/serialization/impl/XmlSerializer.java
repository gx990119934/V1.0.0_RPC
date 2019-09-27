package org.rpc.remoting.serialization.impl;

import org.rpc.remoting.serialization.itf.Iserializer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @author xingg
 * 使用XStream实现序列化
 * 优点：可读性好，利于调试
 * 缺点:性能较差，码流过大
 */
public class XmlSerializer implements Iserializer{

	//初始化XStream对象
	private static final XStream xStream = new XStream(new DomDriver());
	
	public <T> byte[] serialize(T obj) {
		return xStream.toXML(obj).getBytes();
	}

	@SuppressWarnings("unchecked")
	public <T> T deSerialize(byte[] data, Class<T> clazz) {
		String xml = new String(data);
		return (T) xStream.fromXML(xml);
	}

}
