package org.rpc.remoting.serialization.engine;

import org.rpc.remoting.helper.StringUtil;

/**
 * @author xingg
 * 序列化工具枚举类型
 */
public enum SerializeType {
	
	DefaultJavaSerializer("DefaultJavaSerializer"),
	FastJSONSerializer("FastJSONSerializer"),
	HessianSerializer("HessianSerializer"),
	JSONSerializer("JSONSerializer"),
	ProtoStuffSerializer("ProtoStuffSerializer"),
	XmlJavaDefaultSerializer("XmlJavaDefaultSerializer"),
	XmlSerializer("XmlSerializer");
	
	private String serializeType;

	private SerializeType(String serializeType) {
		this.serializeType = serializeType;
	}
	
	public static SerializeType queryByType(String serializeType){
		if(StringUtil.isEmpty(serializeType)){
			return null;
		}
		for (SerializeType serialize:SerializeType.values()) {
			if(StringUtil.equals(serializeType, serialize.getSerializeType())){
				return serialize;
			}
		}
		return null;
	}
	
	public String getSerializeType(){
		return serializeType;
	}
}
