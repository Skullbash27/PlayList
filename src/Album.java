import java.util.ArrayList;;

public class Album {
	
	private ArrayList<Song> songs;
	
	private String name;
	
	public Album(String name) {
		this.name = name;
		this.songs = new ArrayList<Song>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<Song> returnList() {
		return songs;
	}
	
	public void addSong(Song song) {
		songs.add(song);
	}
	
	public void printSongs() {
		for (int i=0; i<songs.size(); i++) {
			System.out.println((i+1) +"} " +songs.get(i).getTitle());
		}
	}
	
	public Song selectSong(int selection) {
		
		Song selectedSong = null;		
		for(int i=0; i<songs.size(); i++) {
			if ((i+1) == selection) {
				selectedSong = songs.get(i);
				break;
			}
		}		
		return selectedSong;
	}
	
	
}
