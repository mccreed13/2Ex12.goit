package com.example.ex12.service;

import com.example.ex12.entity.Note;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {
    private Map<Long,Note> noteMap;

    public NoteService(){
        this.noteMap = new HashMap<>();
    }
    public Map<Long,Note> listAll(){
        return noteMap;
    }

    public Note add(Note note){
        note.setId(noteMap.size()+1L);
        noteMap.put(note.getId(), note);
        return note;
    }

    public void deleteById(Long id){
        Note note = noteMap.get(id);
        if(note == null){
            throw new EmptyStackException();
        }
        noteMap.remove(id, note);
    }

    public void delete(Note note){
        if(!noteMap.containsValue(note)){
            throw new EmptyStackException();
        }
        noteMap.remove(note.getId(), note);
    }

    public void update(Note note){
        if(noteMap.containsKey(note.getId())){
            noteMap.replace(note.getId(), note);
        } else throw new EmptyStackException();
    }

    public Note getById(Long id){
        Note note = noteMap.get(id);
        if(note == null) throw new EmptyStackException();
        return noteMap.get(id);
    }
}
