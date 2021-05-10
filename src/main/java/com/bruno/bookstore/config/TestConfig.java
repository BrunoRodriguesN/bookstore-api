package com.bruno.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bruno.bookstore.service.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	//Sempre que startar a aplicacao ira subir o método abaixo
	@Bean
	public void instanciaBaseDeDados() {
		this.dbService.instanciaBaseDeDados();
	}
	
	

}
