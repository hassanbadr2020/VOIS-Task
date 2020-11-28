package stepDefinitions.hooks;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java8.En;

public class Hooks extends Base implements En {
    private Base base;

    public Hooks(Base base) {
        this.base = base;
    }

    @After
    public void afterScenario(Scenario scenario) {
        base.response.prettyPrint();
    }


}
