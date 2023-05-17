package untitled.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import untitled.UserApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { UserApplication.class })
public class CucumberSpingConfiguration {}
