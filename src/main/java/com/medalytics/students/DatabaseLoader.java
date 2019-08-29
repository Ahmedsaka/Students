package com.medalytics.students;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final StudentRepository studentRepository;

    @Autowired//A consumer of some resource
    public DatabaseLoader(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.studentRepository.save(new Student("Ayodeji", "Ogunjimi", "8, Oyero close Adekunle village Adeniyi Jones Ikeja"));
        this.studentRepository.save((new Student("Saffiyah", "Alimi", "Ofin, Ikorodu")));
    }
}
