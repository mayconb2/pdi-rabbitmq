package com.abinbev.bees.pdiconsumer.controller;

import com.abinbev.bees.pdiconsumer.domain.Message;
import com.abinbev.bees.pdiconsumer.services.MessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.*;

@ExtendWith(MockitoExtension.class)
class MessageControllerTest {

    private static final String MESSAGE_API_URL_PATH = "/api/v1/messages";

    private MockMvc mockMvc;

    @Mock
    private MessageService service;

    @InjectMocks
    private MessageController controller;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
            .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
            .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
            .build();
    }


    @Test
    void whenGETListMessagesIsCalledThenOkStatusIsReturned() throws Exception {
        //given
        Message expectedMessage = new Message("123456789", "teste message");

        //when
        when(service.findAll()).thenReturn(Collections.singletonList(expectedMessage));

        //then
        mockMvc.perform(MockMvcRequestBuilders.get(MESSAGE_API_URL_PATH)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(expectedMessage.getId())))
                .andExpect(jsonPath("$[0].message", is(expectedMessage.getMessage())));
    }
}
