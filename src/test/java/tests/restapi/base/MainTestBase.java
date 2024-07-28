package tests.restapi.base;

import tests.restapi.models.bodies.LoginBody;
import utils.PropertiesUtil;

public class MainTestBase {

    protected static final String EMAIL = PropertiesUtil.getProperty("email");
    protected static final String PASSWORD = PropertiesUtil.getProperty("password");
    protected static final String TOKEN = PropertiesUtil.getProperty("token");
    protected static final String NAME = PropertiesUtil.getProperty("name");
    protected static final String JOB = PropertiesUtil.getProperty("job");

}
