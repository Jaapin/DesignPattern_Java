package operationAdapter;

public class AudioPlayer  implements MediaPlayer{
	
	MediaAdapter mediaAdapter ;
	
	public void setAdapter(MediaAdapter mediaAdapter){
		this.mediaAdapter = mediaAdapter;
	}
	
	public void play(String type, String fileName) {
		
		mediaAdapter.play(type, fileName);
		
		
	}

}
