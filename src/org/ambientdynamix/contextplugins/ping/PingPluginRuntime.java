package org.ambientdynamix.contextplugins.ping;

import java.util.Date;
import java.util.UUID;

import org.ambientdynamix.api.contextplugin.*;
import org.ambientdynamix.api.contextplugin.security.PrivacyRiskLevel;
import org.ambientdynamix.api.contextplugin.security.SecuredContextInfo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


public class PingPluginRuntime extends AutoReactiveContextPluginRuntime
{
	private final String TAG = "PINGPLUGIN";
	private static PingPluginRuntime context;

	@Override
	public void start() 
	{
		/*
		 * Nothing to do, since this is a pull plug-in... we're now waiting for context scan requests.
		 */
		context=this;
		Log.i(TAG, "Started!");
	}

	@Override
	public void stop() 
	{
		/*
		 * At this point, the plug-in should cancel any ongoing context scans, if there are any.
		 */
		Log.i(TAG, "Stopped!");
	}

	@Override
	public void destroy() 
	{
		/*
		 * At this point, the plug-in should release any resources.
		 */
		stop();
		Log.i(TAG, "Destroyed!");
	}

	@Override
	public void updateSettings(ContextPluginSettings settings) 
	{
		// Not supported
	}

	@Override
	public void handleContextRequest(UUID requestId, String contextInfoType) 
	{
		//SecuredContextInfo aci= new SecuredContextInfo(new PingContextInfo(requestId.toString()), PrivacyRiskLevel.LOW);
		//sendContextEvent(requestId, aci);
		context=this;
	}

	@Override
	public void handleConfiguredContextRequest(UUID requestId, String contextInfoType, Bundle scanConfig) 
	{
		Date d = new Date();
		Log.d(TAG, "received Request: "+d.getTime());
		String id = scanConfig.getString("id");
		SecuredContextInfo aci= new SecuredContextInfo(new PingContextInfo(id), PrivacyRiskLevel.LOW);
		sendContextEvent(requestId, aci);
		d = new Date();
		Log.d(TAG, "Send Context: "+d.getTime());
		context=this;
	}

	@Override
	public void init(PowerScheme arg0, ContextPluginSettings arg1) throws Exception 
	{
		Log.d(TAG, "init");
		context=this;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPowerScheme(PowerScheme arg0) throws Exception 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doManualContextScan() 
	{
		// TODO Auto-generated method stub
		
	}

}