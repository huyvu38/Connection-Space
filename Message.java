import java.util.ArrayList;

/**
 * Team Project
 *
 * brief_description_of_the_program
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */

public class Message implements MessageInterface{
    public boolean sendMessage (String senderUserName, String receiverUserName, String content) {
        // TODO
        return false;

    }
    public boolean deleteMessage (String senderUserName, String receiverUserName, String content) {
        //TODO
        return false;

    }
    public boolean blockMessage (String userName, String otherUserName, ArrayList<String> blockList) {
        //TODO
        return false;


    }
    //Only send message to friends
    public boolean restrictMessage (String userName, String otherUserName, ArrayList<String> friendList) {
        return false;


    }

}