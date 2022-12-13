package com.example.SpringSecurityLearning;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.OverrideAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;
@AutoConfigureMockMvc
@WebMvcTest
public class MvcTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Order(1)
    @DisplayName("SpringSecurity未導入時、URIを実行したとき、成功（レスポンスは200）になる。。")
    public void givenNoSecurity_whenSendURI_thenStatusAccepted() throws Exception {
        // given-precondition or Setup

        //when - action or the behavior that we are going test
       var resultActions= mvc.perform(post("/api/test")
               .contentType(MediaType.APPLICATION_JSON)
               );
        //then - verify the output
        resultActions.andDo(print())
                .andExpect(jsonPath("$.age",is(21)))
                .andExpect(jsonPath("$.name",is("nick")))
                .andExpect(status().isOk()
                );
    }




}
