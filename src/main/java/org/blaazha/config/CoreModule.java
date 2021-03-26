package org.blaazha.config;

import com.google.inject.AbstractModule;
import org.blaazha.application.service.StudentService;
import org.blaazha.application.service.TeacherService;
import org.blaazha.application.service.impl.StudentServiceImpl;
import org.blaazha.application.service.impl.TeacherServiceImpl;

public class CoreModule extends AbstractModule {

    @Override
    protected void configure() {
        // services
        bind(StudentService.class).to(StudentServiceImpl.class);
        bind(TeacherService.class).to(TeacherServiceImpl.class);
    }
}
