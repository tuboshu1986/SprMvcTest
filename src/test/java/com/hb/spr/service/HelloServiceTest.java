package com.hb.spr.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.hb.cfg.CustomMvcConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={CustomMvcConfig.class})
@WebAppConfiguration("src/main/resources")
public class HelloServiceTest {
    private MockMvc mockMvc;
    
    @Autowired
    private HelloService helloService;
    
    @Autowired
    private WebApplicationContext context;
    
    @Autowired
    private MockHttpSession session;

    @Autowired
    private MockHttpServletRequest request;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(getContext()).build();
    }
    
    @Test
    public void testNormalController() throws Exception{
        String str = mockMvc.perform(MockMvcRequestBuilders.get("/hello/str")).
            andExpect(MockMvcResultMatchers.status().isOk()). //期望返回状态为200
            andExpect(MockMvcResultMatchers.view().name("hello")).//期望返回视图名称为hello
            andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/classes/views/hello.jsp")).//期望目标转发页面为hello.jsp
            andExpect(MockMvcResultMatchers.model().attribute("hello", this.helloService.returnHello())).//期望model中包含hello的值为returnHello的返回值
            andDo(MockMvcResultHandlers.print()).andReturn().getResponse().getContentAsString();//将响应数据转换为字符串
        
        System.out.println(str);
    }
    
    @Test
    public void testRestController() throws Exception{
        String str = mockMvc.perform(MockMvcRequestBuilders.get("/restHello/str")).
            andExpect(MockMvcResultMatchers.status().isOk()).
            andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8")).
            andExpect(MockMvcResultMatchers.content().string(this.helloService.returnHello())).
            andDo(MockMvcResultHandlers.print()).andReturn().getResponse().getContentAsString();//将响应数据转换为字符串
        
        System.out.println(str);
    }
    
    public MockMvc getMockMvc()
    {
        return mockMvc;
    }

    public void setMockMvc(MockMvc mockMvc)
    {
        this.mockMvc = mockMvc;
    }

    public HelloService getHelloService()
    {
        return helloService;
    }

    public void setHelloService(HelloService helloService)
    {
        this.helloService = helloService;
    }

    public WebApplicationContext getContext()
    {
        return context;
    }

    public void setContext(WebApplicationContext context)
    {
        this.context = context;
    }

    public MockHttpSession getSession()
    {
        return session;
    }

    public void setSession(MockHttpSession session)
    {
        this.session = session;
    }

    public MockHttpServletRequest getRequest()
    {
        return request;
    }

    public void setRequest(MockHttpServletRequest request)
    {
        this.request = request;
    }
}
