package gabs.encurtador.URL;

import gabs.encurtador.URL.service.EncurtarURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EncurtadorDeUrlApplication implements CommandLineRunner {

	@Autowired
	private EncurtarURL service;

	public static void main(String[] args) {
		SpringApplication.run(EncurtadorDeUrlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		service.encurtarUrl();
	}
}
