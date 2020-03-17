package com.amazon.step_definitions;

import com.amazon.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;


import java.util.concurrent.TimeUnit;

public class Hook {

    @Before
    public void setUp(){
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        Driver.close();
    }
}
