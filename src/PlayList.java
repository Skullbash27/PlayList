import java.util.LinkedList;
import java.util.ListIterator;
import java.util.ArrayList;


public class PlayList {
	
	private LinkedList<Song> playlist;
	
	private String name;
	
	
	public PlayList(String name) {
		playlist =  new LinkedList<Song>();
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public LinkedList<Song> getPlayList() {
		return playlist;
	}
	
	public void removeSong(int value) {
		
		for (int i=0; i<playlist.size(); i++) {
			if ((i+1) == value) {
				System.out.println("The song " +playlist.get(i).getTitle() +" has been removed");
				playlist.remove(i);
				break;
			} 	
		}	
	}
	
	public String playSong(int SongNo) {
		
		String selectedSong = "";
		for (int i=0; i<playlist.size(); i++) {
			if ((i+1) == SongNo) {
				System.out.println("Now Playing " +playlist.get(i).getTitle() +"...\n");
				selectedSong = playlist.get(i).getTitle();
				break;
			}
		}
		return selectedSong;
	}
	
}
