package com.example.genericaccessormodule;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.StringTokenizer;

public class RunMessageCreationBatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			//Iterate over the args
			String filename = "";
			String outputDir = "";
			for( int i = 0
					; i < args.length
					; i++){
				switch(args[i]){
					case "--file": { 
						i++;
						if(i < args.length){
							filename = args[i];
						}
					}
					case "--dir":{
						i++;
						if(i < args.length){
							outputDir = args[i];
						}
					}
				}
			}
			
			File inputFile = new File(filename);
			File locOutputDir = new File(outputDir);
			
			if(!locOutputDir.exists()){
				locOutputDir.mkdirs();
			}
			
			if(inputFile.exists() && inputFile.isFile()){
				BufferedReader br = new BufferedReader(new FileReader(inputFile));
				String nextLine = "";
				Map<String, ArrayList<ArrayList<String>>> masterMap = new HashMap<String, ArrayList<ArrayList<String>>>();
				ArrayList<ArrayList<String>> currentFileList = new ArrayList<ArrayList<String>>();
				ArrayList<String> currentRowList = new ArrayList<String>();
				String outputFileName = "";
				while((nextLine = br.readLine()) != null){
					StringTokenizer tok = new StringTokenizer(nextLine,",");
					while(tok.hasMoreTokens()){
						String nextToken = tok.nextToken();
						switch(nextToken){
							case "GENFILENAME":{
								if(tok.hasMoreTokens()){
									outputFileName = tok.nextToken();
									if(masterMap.containsKey(outputFileName)){
										currentFileList = (ArrayList<ArrayList<String>>)masterMap.get(outputFileName);
										currentRowList = new ArrayList<String>();
									}else{
										currentFileList = new ArrayList<ArrayList<String>>();
										currentRowList = new ArrayList<String>();
									}
								}
								continue;
							}
							default: {
								String nameValuePair = nextToken;
								if(tok.hasMoreTokens()){
									nameValuePair = nameValuePair + "|" + tok.nextToken();
									currentRowList.add(nameValuePair);
								}
								continue;
							}
						}
					}
					currentFileList.add(currentRowList);
					masterMap.put(outputFileName, currentFileList);
				}
				
				br.close();
				
				for(Map.Entry<String, ArrayList<ArrayList<String>>> entry: masterMap.entrySet()){
					String presentFileName = entry.getKey();
					ArrayList<ArrayList<String>> presentFileContents 
									= (ArrayList<ArrayList<String>>)entry.getValue();
					String soapMessage = MessageCreator
											.createRetrieveInformationResponse("SUCCESS"
																			   , presentFileContents);
					soapMessage = soapMessage.replaceFirst("http://schemas.xmlsoap.org/soap/envelope/"
												, "http://www.w3.org/2003/05/soap-envelope");
					File presentFile = new File(locOutputDir,presentFileName);
					
					BufferedWriter bw = new BufferedWriter
												(new OutputStreamWriter
														(new FileOutputStream
																(presentFile)));
					bw.write(soapMessage);
					bw.flush();
					bw.close();
				}
				
			}else{
				System.out.println("File => " + filename + "is not readable");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
