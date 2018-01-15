/**
 * This is main class
 */
package com.adam.app.dynamic.proxy;

public class Execute {

	public static void main(String[] args) {
		
		IInterface realObject = new RealObject();
		ProxyObject proxy = new ProxyObject(realObject);
		
		// Start dynamic proxy function
		proxy.create().doSomething();

	}

}

