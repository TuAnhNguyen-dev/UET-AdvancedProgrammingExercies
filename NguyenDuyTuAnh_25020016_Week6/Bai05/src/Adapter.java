interface Player {
    void play(String name);
}

class OldPlayer {
    void playFile(String name) {
        System.out.println("Played by old player, playing " + name);
    }
}

class AdapterPlayer implements Player {
    private OldPlayer oldPlayer;

    public AdapterPlayer() {
        oldPlayer = new OldPlayer();
    }

    @Override
    public void play(String name) {
        oldPlayer.playFile(name);
    }
}

public class Adapter {
    public static void test() {
        System.out.println(" --- KIỂM TRA ADAPTER --- ");

        String file = "Music File";
        AdapterPlayer adapter = new AdapterPlayer();

        adapter.play(file);

        System.out.println();
    }
}
