package org.rpc.remoting.serialization.impl;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.rpc.remoting.serialization.itf.Iserializer;

/**
 * @author xingg
 *	java自带方式实现xml序列化
 */
public class XmlJavaDefaultSerializer implements Iserializer{

	public <T> byte[] serialize(T obj) {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		XMLEncoder xe = new XMLEncoder(output);
		xe.writeObject(obj);
		xe.close();
		return output.toByteArray();
	}

	@SuppressWarnings("unchecked")
	public <T> T deSerialize(byte[] data, Class<T> clazz) {
		XMLDecoder xd = new XMLDecoder(new ByteArrayInputStream(data));
		Object obj = xd.readObject();
		xd.close();
		return (T) obj;
	}

}
