package com.blaazha.database.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:config/persistence.properties"})
public interface PersistenceConfig extends Config {

    @Key("db.url")
    String url();
    @Key("db.username")
    String username();
    @Key("db.password")
    String password();
    @Key("db.pool.size")
    @DefaultValue("20")
    int poolSize();
    @Key("db.pool.expiration")
    @DefaultValue("5000")
    int poolExpiration();
}
