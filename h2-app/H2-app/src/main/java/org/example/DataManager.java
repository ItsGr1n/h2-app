package org.example;

import java.util.ArrayList;

public class DataManager {
	public ArrayList<Meme> memes = new ArrayList<Meme>();
	 
	public DataManager()
	{
		H2SelectExample select = new H2SelectExample();
		memes = select.getMemes();
	}
	
	public void printMemes()
	{
		for(Meme m : memes)
			System.out.println(m.toString());
	}
	
	public void addMeme(String memeName, int popularity)
	{
		int id = 0;
		for(Meme m : memes)
			if (m.memeId > id)
				id = m.memeId;
		id++;
		Meme newMeme = new Meme(id, memeName, popularity);
		H2InsertExample ins = new H2InsertExample();
		ins.addMeme(newMeme);
		memes.add(newMeme);
		System.out.println("Meme added!");
	}
	
	public Meme getMemeById(int memeId)
	{
		for(Meme m : memes)
			if (m.memeId == memeId)
				return m;
		return null;
	}
	
	public void deleteMeme(int memeId)
	{
		Meme toDelete = getMemeById(memeId);
		H2DeleteExample delete = new H2DeleteExample();
		delete.deleteMeme(memeId);
		memes.remove(toDelete);
	}
	
	public void updateMeme(Meme meme)
	{
		H2UpdateExample update = new H2UpdateExample();
		update.updateMeme(meme);
	}
	
	public Meme getFirstMeme()
	{
		return memes.get(0);
	}
}
