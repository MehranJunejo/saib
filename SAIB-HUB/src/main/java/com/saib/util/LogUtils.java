package com.saib.util;

import java.sql.Timestamp;

import com.google.gson.Gson;
import com.saib.model.LogsModel;
import com.saib.rest.request.GetDetailsByBlzCodeRequest;

public class LogUtils {

	
	public static LogsModel getLogObject(GetDetailsByBlzCodeRequest code,String transactionId,String response,String serviceName,String applicationName)
	{
		LogsModel logsModel = new LogsModel();
		logsModel.setRequestData(new Gson().toJson(code));
		logsModel.setTransactionId("1");
		logsModel.setResponseData(new Gson().toJson(response));
		logsModel.setServiceName("BlzService");
		logsModel.setApplicationName(applicationName);
		logsModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));

		return logsModel;
	}
	
}
