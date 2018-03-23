package be.cm.mredant;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication(scanBasePackages = {"be.cm.mredant"})
public class Application {

    public static void main(String[] args) {
        run(Application.class, args);
    }


}
