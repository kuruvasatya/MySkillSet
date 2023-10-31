package singleton;

import java.time.LocalDateTime;

public class Weather {
    String date = LocalDateTime.now().toString();
    int weather = (int)(Math.random() * 100);

    @Override
    public String toString() {
        return "Weather{" +
                "date='" + date + '\'' +
                ", weather=" + weather +
                '}';
    }
}
