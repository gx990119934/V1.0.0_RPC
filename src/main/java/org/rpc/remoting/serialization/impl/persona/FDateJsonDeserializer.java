package org.rpc.remoting.serialization.impl.persona;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.rpc.remoting.helper.StringUtil;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;


/**
 * @author xingg
 * 实现对Date类型的序列化定制输入
 */
public class FDateJsonDeserializer extends JsonDeserializer<Date>{

	@Override
	public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
			String date = jsonParser.getText();
			if(StringUtil.isEmpty(date)){
				return null;
			}
			//如果为时间戳
			if(StringUtil.isNumeric(date)){
				return new Date(Long.valueOf(date));
			}
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				return format.parse(date);
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
	}

}
