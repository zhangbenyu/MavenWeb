package com.controller.conveter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class CustomStrToDate implements Converter<String, Date>{

	@Override
	public Date convert(String arg0) {
		// TODO Auto-generated method stub
		try {
			Date date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(arg0);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}


}
