package operationAdapter;

public class MediaPlayImpl implements MediaPlayer {

	public void play(String type, String fileName) {
		System.out.println("play:"+type+",fileName:"+fileName);
	}

}
