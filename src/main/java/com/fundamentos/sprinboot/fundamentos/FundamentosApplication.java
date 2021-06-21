package com.fundamentos.sprinboot.fundamentos;

import com.fundamentos.sprinboot.fundamentos.beans.Mybean;
import com.fundamentos.sprinboot.fundamentos.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	private ComponentDependency componentDependency;
	private Mybean myBean;

	public FundamentosApplication(@Qualifier("componentImplement2") ComponentDependency componentDependency, @Qualifier("mybeanImplement") Mybean myBean){
		this.componentDependency= componentDependency;
		this.myBean = myBean;
	}


	@Override
	public void run(String... args) {
		componentDependency.saludar();
		myBean.print();
	}
}
