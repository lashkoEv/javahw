package org.itstep.init;

import org.itstep.model.Group;
import org.itstep.model.Student;
import org.itstep.model.Teacher;
import org.itstep.service.AcademyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;

@Profile("dev")
@Component
public class InitDatabase {
    final AcademyService academyService;

    private static boolean inited;
    private static int start = 0;
    private static int end = 5;

    public InitDatabase(AcademyService academyService) {
        this.academyService = academyService;
    }

    @PostConstruct
    public void init() {
        if (inited) return;

        // List of groups
        List<Group> groups = List.of(
                new Group("Java summer 2019"),
                new Group("Java summer 2018"),
                new Group("Java summer 2017"),
                new Group("Internet Marketing 2018"),
                new Group("Java summer 2011"),
                new Group("Java summer 2016"),
                new Group("Java summer 2020"),
                new Group("Web autumn 2011"),
                new Group("Web autumn 2012"),
                new Group("Web autumn 2013"),
                new Group("Web autumn 2014"),
                new Group("Web autumn 2015"),
                new Group("Web autumn 2016"),
                new Group("Web autumn 2017"),
                new Group("Web autumn 2018")
        );

        // Init groups
        groups.forEach(academyService::save);

        // Init students
        for (int i = start; i < end; i++) {
            academyService.save(new Student("Вася", "Пупкин", "http://localhost:8080/uploads/1.jpg",
                    LocalDate.of(2001, 1, 1), groups.get(0)));
            academyService.save(new Student("Маша", "Ефросинина", "http://localhost:8080/uploads/2.jpg",
                    LocalDate.of(1986, 2, 12), groups.get(0)));
        }
        // Init teachers
        for (int i = start; i < end; i++) {
            academyService.save(new Teacher(null, "Василий", "Петров",
                    List.of(groups.get(0), groups.get(1))));
            academyService.save(new Teacher(null, "Михаил", "Иванов",
                    List.of(groups.get(0), groups.get(1))));
        }

        inited = true;
    }
}
