/**
 * This is the real object
 */
package com.adam.app.dynamic.proxy;

public class RealObject implements IInterface {

	@Override
	public void doSomething() {
		Utils.print(this, "[doSomething] enter");
		
	}

}
