package com.fundamentos.sprinboot.fundamentos.beans;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency {

	private MyOperation myOperation;

	public MyBeanWithDependencyImplement(MyOperation myOperation) {
		super();
		this.myOperation = myOperation;
	}

	@Override
	public void printWithDependency() {
		int numero = 3;
		System.out.println(myOperation.sumar(numero));
		// TODO Auto-generated method stub
		System.out.println("Hola!, desde la implementacion de un Bean con dependencia");

	}
	
	

}
