package ceit.aut.ac.ir.model;

import java.io.Serializable;

/**
 * keeps note's information
 * @author Mobina Hadavifar
 * @version 1.0
 */
// TODO: Phase2: uncomment this code
public class Note implements Serializable {

    private String title;
    private String content;
    private String date;

    /**
     * makes a new note
     * @param title of the note
     * @param content of the note
     * @param date of the note
     */
    public Note(String title, String content, String date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    /**
     * @return note's content
     */
    public String getContent (){
        return content;
    }

    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

}

