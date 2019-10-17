package com.andersonmarques;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Main.class, args);
		abrirBrowser();
	}

	/**
	 * Método responsável por executar comandos no terminal, de acordo com o sistema
	 * operacional em que a JVM está rodando.
	 * 
	 * @author https://www.baeldung.com/run-shell-command-in-java
	 * @throws Exception
	 */
	private static void abrirBrowser() throws Exception {
		boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
		ProcessBuilder builder = new ProcessBuilder();
		System.out.println("Tentando iniciar browser e abrir página localhost:8081");
		if (isWindows) {
			builder.command("cmd.exe", "/c", "start http://localhost:8081");
		} else {
			builder.command("sh", "-c", "google-chrome http://localhost:8081");
		}
		builder.directory(new File(System.getProperty("user.home"))).start();
	}
}
