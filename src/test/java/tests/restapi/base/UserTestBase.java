package tests.restapi.base;

import tests.restapi.models.bodies.UserBody;
import utils.PropertiesUtil;

public class UserTestBase {

    private static final UserBody userBody = new UserBody();

    protected static final String NAME = PropertiesUtil.getProperty("name");
    protected static final String JOB = PropertiesUtil.getProperty("job");

    public UserBody setUserBody(String name, String job){
        userBody.setName(name);
        userBody.setJob(job);
        return userBody;
    }
}
