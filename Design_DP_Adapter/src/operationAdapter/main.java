package operationAdapter;

/**
 * 需求：
 * 已有接口MediaPlay播放 mp3
 * AdVanceMediaPlay播放 Vlc mp4
 * 
 * 在不改变调用者的情况下
 * 新的接口audioplay播放vlc mp4 mp3格式
 * 
 * @author Administrator
 *
 */
public class main {

	public static void main(String[] args) {
		
		/*new MediaPlayImpl().play("mp3", "test");
		new AdvanceMediaPlayerImpl().playMp4("test");
		new AdvanceMediaPlayerImpl().playVlc("test");*/
		
		//===================================================//
		
		
		AudioPlayer audioPlayer = new AudioPlayer();
		audioPlayer.setAdapter(new MediaAdapter());
		
	    audioPlayer.play("mp3", "beyond the horizon.mp3");
	    audioPlayer.play("mp4", "alone.mp4");
	    audioPlayer.play("vlc", "far far away.vlc");
	    audioPlayer.play("avi", "mind me.avi");
	}

}
