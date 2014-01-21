package chatbot.controller;

import java.util.ArrayList;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotFrame;
import chatbot.view.ChatbotView;
/**
 * The Controller for the chatbot
 * @author Jacob Smith
 */
public class ChatbotController
{
	/**
	 * the application frame for the Chatbot program
	 */
	private ChatbotFrame appFrame;
	/**
	 * The main chatbot for the application
	 */
	private Chatbot appBot;
	
	/**
	 * creates a chatbotcontroller and initializes the chatbot model instance
	 */
	public ChatbotController()
	{
		appBot = new Chatbot();
	}
	
	/**
	 * getter method for the chatbot instance.
	 * @return appbot
	 */
	
	public Chatbot getAppBot()
	{
		return appBot;
	}
	
	/**
	 * Initializes the ChatbotFrame for the GUI
	 * @return this returns the app frame as a chatbot frame.
	 */
	public void start()
	{
		appFrame = new ChatbotFrame(this);
	}
	/**
	 * this creates variable response and gives it a value depending on the currentInput value.
	 * @param currentInput
	 * @return this returns a response.l
	 */
	
	public String memeValidation(String currentInput)
	{
		String memeReaction = " why aren't you talking about the memes?";
		
		if(appBot.memeChecker(currentInput))
		{
			memeReaction = currentInput +  " is the coolest meme huh";
		}
		
		return memeReaction;
	}
	
	/**
	 * this checks for an sb character in the input of the chatbot.
	 * @param currentInput
	 * @return SBReaction
	 */
	public String SBValidation(String currentInput)
	{
		String SBReaction = " why aren't you talking about the Super Smash Bro's Characters?";
		
		if(appBot.SBChecker(currentInput))
		{
			SBReaction = currentInput + "is the coolest Character ever";
		}
				
		return SBReaction;
	}
	
	/**
	 * this tells the method to pull the phrases out of the list when the list size is greater than zero.
	 * @param currentList
	 * @return currentPhrase
	 */
	private String conversationHelper(ArrayList<String> currentList)
	{
		String currentPhrase = "";
		
		if(currentList.size() > 0)
		{
			currentPhrase = currentList.remove(0);
		}
		
		return currentPhrase;
	}
	
	/**
	 * this method sets a default answer for currentConversationPiece and tells the method where to go to get the real answers for conversationPiece 
	 * @return currentConversationPiece
	 */
	public String dominateTheConversation()
	{
		String currentConversationPiece = "";
		
		currentConversationPiece = conversationHelper(appBot.conversationPiece());
		
		return currentConversationPiece;
	}
	
	/**
	 * this method is used when the response or the user input in the chatbot is something that matches the items in either the memeChecker or the SBChecker and outputs a respnse.
	 * @param currentInput
	 * @return response
	 */
	public String processUserInput(String currentInput)
	{
		String response = "";
		
		if (appBot.memeChecker(currentInput))
		{
			response = "memes!!!!";
		}
		else if(appBot.SBChecker(currentInput))
		{
			response = "something";
		}
		return response;
	}
	
	
}


