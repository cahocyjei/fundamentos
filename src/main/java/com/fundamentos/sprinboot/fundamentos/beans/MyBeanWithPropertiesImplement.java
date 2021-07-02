package com.fundamentos.sprinboot.fundamentos.beans;


public class MyBeanWithPropertiesImplement implements MyBeanWithProperties {

	
	private String name;
	private String apellido;
	
	public MyBeanWithPropertiesImplement(String name, String apellido) {
		this.name = name;
		this.apellido = apellido;
	}



	@Override
	public String Properties() {
		// TODO Auto-generated method stub
		return "Soy: "+ name + " "+ apellido;
	}

}
