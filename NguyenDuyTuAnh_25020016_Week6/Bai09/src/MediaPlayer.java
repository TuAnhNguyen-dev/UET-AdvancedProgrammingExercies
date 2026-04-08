public class MediaPlayer {
    AudioPlayable audioProsessor;
    VideoPlayable videoProsessor;

    public MediaPlayer(AudioPlayable audioProsessor, VideoPlayable videoProsessor) {
        this.audioProsessor = audioProsessor;
        this.videoProsessor = videoProsessor;
    }

    public void playAudio(String file) {
        audioProsessor.playAudio(file);
    }

    public void playVideo(String file) {
        videoProsessor.playVideo(file);
    }
}
