package untitled.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import untitled.FoodStoreApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { FoodStoreApplication.class })
public class CucumberSpingConfiguration {}
