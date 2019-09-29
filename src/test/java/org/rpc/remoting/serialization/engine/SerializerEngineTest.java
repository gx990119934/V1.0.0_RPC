package org.rpc.remoting.serialization.engine;

import org.junit.Assert;
import org.junit.Test;
import org.rpc.remoting.serialization.model.User;

public class SerializerEngineTest {
	
	
	@Test
	public <T> void serializeAndDeserializeTest(){
		User user = new User(1,"hello","18929300493");
		byte[] bytes = SerializerEngine.serialize(user,SerializeType.FastJSONSerializer);
		User actualUser = SerializerEngine.deserialize(bytes, User.class,SerializeType.FastJSONSerializer);
		System.out.println(actualUser.toString());
		Assert.assertEquals(user.toString(),actualUser.toString());
	}
	
}
