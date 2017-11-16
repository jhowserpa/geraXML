package com.geraxml.main;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class ConverteData implements Converter {

	// O tipo da classe que ira converter
	@SuppressWarnings("rawtypes")
	@Override
	public boolean canConvert(Class type) {
		return type.equals(Date.class);
	}

	// Transforma Objeto em aqruivo XML
	@Override
	public void marshal(Object arg0, HierarchicalStreamWriter writer, MarshallingContext arg2) {
		Date data = (Date) arg0;
		String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(data);
		writer.setValue(dataFormatada);

	}

	// Transforma XML em aqruivo Objeto - Engenharia reversa
	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext arg1) {
		Date data = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			data = (Date) sdf.parse(reader.getValue());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return data;
	}

}
