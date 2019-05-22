import com.AppBoot;
import com.Model.Unit;
import com.dao.UnitRepository;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,classes = AppBoot.class)
public class TestControllers {

    @Autowired
    private WebApplicationContext context;
    @Autowired
    UnitRepository rep;
    private JsonObject json = new JsonObject();
    private MockMvc mockMvc;
    private final String email = "mock@test.com";
    private final String test_text = "Hello by test";

    @Before
    public void init(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        json.addProperty("email",email);
        System.out.println("JSON here -> " + json.toString());
    }

    @Test
    public void CheckStatus() throws Exception {
        mockMvc.perform(get("/status")).andExpect(status().isOk());
    }

    //Check for sending email
    @Test
    public void CheckAuthController() throws Exception {
        mockMvc.perform(post("/auth")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json.toString()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    //Check for saving units to db
    @Test
    public void checkPutDataController() throws Exception {
        Unit unit = rep.findByEmail(email);
        unit.setData(test_text);
        //rep.save(unit);
        String out = new Gson().toJson(unit);
        mockMvc.perform(put("/data")
        .contentType(MediaType.APPLICATION_JSON)
        .content(out))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.data").value(unit.getData()));
    }

    //Check for getting units
    @Test
    public void checkPostDataController() throws Exception {
        Unit unit = rep.findByEmail(email);
        String token = unit.getToken();
        json.addProperty("token",token);
        mockMvc.perform(post("/data")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json.toString()))
                .andDo(print())
                .andExpect(jsonPath("$.data").value(test_text));

    }
}

