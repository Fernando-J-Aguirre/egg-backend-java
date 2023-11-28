package libreria.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long isbn;
    private String title;
    private Integer releaseYear;
    private Integer copies;
    private Integer borrowedCopies;
    private Integer copiesRemaining;
    private Boolean alta;

    public Book() {
        borrowedCopies = 0;
        alta = true;
    }

    public Book(Long isbn, String title, Integer releaseYear, Integer copies) {
        this.isbn = isbn;
        this.title = title;
        this.releaseYear = releaseYear;
        this.copies = copies;
        this.borrowedCopies = 0;
        this.alta = true;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public Integer getBorrowedCopies() {
        return borrowedCopies;
    }

    public void setBorrowedCopies(Integer borrowedCopies) {
        this.borrowedCopies = borrowedCopies;
    }

    public Integer getCopiesRemaining() {
        return copiesRemaining;
    }

    public void setCopiesRemaining(Integer copiesRemaining) {
        this.copiesRemaining = copiesRemaining;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    @Override
    public String toString() {
        return "Book{" + "isbn=" + isbn + ", title=" + title + ", releaseYear=" + releaseYear + ", copies=" + copies + ", borrowedCopies=" + borrowedCopies + ", copiesRemaining=" + copiesRemaining + ", alta=" + alta + '}';
    }

}


