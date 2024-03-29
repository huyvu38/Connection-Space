/**
 * Team Project
 *
 * brief_description_of_the_program
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */
public class Message {
    private String userNameSender;
    private String userNameReceiver;
    private String content;

    public Message(String userNameSender, String userNameReceiver, String content) {
        this.userNameSender = userNameSender;
        this.userNameReceiver = userNameReceiver;
        this.content = content;
    }
}
