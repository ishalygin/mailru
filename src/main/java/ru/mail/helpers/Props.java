package ru.mail.helpers;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.Reloadable;

/**
 * Класс для проперти
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:src/test/resources/general.properties"
})
public interface Props extends Reloadable {

    Props props = ConfigFactory.create(Props.class);

    @Key("mail.ru.url")
    String mailruUrl();

}