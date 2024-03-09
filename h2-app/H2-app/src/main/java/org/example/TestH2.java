package org.example;

public class TestH2 {

	public static void main(String[] args) {
		//Create table
		//uncomment to create new
		H2CreateExample create = new H2CreateExample();
		create.createTable();
		DataManager dm = new DataManager();
		System.out.println("All memes: ");
		dm.printMemes();
        System.out.println("Adding a meme: ");
        dm.addMeme("Kapot", 10);
        System.out.println("Deleting a meme: ");
        Meme m = dm.getFirstMeme();
        dm.deleteMeme(m.memeId);
        System.out.println("Updating a meme: ");
        m = dm.getFirstMeme();
        m.popularity += 10;
        dm.updateMeme(m);
        System.out.println("Getting memes from database again: ");
        dm = new DataManager();
        System.out.println("Updated memes: ");
        dm.printMemes();
        
        
	}

}
