package com.rmi.test;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyServiceImpl extends UnicastRemoteObject implements MyService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected MyServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public String service(String context) throws RemoteException{
		// TODO Auto-generated method stub
		return "server :"+context;
	}

}
