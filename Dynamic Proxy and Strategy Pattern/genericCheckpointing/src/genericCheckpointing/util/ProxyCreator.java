/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anurag_singh_assign6.genericCheckpointing.src.genericCheckpointing.util;
import anurag_singh_assign6.genericCheckpointing.src.genericCheckpointing.server.StoreRestoreI;

/**
 *
 * @author asingh72
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyCreator
{

	public StoreRestoreI createProxy(Class<?>[] interfaceArray, InvocationHandler handler){
		StoreRestoreI storeRestoreRef =
            (StoreRestoreI)
            Proxy.newProxyInstance(
                                   getClass().getClassLoader(),
                                   interfaceArray,
                                   handler
                                   );

		return storeRestoreRef;
	}
}