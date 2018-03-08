package com.bigwanggang;

import com.bigwanggang.domain.WiselyMessage;
import com.bigwanggang.domain.WiselyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class WsController {

    private GameStatus status = GameStatus.PREPARE;


    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message) throws Exception {
        Thread.sleep(3000);
        return new WiselyResponse("Welcome, " + message.getName() + "!");
    }

    @Autowired
    private SimpMessagingTemplate messagingTemplate;//1
    @Autowired
    private PlayPlaneService playPlaneService;

    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) { //2
        switch (status) {
            case PREPARE:
                if (msg.startsWith("Ready")) {
                    System.out.println(msg);
                    Point head = Util.getPoint(msg);
                    String userName = principal.getName();

                    playPlaneService.addHead(userName, head);

                    if (userName.equals("wyf")) {
                        playPlaneService.setPlayer1Ready(true);
                    }
                    if (userName.equals("wisely")) {
                        playPlaneService.setPlayer2Ready(true);
                    }
                    if (playPlaneService.isGameBegin()) {
                        messagingTemplate.convertAndSendToUser("wyf",
                                "/queue/notifications", "GAME BEGIN");
                        messagingTemplate.convertAndSendToUser("wisely",
                                "/queue/notifications", "GAME BEGIN");
                        messagingTemplate.convertAndSendToUser("wyf",
                                "/queue/notifications", "YourTurn");
                        status = GameStatus.INGAME;
                    }
                }
                break;
            case INGAME:
                String userName = principal.getName();
                Point p = Util.getPoint(msg);
                if ("wyf".equals(userName)) {
                    messagingTemplate.convertAndSendToUser("wisely",
                            "/queue/notifications", "YourTurn");
                } else if ("wisely".equals(userName)){
                    messagingTemplate.convertAndSendToUser("wyf",
                            "/queue/notifications", "YourTurn");
                }
                break;
        }
        System.out.println(status);

//        if (principal.getName().equals("wyf")) {//3
//            messagingTemplate.convertAndSendToUser("wisely",
//                    "/queue/notifications", principal.getName() + "-send:"
//                            + msg);
//        } else {
//            messagingTemplate.convertAndSendToUser("wyf",
//                    "/queue/notifications", principal.getName() + "-send:"
//                            + msg);
//        }
    }
}
