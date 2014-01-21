package chatbot.view;

import javax.swing.JOptionPane;

import chatbot.model.Chatbot;

/**
 * GUI View for the Chatbot project
 * @author Jacob Smith
 */

public class ChatbotView
{
	/**
	 * Chatbot used for internal chat methods.
	 */
	private Chatbot myChatbot;
	
	public ChatbotView()
	{
		myChatbot = new Chatbot();
	}
	/**
	 * this sets a default input for input.
	 */
	public void showApp()
	{
		String input = "keep going";
		
		while(input == null || !input.equals("no"))
		{
			JOptionPane.showMessageDialog(null, myChatbot.getRandomTopic());
			input = getInput();
			useInput(input);
		}
		
		myChatbot.conversationPiece();
		
	}
	
	/**
	 * Captures the users input based on a question
	 * @return The String object typed by the user
	 */
	private String getInput()
	{
		String input = "";
		
		input = JOptionPane.showInputDialog("what do you want to talk about?");
		
		return input;
	}
	
	/**
	 * This uses the user input to talk about memes and/or Super Smash Bros characters.
	 * @param the parameters of this is the user input. 
	 */
	private void useInput(String userInput)
	{
		
		if(myChatbot.memeChecker(userInput))
		{
			JOptionPane.showMessageDialog(null, "I knew that " + userInput + " is a meme!!!!");
		}
		if(myChatbot.SBChecker(userInput))
		{
			JOptionPane.showMessageDialog(null, "I knew that " + userInput + " is a Super Smash Bros. Character" + "!!!!");
		}
		JOptionPane.showMessageDialog(null, "Wow that is so interesting that you want to talk with me about " + userInput);
	}
	
}
