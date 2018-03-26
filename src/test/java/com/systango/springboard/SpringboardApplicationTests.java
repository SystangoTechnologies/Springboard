package com.systango.springboard;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertNotNull;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringboardApplication.class)
public class SpringboardApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webContext;

    @Test
    public void contextLoads() {
    }

    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webContext)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void login_invalidUser() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", "user");
        params.add("password", "random");

        ResultActions result
                = mockMvc.perform(post("/login")
                .params(params)
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void login_validUser() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", "user");
        params.add("password", "password");

        ResultActions result
                = mockMvc.perform(post("/login")
                .params(params)
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk());

        String authHeader = result.andReturn().getResponse().getHeader("Authorization");
        assertNotNull(authHeader);
    }

    @Test
    public void login_invalidAdmin() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", "admin");
        params.add("password", "random");

        ResultActions result
                = mockMvc.perform(post("/login")
                .params(params)
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void login_validAdmin() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", "admin");
        params.add("password", "password");

        ResultActions result
                = mockMvc.perform(post("/login")
                .params(params)
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk());

        String authHeader = result.andReturn().getResponse().getHeader("Authorization");
        assertNotNull(authHeader);
    }

    @Test
    public void getFaqs_unauthenticatedUser() throws Exception {
        mockMvc.perform(get("/v1/about/faq"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    public void getFaqs_authenticatedUser() throws Exception {
        String bearer = obtainAccessToken("user", "password");
        assertNotNull(bearer);
        mockMvc.perform(get("/v1/about/faq")
                .header("Authorization", bearer))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getWalletDetails_authenticatedUser() throws Exception {
        String bearer = obtainAccessToken("user", "password");
        assertNotNull(bearer);
        mockMvc.perform(get("/v1/payment/wallet/{username}", "user")
                .header("Authorization", bearer))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Method that obtains the JWT token corresponding to the passed username/pwd
     *
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    private String obtainAccessToken(String username, String password) throws Exception {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", username);
        params.add("password", password);

        ResultActions result
                = mockMvc.perform(post("/login")
                .params(params)
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk());

        String authHeader = result.andReturn().getResponse().getHeader("Authorization");
        return authHeader;
    }


}
