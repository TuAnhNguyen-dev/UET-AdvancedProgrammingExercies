public class Main {
    public static void main(String[] args) {
        System.out.println("--- KIỂM TRA SOLID (ISP & DIP) ---");

        // Main đóng vai trò là kẻ "bơm" (inject) sự phụ thuộc
        AudioPlayable myAudio = new AudioPlayer();
        VideoPlayable myVideo = new VideoPlayer();

        // MediaPlayer không hề biết ai đang thực sự xử lý âm thanh/hình ảnh bên dưới
        MediaPlayer system = new MediaPlayer(myAudio, myVideo);

        system.playAudio("podcast_backend.mp3");
        system.playVideo("huong_dan_java.mp4");
    }
}