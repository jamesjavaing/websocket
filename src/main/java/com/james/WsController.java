package com.james;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 何强
 * date 2017/4/17
 * description
 */
@Controller
public class WsController {
    @MessageMapping("/welcome")//@MessageMapping和@RequestMapping功能类似，用于设置URL映射地址，浏览器向服务器发起请求，需要通过该地址
    @SendTo("/topic/getResponse")//如果服务器接受到了消息，就会对订阅了@SendTo括号中的地址传送消息。
    public WiselyResponse say(WiselyMessage message) throws Exception {
        return new WiselyResponse("Welcome, " + message.getName() + "!");
    }

    @RequestMapping("/index")
    public String simplews(){
        return "simplews";
    }

    @RequestMapping("/ws")
    public String ws(){
        return "ws";
    }

}
