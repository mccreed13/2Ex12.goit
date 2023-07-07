package com.example.ex12;

import com.example.ex12.entity.Note;
import com.example.ex12.service.NoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Ex12Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.example.ex12");
        NoteService noteService = context.getBean(NoteService.class);
        noteService.add(new Note(2L, "Title", "Context"));
        noteService.add(new Note(2L, "Title2", "Context2"));
        noteService.add(new Note(2L, "Title3", "Context3"));
        System.out.println(noteService.listAll());
    }

}
