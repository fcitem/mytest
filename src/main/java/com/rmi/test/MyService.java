package com.rmi.test;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyService extends Remote{

	public String service(String context) throws RemoteException;
}
