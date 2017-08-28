package jdk7;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

/**
 * Created by ming on 17/8/28.
 */
public class WatchServiceDemo {

    WatchService watchService = null;
    Path path = null;

    public static void main(String[] args) {
        WatchServiceDemo watchServiceDemo = new WatchServiceDemo();
        watchServiceDemo.init("/Users/ming/tmp");
        watchServiceDemo.start();
    }

    private void init(String dir) {
        path = Paths.get(dir);
        try {
            watchService = FileSystems.getDefault().newWatchService();
            path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY,
                    StandardWatchEventKinds.OVERFLOW);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() {
        boolean watching = true;

        while (watching) {
            try {
                WatchKey watchKey = watchService.take();
                if(watchKey != null) {
                    List<WatchEvent<?>> events = watchKey.pollEvents();

                    for(WatchEvent event : events) {
                        System.out.println(event.kind().name());
                    }

                    if(!watchKey.reset()) {
                        break;
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

/*

mini:tmp ming$ vi test.txt
mini:tmp ming$ pwd
/Users/ming/tmp
mini:tmp ming$ ls
test.txt
mini:tmp ming$ vi test.txt
mini:tmp ming$

ENTRY_CREATE
ENTRY_DELETE
ENTRY_CREATE
ENTRY_MODIFY
ENTRY_DELETE

 */