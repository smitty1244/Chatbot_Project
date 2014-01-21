package chatbot.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * this is the model for the chatbot.
 * @author Jacob Smith
 * @version 1.6 10/30/13
 */
public class Chatbot
{
	/**
	 * this provides a list for the memes that i want to talk about.
	 */
	private ArrayList<String> myMemes;
	/**
	 * this provides a list for the Super Smash Bros characters that i want to
	 * talk about.
	 */
	private ArrayList<String> mySB;

	/**
	 * this makes the lists of memes and characters available for all classes to
	 * call.
	 */
	private ArrayList<String> myRandomList;
/**
 * this creates and starts thes lists for meme list, sblist, and randomlist
 */
	
	private ArrayList<String> conversationList;
	
	public Chatbot()
	{
		myMemes = new ArrayList<String>();
		mySB = new ArrayList<String>();
		myRandomList = new ArrayList<String>();
		conversationList = new ArrayList<String>();

		fillTheMemeList();
		fillTheSBList();
		fillTheRandomList();
		fillTheConversationList();
	}

	/**
	 * this fills the list of random things.
	 */
	private void fillTheRandomList()
	{
		myRandomList.add("penguins");
		myRandomList.add("I have to say something random?");
		myRandomList.add("You don't want that?");
		myRandomList.add("cat");
	}

	/**
	 * this gets a random topic from the random list.
	 * 
	 * @return this returns a random topic from the random list.
	 */
	public String getRandomTopic()
	{
		String randomTopic = "";

		double myRandomNumber = Math.random();
		int myRandomListPosition = (int) (myRandomNumber * myRandomList.size());
		randomTopic = myRandomList.get(myRandomListPosition);

		return randomTopic;
	}
	
/**
 * this starts the randommeme generator
 * @return this returns a random meme to the panel.
 */
	public String getRandomMeme()
	{
		String randomMeme = "";
		double myRandomNumber = Math.random();
		int myMemeListPosition = (int) (myRandomNumber * myMemes.size());
		randomMeme = myRandomList.get(myMemeListPosition);

		return randomMeme;
	}

	/**
	 * this is all the items in the super smash bros characters list
	 */
	private void fillTheSBList()
	{
		mySB.add("Captain Falcon");
		mySB.add("Donkey Kong");
		mySB.add("Jigglypuff");
		mySB.add("Kirby");
		mySB.add("Link");
		mySB.add("Ness");
		mySB.add("mario");
		mySB.add("luigi");
		mySB.add("yoshi");
		mySB.add("pikachu");
		mySB.add("Samus");
		mySB.add("Bowser");
	}

	/**
	 * 
	 * @param the
	 *            parameters of this are the Super Smash Bros Characters that i
	 *            mentioned in the list above.
	 * @return this returns whether the Super Smash Bros Character that the user
	 *         mentioned is on the list.
	 */
	public boolean SBChecker(String currentChar)
	{
		boolean isSBChar = false;

		if (currentChar != null)
		{
			for (String currentChars : mySB)
			{
				if (currentChar.equalsIgnoreCase(currentChars))
				{
					isSBChar = true;
				}
			}
		}
		return isSBChar;
	}
	/**
	 * this returns text output that says wooo scary or booring depending on the processed string value.
	 * @param current
	 * @return
	 */
	public String usesContent(String current)
	{
		String processedString = "";
		if(current.contains("boo"))
		{
			processedString = "wooo scary";
		}
		else
		{
			processedString = "booring";	
		}
		return processedString;
	}

	/**
	 * this is the list of memes that i want to talk about.
	 */
	private void fillTheMemeList()
	{
		myMemes.add("my jammies are rustled");
		myMemes.add("grumpy cat");
		myMemes.add("troll dad");
		myMemes.add("icanhasacheeseburger?");
	}

	/**
	 * 
	 * @param the
	 *            parameters of this are any of the memes that i chose to talk
	 *            about.
	 * @return this returns that any of the memes that the user decided to talk
	 *         about is a meme that i want to talk about.
	 */
	public boolean memeChecker(String currentPhrase)
	{
		boolean isMeme = false;

		if (currentPhrase != null)
		{
			for (String currentMeme : myMemes)
			{
				if (currentPhrase.equalsIgnoreCase(currentMeme))
				{
					isMeme = true;
				}
			}
		}
		return isMeme;
	}

	/**
	 * this organizes variables first, last, and middle, depending on their lexicographical order.
	 * @param first
	 * @param middle
	 * @param last
	 * @return this returns the variables organized lexicographically.
	 */
	public String putNameInAlphabeticOrder(String first, String middle,
			String last)
	{
		String sortedName = "";

		if (first.compareTo(middle) < 0)
		{
			if (first.compareTo(last) < 0)
			{
				if (middle.compareTo(last) < 0)
				{
					sortedName = first + ", " + middle + ", " + last;
				}
				else
				{
					sortedName = first = ", " + last + ", " + middle;
				}
			}
			else
			{
				sortedName = last + ", " + first + ", " + middle;
			}
		}
		else
		{
			if (middle.compareTo(last) < 0)
			{
				if(last.compareTo(first) < 0)
				{
					sortedName = middle + "," + last + "," + middle;
				}
				else{
					sortedName = middle +"," + first + "," + last;
				}
			}
			else
			{
				sortedName = last +"," + middle + "," + first;
			}
		}

		return sortedName;
	}

	/**
	 * this is a conversation piece to further the of the chatbot.
	 */
	//public ArrayList<String> conversationPiece()
	{
		// Must have at least 3 lines of interaction with the user aka
		// JOptionPane.showInputDialog
		// conversation piece = movies

//		String FMovie = JOptionPane
//				.showInputDialog("What's up dude? what is your favorite movie?");
//		String answer = JOptionPane
//				.showInputDialog("Dude!!!! How could you possibly like "
//						+ FMovie
//						+ "!!!! that movie is the worst movie ever. Do you like Toy Story?");
//		if (answer.equalsIgnoreCase("yes"))
//		{
//			JOptionPane
//					.showMessageDialog(
//							null,
//							"you have got to be my favorite pesron in the world, that i have talked to, today, from this class period.");
//		}
//		else if (answer.equalsIgnoreCase("no"))
//			;
//		{
//			JOptionPane.showMessageDialog(null, "you have no honor");
//		}
//		
		
	}
	
	/**
	 * this fills the list for the conversation piece with strings of text.
	 */
	private void fillTheConversationList()
	{
	conversationList.add("What's up dude? what is your favorite movie?");
	conversationList.add("Dude!!!! How could you possibly like that movie!!!! that movie is the worst movie ever. Do you like Toy Story?");
	conversationList.add("");
	conversationList.add("");
	conversationList.add("");
	}
	
	/**
	 * this method just returns the conversation list for other methods to use.
	 * @return conversationList
	 */
	public ArrayList<String> conversationPiece()
	{
		return conversationList;
	}

}
