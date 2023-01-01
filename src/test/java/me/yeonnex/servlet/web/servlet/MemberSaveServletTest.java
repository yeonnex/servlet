package me.yeonnex.servlet.web.servlet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
class MemberSaveServletTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("회원을 저장한다")
    void saveMember() throws Exception {

    }
}