package org.rpc.remoting.serialization.itf;

/**
 * @author xingg
 *　序列化工具类接口
 */
public interface Iserializer {
	
	/**
	 * 序列化
	 * @param obj 需要序列化的对象
	 * @return　byte[]　序列化之后的字节数组
	 */
	public <T> byte[] serialize(T obj);
	
	
	/**
	 * 反序列化
	 * @param data 序列化之后的字节数组
	 * @param clazz	　反序列化对象类型
	 * @return　
	 */
	public <T> T deSerialize(byte[] data,Class<T> clazz);
}
