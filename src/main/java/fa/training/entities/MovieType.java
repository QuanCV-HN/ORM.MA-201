package fa.training.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class MovieType {

    @EmbeddedId
     MovieTypeKey id;

    @Column(name = "MT_DESCRIPTION")
    private String mtDescription;

    @ManyToOne
    @MapsId(value = "typeId")
    private Type type;

    @ManyToOne
    @MapsId(value = "movieId" )
    private Movie movie;

    @Override
    public String toString() {
        return "MovieType{" +
                "id=" + id +
                ", mtDescription='" + mtDescription + '\'' +
                '}';
    }
}
