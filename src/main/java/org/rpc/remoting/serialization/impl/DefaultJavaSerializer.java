package org.rpc.remoting.serialization.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.rpc.remoting.serialization.itf.Iserializer;

/**
 * @author xingg
 *　使用java内置的序列化方法
 *	优点：无序引入第三方依赖
 *　缺点:性能较差，码流过大，易发生内存OOM异常
 */
public class DefaultJavaSerializer implements Iserializer{

	public <T> byte[] serialize(T obj) {
		ByteArrayOutputStream output = new ByteArrayOutputStream(); 
		ObjectOutputStream objectOutput = null;
		try {
			objectOutput=new ObjectOutputStream(output);
			objectOutput.writeObject(obj);
			objectOutput.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return output.toByteArray();
	}

	@SuppressWarnings("unchecked")
	public <T> T deSerialize(byte[] data, Class<T> clazz) {
		ByteArrayInputStream input = new ByteArrayInputStream(data);
		ObjectInputStream objectInput = null;
		try {
			objectInput = new ObjectInputStream(input);
			return (T) objectInput.readObject();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
