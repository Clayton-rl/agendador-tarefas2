package com.javanauta.agendadortarefas2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AgendadorTarefas2Application {

	public static void main(String[] args) {
		SpringApplication.run(AgendadorTarefas2Application.class, args);
	}

}
