import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.LinkedList;


public class App {
	
	private static Scanner scan = new Scanner(System.in);
	private static ArrayList<Album> album = new ArrayList<Album>();
	
	public static void main(String[] args) {
			
		Album albumOne = new Album("Rock");
		Album albumTwo = new Album("Pop");
		Album albumThree = new Album("Hip-Hop");		
		Song songOne = new Song("In the End", 3.24);
		Song songTwo = new Song("21 Guns", 3.31);
		Song songThree = new Song("We Will Rock You", 3.45);
		Song songFour = new Song("Lost in the Echo", 3.09);
		Song songFive = new Song("Closer", 3.10);
		Song songSix = new Song("Heart-Attack", 3.23);
		Song songSeven = new Song("Dark Horse", 3.05);
		Song songEight = new Song("Set Fire to the Rain", 3.05);
		Song songNine = new Song("Loose Yourself", 3.45);
		Song songTen = new Song("Uptown Funk", 3.35);
		Song songEleven = new Song("Temperature", 4.01);		
		album.add(albumOne);
		album.add(albumTwo);
		album.add(albumThree);
		albumOne.addSong(songOne);
		albumOne.addSong(songTwo);
		albumOne.addSong(songThree);
		albumOne.addSong(songFour);
		albumTwo.addSong(songFive);
		albumTwo.addSong(songSix);
		albumTwo.addSong(songSeven);
		albumTwo.addSong(songEight);
		albumThree.addSong(songNine);
		albumThree.addSong(songTen);
		albumThree.addSong(songEleven);
		boolean appOn = true;
		boolean positionFound = false;
		String songPlayed = "";
		boolean goingForward = true;
		boolean switched = true;
		boolean changeForward = false;
		boolean changeBackward = false;
		PlayList playlist = new PlayList("PlayList 1");
		while(appOn) {		
			ListIterator<Song> listIterator = playlist.getPlayList().listIterator();
			positionFound = false;
			
			if (!playlist.getPlayList().isEmpty() && switched) {
				if (changeForward) {
					while(listIterator.hasNext() && !positionFound) {
						if (songPlayed == listIterator.next().getTitle() ) {
							positionFound = true;
						} 
					}
				}
				if (changeBackward) {
					while(listIterator.hasNext() && !positionFound) {
						if (songPlayed == listIterator.next().getTitle() ) {
							positionFound = true;
							goingForward = true;
						}
					}
				}
			}
			
			printMenu();
			System.out.println("Enter the option you want to select:");
			int option = scan.nextInt();
			
			switch(option) {
				case 1:
					showList(playlist);
					break;
				
				case 2:
					addMusic(playlist);
					songPlayed = playlist.getPlayList().get(0).getTitle();
					break;
					
				case 3:				
					showList(playlist);
					System.out.println("Enter Song Number to Play");
					int selected = scan.nextInt();
					songPlayed = playlist.playSong(selected);
					changeForward = true;
					break;
					
				case 4:
					if(!playlist.getPlayList().isEmpty()) {
						if(!goingForward) {
							if (listIterator.hasNext()) {
								listIterator.next();
							}
							goingForward = true;
						}
						if(listIterator.hasNext()) {
							songPlayed = listIterator.next().getTitle();
							System.out.println("Now Playing " +songPlayed +" ...." );
							switched = true;
							changeForward = true;
						} else {
							System.out.println("Reached the End of the playlist Or there are no Songs in the Playlist");
							goingForward = false;
						}
					} else {
						System.out.println("There are no songs in the PlayList");
					}
					break;
		
				case 5:
					if (!playlist.getPlayList().isEmpty()) {
						if(goingForward) {
							if (listIterator.hasPrevious()) {
								listIterator.previous();
							}
							goingForward = false;
						}
					
						if(listIterator.hasPrevious()) {
							songPlayed = listIterator.previous().getTitle();
							System.out.println("Now Playing " +songPlayed +"....");
							changeForward = false;
							changeBackward = true;
						} else {
							System.out.println("Reached the Start of the List");
							switched = false;
							goingForward = true;
						}
					} else {
						System.out.println("There are no songs in the PlayList");
					}
					break;
					
				case 6:	
					if(listIterator.hasPrevious()) {
						songPlayed = listIterator.previous().getTitle();
						System.out.println("Now Playing " +songPlayed +".....");
						goingForward = false;
						changeBackward = true;
						changeForward = false;
					} else {
						System.out.println("No Song Playing Currently");
						goingForward = true;
					}
					break;
					
				case 7:
					showList(playlist);
					System.out.println("Enter Song Number to Remove");
					int removeNo = scan.nextInt();
					playlist.removeSong(removeNo);
					break;
					
				case 8:
					printMenu();
					break;
					
				case 9:
					appOn = false;
					break;				
			}
		}
	}
	
	
	public static void printMenu() {
		
		System.out.println("1. Show PlayList");
		System.out.println("2. Add song to Playlist");
		System.out.println("3. Select Song to Play");
		System.out.println("4. Skip to Next Song");
		System.out.println("5. Move back to Previous Song");
		System.out.println("6. Play Current Song again");
		System.out.println("7. Remove Song from PlayList");
		System.out.println("8. Print Menu");
		System.out.println("9. Exit Program");
	}
	
	public static void showList(PlayList list) {
		
		for(int i=0; i<list.getPlayList().size(); i++) {
			System.out.println((i+1) +"} " +list.getPlayList().get(i).getTitle() +"\n");		
		}	
	}
	
	public static void addMusic(PlayList list) {
		
		int selection;
		int songNo;
		System.out.println("Enter Album No from where you want the song");
		printAlbum();
		selection = scan.nextInt();
		
		for (int i=0; i<album.size(); i++) {			
			if ((i+1) == selection) {	
				System.out.println("The number of songs here " +album.get(i).returnList().size());
				System.out.println("Enter the Song No you want");
				album.get(i).printSongs();	
				songNo = scan.nextInt();
				list.getPlayList().add(album.get(i).selectSong(songNo));
				System.out.println("The Song " +album.get(i).selectSong(songNo).getTitle() +" has been added to the PlayList");
				break;
			}					
			
		}
	}
	
	public static void printAlbum() {
		
		int listSize = album.size();	
		for (int i=0; i<listSize; i++) {
			System.out.println((i+1) +"} " +album.get(i).getName());
		}	
	}	
}