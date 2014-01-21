package chatbot.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import chatbot.controller.ChatbotController;
import chatbot.model.Chatbot;

/**
 * this class is the view for the chatbot.
 * 
 * @author jsmi6845
 */
public class ChatbotPanel extends JPanel
{
	private ChatbotController baseController;
	private Chatbot appBot;
	private SpringLayout baseLayout;
	private JButton submitChatButton;
	private JTextField userTextField;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	private int clickCount;

	/**
	 * this creates the subnitchatbutton, the baselayout, the usertextfield, the
	 * chatarea, and the chatpane, and sets up different methods. 
	 * @param baseController
	 */
	public ChatbotPanel(ChatbotController baseController)
	{
		this.baseController = baseController;
		this.appBot = baseController.getAppBot();

		submitChatButton = new JButton("Click here to type to the chatbot!");
		baseLayout = new SpringLayout();
		userTextField = new JTextField(30);
		chatArea = new JTextArea(10, 30);
		chatPane = new JScrollPane(chatArea);

		clickCount = 0;

		setupPanel();
		setupLayout();
		setupListeners();
		setupChat();
	}

	/**
	 * this creates the chat area in the chatbotpanel.
	 */
	private void setupChat()
	{
		chatArea.setText(appBot.getRandomTopic());
	}

	/**
	 * this sets up the panel and adds various things to make it work better.
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.ORANGE);

		this.add(submitChatButton);
		this.add(userTextField);
		this.add(chatPane);

		chatArea.setWrapStyleWord(true);
		chatArea.setLineWrap(true);
	}

	private void setupListeners()
	{
		/**
		 * Do this when the submitChatButton is clicked
		 */
		submitChatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				clickCount++;
				String userInput = userTextField.getText();

				if (clickCount % 7 == 0)
				{
					String currentPhrase = baseController
							.dominateTheConversation();
					if (currentPhrase.length() != 0)
					{
						chatArea.append("\n" + currentPhrase);
						clickCount--;
					}
				}
				else if(clickCount % 5 == 0)
				{
					chatArea.append(baseController.memeValidation(userInput));
				}
				
				else if(clickCount % 430 == 0)
				{
					chatArea.append(baseController.SBValidation(userInput));
				}
				else		
				{
					
					chatArea.append("\n" + userInput);
					userTextField.setText("");
					String processedInput = baseController.processUserInput(userInput);
					chatArea.append("\n" + processedInput);
					chatArea.append("\n" + appBot.getRandomTopic());
					chatArea.append("\n" + appBot.getRandomMeme());
					
					//This should be a method in the controller that would be returned as a string to place in the chatArea.
					String me, you, other;
					me = "Cody";
					you = "Ryan";
					other = "Devvin";
					chatArea.append(appBot.putNameInAlphabeticOrder(you, other, me));
				}
			}
		});
	}

	/**
	 * this sets up the positioning of various objects in the chatbot panel.
	 */
	private void setupLayout()
	{

		baseLayout.putConstraint(SpringLayout.NORTH, submitChatButton, 18,
				SpringLayout.SOUTH, userTextField);
		baseLayout.putConstraint(SpringLayout.WEST, userTextField, 95,
				SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, submitChatButton, 119,
				SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, userTextField, 18,
				SpringLayout.SOUTH, chatArea);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 18,
				SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 97,
				SpringLayout.WEST, this);
		

	}
}
