package group.goit.devmodule13.services;

import group.goit.devmodule13.entities.Note;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoteService {
    private Map<Long, Note> notes;
    private Long nextId;

    public NoteService() {
        notes = new HashMap<>(Map.of(
                1L, new Note(1L, "First Title", "First Context"),
                2L, new Note(2L, "Second Title", "Second Context"),
                3L, new Note(3L, "Third Title", "Third Context"),
                4L, new Note(4L, "Fourth Title", "Fourth Context"),
                5L, new Note(5L, "Fifth Title", "Fifth Context")
        ));
        nextId = (long) notes.size();
    }

    public List<Note> listAll() {
        return notes.values().stream().toList();
    }

    public Note add(Note note) {
        nextId++;
        note.setId(nextId);
        notes.put(nextId, note);
        return note;
    }

    public void deleteById(long id) {
        if (notes.remove(id) == null) {
            throw new RuntimeException("Note with id = " + id + " doesn't exist!");
        } else {
            notes.remove(id);
        }
    }

    public void update(Note note) {
        final Long id = note.getId();
        if (notes.containsKey(id)) {
            Note currentNote = notes.get(id);
            currentNote.setTitle(note.getTitle());
            currentNote.setContent(note.getContent());
        } else {
            throw new RuntimeException("Note with id = " + note.getId() + " doesn`t exist!");
        }
    }

    public Note getById(long id) {
        return notes.get(id);
    }
}
