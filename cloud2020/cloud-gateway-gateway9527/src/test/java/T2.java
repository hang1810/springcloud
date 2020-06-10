import java.time.ZoneId;
import java.time.ZonedDateTime;

public class T2 {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        ZonedDateTime zdy =  ZonedDateTime.now(ZoneId.of("America/New_York"));//指定时区获取
        System.out.println(zdy);
    }
}
