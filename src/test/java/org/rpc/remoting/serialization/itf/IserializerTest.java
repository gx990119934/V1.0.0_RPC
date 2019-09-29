package org.rpc.remoting.serialization.itf;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.rpc.remoting.serialization.impl.DefaultJavaSerializer;
import org.rpc.remoting.serialization.impl.FastJSONSerializer;
import org.rpc.remoting.serialization.impl.HessianSerializer;
import org.rpc.remoting.serialization.impl.JSONSerializer;
import org.rpc.remoting.serialization.impl.ProtoStuffSerializer;
import org.rpc.remoting.serialization.impl.XmlJavaDefaultSerializer;
import org.rpc.remoting.serialization.impl.XmlSerializer;
import org.rpc.remoting.serialization.model.User;

public class IserializerTest {

	Iserializer defaultJavaSerializer = new DefaultJavaSerializer();
	
	Iserializer xmlSerializer = new XmlSerializer();
	
	Iserializer xmlJavaDefaultSerializer = new XmlJavaDefaultSerializer();
	
	Iserializer jSONSerializer = new JSONSerializer();
	
	Iserializer fastJSONSerializer = new FastJSONSerializer();
	
	Iserializer hessianSerializer = new HessianSerializer();
	
	Iserializer protoStuffSerializer = new ProtoStuffSerializer();
	/**
	 * java自带序列化
	 */
	@Test
	public void defaultJavaSerializerTest(){
		User user = new User(1,"hello","18929300493");
		byte[] bytes = defaultJavaSerializer.serialize(user);
		User actualUser = defaultJavaSerializer.deSerialize(bytes, User.class);
		System.out.println(actualUser.toString());
		Assert.assertEquals(user.toString(),actualUser.toString());
	}
	
	/**
	 * XStream实现序列化
	 */
	@Test
	public void xmlSerializerTest(){
		User user = new User(1,"hello","18929300493");
		byte[] bytes = xmlSerializer.serialize(user);
		User actualUser= xmlSerializer.deSerialize(bytes, User.class);
		System.out.println(new String(bytes));
		Assert.assertEquals(user.toString(),actualUser.toString());
	}
	
	/**
	 * java自带方式实现xml序列化
	 */
	@Test
	public void xmlJavaDefaultSerializerTest(){
		User user = new User(1,"hello","18929300493");
		byte[] bytes = xmlJavaDefaultSerializer.serialize(user);
		User actualUser= xmlJavaDefaultSerializer.deSerialize(bytes, User.class);
		System.out.println(new String(bytes));
		Assert.assertEquals(user.toString(),actualUser.toString());
	}
	
	/**
	 * json序列化(jackson)
	 */
	@Test
	public void jSONSerializerTest(){
		User user = new User(1,"hello","18929300493");
		user.setBirthday(new Date());
		byte[] bytes = jSONSerializer.serialize(user);
		User actualUser= jSONSerializer.deSerialize(bytes, User.class);
		System.out.println(new String(bytes));
		Assert.assertEquals(user.toString(),actualUser.toString());
	}
	
	/**
	 * json序列化(fastjson)
	 */
	@Test
	public void fastJSONSerializerTest(){
		User user = new User(1,"hello","18929300493");
		user.setBirthday(new Date());
		byte[] bytes = fastJSONSerializer.serialize(user);
		User actualUser= fastJSONSerializer.deSerialize(bytes, User.class);
		System.out.println(new String(bytes));
		Assert.assertEquals(user.toString(),actualUser.toString());
	}

	/**
	 * hessian序列化
	 */
	@Test
	public void hessianSerializerTest(){
		User user = new User(1,"hello","18929300493");
		user.setBirthday(new Date());
		byte[] bytes = hessianSerializer.serialize(user);
		User actualUser= hessianSerializer.deSerialize(bytes, User.class);
		Assert.assertEquals(user.toString(),actualUser.toString());
	}
	
	/**
	 * protostuff序列化
	 */
	@Test
	public void protoStuffSerializerTest(){
		User user = new User(1,"hello","18929300493");
		user.setBirthday(new Date());
		byte[] bytes = protoStuffSerializer.serialize(user);
		User actualUser= protoStuffSerializer.deSerialize(bytes, User.class);
		Assert.assertEquals(user.toString(),actualUser.toString());
	}
}
