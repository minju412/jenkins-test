package com.example.jenkinstest.web;

import static org.hamcrest.Matchers.is;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.jenkinstest.springRestDoc.dto.CreateRequest;
import com.example.jenkinstest.springRestDoc.dto.UpdateRequest;
import com.example.jenkinstest.springRestDoc.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers // TestContainer
@ActiveProfiles("junit-test") // TestContainer
@AutoConfigureRestDocs // Spring REST Docs 자동 설정 어노테이션
@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserControllerTest {
    /*
     *  1. member 조회
     *  2. member 추가
     *  3. member 수정
     *  4. member 삭제
     *  5. member 전체 조회
     * */

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private MemberService memberService;

    @BeforeAll
    void init() {
        CreateRequest createRequest = new CreateRequest();
        createRequest.setName("john");
        createRequest.setYear(2);
        createRequest.setGrade("junior");

        memberService.createMember(createRequest);
    }


    @Order(1)
    @Test
    void getMemberTest() throws Exception {
        mockMvc.perform(get("/member/{name}", "john"))
                .andDo(print())
                .andDo(document("getMember"))
                .andExpect(jsonPath("$.name", is("john")));
    }

    @Order(2)
    @Test
    void createMemberTest() throws Exception {
        mockMvc.perform(post("/member")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .content("{\n" +
                                "    \"name\":\"jessi\",\n" +
                                "    \"grade\":\"junior\",\n" +
                                "    \"year\":2\n" +
                                "}"))
                .andDo(print())
                .andDo(document("createMember"))
                .andExpect(status().isOk());
    }

    @Order(3)
    @Test
    void updateMemberTest() throws Exception {
        UpdateRequest request = new UpdateRequest();
        request.setGrade("senior");
        request.setYear(7);

        mockMvc.perform(put("/member/{name}", "john")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andDo(print())
                .andDo(document("updateMember"))
                .andExpect(jsonPath("$.year", is(7)))
                .andExpect(jsonPath("$.grade", is("senior")));
    }

    @Order(5)
    @Test
    void deleteMemberTest() throws Exception {
        mockMvc.perform(delete("/member/{name}", "john"))
                .andDo(print())
                .andDo(document("deleteMember"))
                .andExpect(jsonPath("$.name", is("john")))
                .andExpect(status().isOk());
    }

    @Order(4)
    @Test
    void getAllMemberTest() throws Exception {
        mockMvc.perform(get("/members"))
                .andDo(print())
                .andDo(document("getAllMember"))
                .andExpect(status().isOk());
    }

}