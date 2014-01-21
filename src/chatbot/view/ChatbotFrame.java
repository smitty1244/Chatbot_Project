package chatbot.view;

import javax.swing.JFrame;

import chatbot.controller.ChatbotController;
/**
 * this class constructs the frame for the chatbotpanel.
 * @author jsmi6845
 */

/**
 *this class creates the frame to hold the panel.
 */
public class ChatbotFrame extends JFrame
{
	private ChatbotController baseController;
	private ChatbotPanel basePanel;

	public ChatbotFrame(ChatbotController baseController)
	{
		this.baseController = baseController;
		basePanel = new ChatbotPanel(baseController);

		setupFrame();
	}

	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(500, 500);
		this.setVisible(true);
	}
}
