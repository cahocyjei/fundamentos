package com.fundamentos.sprinboot.fundamentos.configuration;

import com.fundamentos.sprinboot.fundamentos.beans.MyBeanWithDependency;
import com.fundamentos.sprinboot.fundamentos.beans.MyBeanWithDependencyImplement;
import com.fundamentos.sprinboot.fundamentos.beans.MyOperation;
import com.fundamentos.sprinboot.fundamentos.beans.MyOperationImplement;
import com.fundamentos.sprinboot.fundamentos.beans.Mybean;
import com.fundamentos.sprinboot.fundamentos.beans.MybeanImplement;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {

    @Bean
    public Mybean operationBean(){
        return new MybeanImplement();
    }
    
    @Bean
    public MyOperation myOperation() {
    	return new MyOperationImplement();
    }
    
    @Bean
    public MyBeanWithDependency beanOperationImplement(MyOperation myOperation) {
    	return new MyBeanWithDependencyImplement(myOperation);
    }
    
   @Bean
    public DataSource datasource() {
    	DataSourceBuilder datasourceBuilder = DataSourceBuilder.create();
    	datasourceBuilder.driverClassName("org.h2.Driver");
    	datasourceBuilder.url("jdbc:h2:mem:testdb");
    	datasourceBuilder.username("root");
    	datasourceBuilder.password("");
    	
    	return datasourceBuilder.build();
    }
}
