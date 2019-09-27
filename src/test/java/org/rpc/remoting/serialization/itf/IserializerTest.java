package org.rpc.remoting.serialization.itf;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.rpc.remoting.serialization.impl.DefaultJavaSerializer;
import org.rpc.remoting.serialization.impl.FastJSONSerializer;
import org.rpc.remoting.serialization.impl.JSONSerializer;
import org.rpc.remoting.serialization.impl.XmlJavaDefaultSerializer;
import org.rpc.remoting.serialization.impl.XmlSerializer;
import org.rpc.remoting.serialization.model.User;

public class IserializerTest {

	Iserializer defaultJavaSerializer = new DefaultJavaSerializer();
	
	Iserializer xmlSerializer = new XmlSerializer();
	
	Iserializer xmlJavaDefaultSerializer = new XmlJavaDefaultSerializer();
	
	Iserializer jSONSerializer = new JSONSerializer();
	
	Iserializer fastJSONSerializer = new FastJSONSerializer();
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

}
