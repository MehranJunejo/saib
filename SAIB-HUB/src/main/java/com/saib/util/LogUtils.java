package com.saib.util;

import java.sql.Timestamp;

import com.google.gson.Gson;
import com.saib.model.Logs;
import com.saib.rest.request.GetDetailsByBlzCodeRequest;

public class LogUtils {

	
	public static Logs getLogObject(GetDetailsByBlzCodeRequest code,String transactionId,String response,String serviceName,String applicationName)
	{
		Logs logs = new Logs();
		logs.setRequestData(new Gson().toJson(code));
		logs.setTransactionId("1");
		logs.setResponseData(new Gson().toJson(response));
		logs.setServiceName("BlzService");
		logs.setApplicationName(applicationName);
		logs.setCreatedDate(new Timestamp(System.currentTimeMillis()));

		return logs;
	}
	
}
