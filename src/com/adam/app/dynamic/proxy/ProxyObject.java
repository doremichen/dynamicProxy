/**
 * This is the proxy of the real object
 */
package com.adam.app.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyObject {

	private IInterface mReal;
	
	public ProxyObject(IInterface real) {
		this.mReal = real;
	}
	
	public IInterface create() {
		Utils.print(this, "[create] enter");
		final Class<?>[] interfaces = new Class<?>[] {IInterface.class};
		ProxyHandler handler = new ProxyHandler(this.mReal);
		return (IInterface) Proxy.newProxyInstance(IInterface.class.getClassLoader(), interfaces, handler);
	}
	
	
	/**
	 *
	 * This is for handler of the proxy
	 *
	 */
	public static class ProxyHandler implements InvocationHandler {

		private IInterface mReal;
		
		public ProxyHandler(IInterface real) {
			this.mReal = real;
		}
		
		@Override
		public Object invoke(Object arg0, Method arg1, Object[] arg2)
				throws Throwable {
			Utils.print(this, "[invoke] enter");
			Utils.print(this, "----- before runing ---------");
			Object ret = arg1.invoke(mReal, arg2);
			Utils.print(this, "----- after runing ---------");
			return ret;
		}
		
	}
	
}

