package ru.job4j.map;

import java.nio.file.OpenOption;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class NewCollege {
    private final Map<NewStudent, Set<NewSubject>> students;

    public NewCollege(Map<NewStudent, Set<NewSubject>> students) {
        this.students = students;
    }

    public Optional<NewStudent> findByAccount(String account) {
        Optional<NewStudent> rsl = Optional.empty();
        for (NewStudent s: students.keySet()) {
            if (account.equals(s.getAccount())) {
                rsl = Optional.of(s);
                break;
            }
        }
        return rsl;
    }

    public Optional<NewSubject> findBySubjectName(String account, String name) {
        Optional<NewSubject> rsl = Optional.empty();
        Optional<NewStudent> s = findByAccount(account);
        if (s.isPresent()) {
            Set<NewSubject> subjects = students.get(s.get());
            for (NewSubject subj : subjects) {
                if (name.equals(subj.getName())) {
                    rsl = Optional.of(subj);
                    break;
                }
            }
        }
        return rsl;
    }
}
