package org.blaazha;

import com.blaazha.UI.UI;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.blaazha.config.CoreModule;
import org.blaazha.config.DataModule;
import org.blaazha.config.UIModule;
import org.flywaydb.core.Flyway;
import javax.sql.DataSource;


public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new CoreModule(), new DataModule(), new UIModule());

        UI ui = injector.getInstance(UI.class);

        ui.run();
    }
}
