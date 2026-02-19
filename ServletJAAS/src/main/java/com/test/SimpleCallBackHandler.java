package com.test;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

public class SimpleCallBackHandler implements CallbackHandler
{

	private final String username;
	private final String password;
	
	public SimpleCallBackHandler(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		
		for(Callback cb : callbacks)
		{
			if(cb instanceof NameCallback)
			{
				((NameCallback)cb).setName(username);
			}
			else if(cb instanceof PasswordCallback)
			{
				((PasswordCallback)cb).setPassword(password.toCharArray());
			}
			else
			{
				throw new UnsupportedCallbackException(cb);
			}
		}
		
	}

}
