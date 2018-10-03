package operationAdapter;


public class MediaAdapter implements MediaPlayer {

	AdvancedMediaPlayer advancedMediaPlayer;
	
	
	public void play(String type, String fileName) {
		
		if(type.equals("mp4")){
			advancedMediaPlayer = new Mp4Player();
			advancedMediaPlayer.playMp4(fileName);
		}else if (type.equals("vlc")) {
			advancedMediaPlayer = new VlcPlayer();
			advancedMediaPlayer.playVlc(fileName);
		}else if (type.equals("mp3")) {
			new MediaPlayImpl().play(type, fileName);
		}else {
			System.err.println("Unsupport Type!");
		}
		
	}

}
