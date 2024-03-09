package org.example;

public class Meme {
	public int memeId;
	

	public String memeName;
	public int popularity;
	
	public Meme(int memeId, String memeName, int popularity)
	{
		this.memeId = memeId;
		this.memeName = memeName;
		this.popularity = popularity;
	}
	
	@Override
	public String toString() {
		return "Meme [memeId=" + memeId + ", memeName=" + memeName + ", popularity=" + popularity + "]";
	}
}
