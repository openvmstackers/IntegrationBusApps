package com.example.genericaccessormodule;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.StringTokenizer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.example.genericaccessormodule.genericinterface.ObjectFactory;

import com.example.genericaccessormodule.common.ColumnType;
import com.example.genericaccessormodule.common.GenericAccessorModuleResponseType;
import com.example.genericaccessormodule.common.QueryStatusType;
import com.example.genericaccessormodule.common.RecordType;

public class MessageCreator {
	
	public static String createRetrieveInformationResponse(String status
												   ,ArrayList<ArrayList<String>> pipeDelimitedNameValuePairs){
		String strResponse = "";
		
		try{
		
		com.example.genericaccessormodule
			.common.ObjectFactory commObjFact = new com.example
													.genericaccessormodule.common.ObjectFactory();
		ObjectFactory responseObjFact = new ObjectFactory();
		
		// Initialize a response
		GenericAccessorModuleResponseType response =  commObjFact.createGenericAccessorModuleResponseType();
		QueryStatusType queryStatus = new QueryStatusType();
		queryStatus.setStatus(status);
		response.setQueryStatus(queryStatus);
		
		ListIterator<ArrayList<String>> currRowIter = pipeDelimitedNameValuePairs.listIterator();
		while(currRowIter.hasNext()){
			//Initialize a new Record
			RecordType record = commObjFact.createRecordType();

			ListIterator<String> currColumnIter = currRowIter.next().listIterator();

			while(currColumnIter.hasNext()){
				
				String pipeDelimitedColumnValue = currColumnIter.next();
				StringTokenizer tok = new StringTokenizer(pipeDelimitedColumnValue
						  									, "|");
				//Initialize a new Column
				ColumnType column = commObjFact.createColumnType();
				//Set the name as the first token in the delimited string
				column.setName(tok.nextToken());
				//Set the value as the next token in the delimited string
				column.setValue(tok.nextToken());
				//Add the column to the record
				record.getColumn().add(column);
			}
			//Add the record to the response
			response.getRecord().add(record);
		}

		
		// Create a JAXB Element that represents the response
		JAXBElement<GenericAccessorModuleResponseType> jaxbResponse = 
				responseObjFact.createRetrieveInformationResponse(response);
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();
		SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
		SOAPBody soapBody = soapEnvelope.getBody();
		JAXBContext jaxbContext = JAXBContext.newInstance(GenericAccessorModuleResponseType.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		jaxbMarshaller.marshal(jaxbResponse, soapBody);
		soapMessage.saveChanges();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		soapMessage.writeTo(baos);
		strResponse = baos.toString();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return strResponse;
	}

}
