/**
 * Team Project
 *
 * brief_description_of_the_program
 *
 * @author Gabe Turner, Archie Baldocchi, Huy Vu, Yanxin Yu, Zander Unger, L22
 * @version 28 March 2024
 */
public class Message {
    private UserInformation sender;
    private UserInformation receiver;
    private String content;
    public Message (UserInformation sender, UserInformation receiver, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }
}
