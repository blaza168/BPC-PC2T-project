package com.blaazha.database.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Config.Key;

@Sources({"classpath:config/persistence.properties"})
public interface PersistenceConfig extends Config {

    @Key("db.url")
    String url();
}
