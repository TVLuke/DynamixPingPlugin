package org.ambientdynamix.contextplugins.ping;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.ambientdynamix.api.application.IContextInfo;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class PingContextInfo implements IContextInfo
{

	private final String TAG = "PINGPLUGIN";
	
	String id="";
	
	public static Parcelable.Creator<PingContextInfo> CREATOR = new Parcelable.Creator<PingContextInfo>() 
			{
			public PingContextInfo createFromParcel(Parcel in) 
			{
				return new PingContextInfo(in);
			}

			public PingContextInfo[] newArray(int size) 
			{
				return new PingContextInfo[size];
			}
		};
		
	PingContextInfo(String x)
	{
		Log.d(TAG, "create Current Time");
		this.id=x;
	}
	
	public PingContextInfo(Parcel in) 
	{
		id=in.readString();
	}

	@Override
	public String toString() 
	{
		return this.getClass().getSimpleName();
	}
	
	@Override
	public int describeContents() 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel out, int flags) 
	{
		out.writeString(id);
	}

	@Override
	public String getContextType() 
	{
		return "org.ambientdynamix.contextplugins.context.info.sample.ping";
	}

	@Override
	public String getImplementingClassname() 
	{
		return this.getClass().getName();
	}

	@Override
	public String getStringRepresentation(String format) 
	{
		String result="";
		if (format.equalsIgnoreCase("text/plain"))
		{
			return id;
		}
		else if (format.equalsIgnoreCase("XML"))
		{
			return "<ping>"+id+"</ping>";
		}
		else if (format.equalsIgnoreCase("JSON"))
		{
			return "ping: "+id;
		}
		else
			return null;
	}

	@Override
	public Set<String> getStringRepresentationFormats() 
	{
		Set<String> formats = new HashSet<String>();
		formats.add("text/plain");
		formats.add("XML");
		formats.add("JSON");
		return formats;
	}

}