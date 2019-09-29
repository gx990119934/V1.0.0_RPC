package org.rpc.remoting.serialization.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.rpc.remoting.serialization.itf.Iserializer;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

/**
 * @author xingg
 * hessian序列化(二进制序列化)
 * 优点：跨语言，拥有更好的性能和易用性
 */
public class HessianSerializer implements Iserializer{

	public <T> byte[] serialize(T obj) {
		if(obj == null){
			throw new NullPointerException();
		}
		
		try{
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			HessianOutput ho = new HessianOutput(os);
			ho.writeObject(obj);
			return os.toByteArray();
		}catch(Exception e){
				throw new RuntimeException();
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T deSerialize(byte[] data, Class<T> clazz) {
		if(data == null){
			throw new NullPointerException();
		}
		try {
			ByteArrayInputStream is = new ByteArrayInputStream(data);
			HessianInput hi = new HessianInput(is);
			return (T) hi.readObject();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}
