package com.lpc.View;

import com.lpc.controller.UserController;
import com.lpc.pojo.Users;
import com.lpc.View.NormalUserView.*;

import static com.lpc.View.MainFrameView.showFrameMessage;
import static com.lpc.View.NormalUserView.showUsersMessage;

public class test {
    private static UserController userController = new UserController();
    public static void main(String[] args) throws Exception {
//        showFrameMessage();
        String telphone="15228116591";
        Users users = userController.selectByTelphone(telphone);

        showUsersMessage( users);
    }
}
