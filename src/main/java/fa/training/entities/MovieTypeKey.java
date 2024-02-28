package fa.training.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
@ToString
public class MovieTypeKey implements Serializable {
    @JoinColumn(name = "typeId")
    Integer typeId;

    @Column(length = 10)
    @JoinColumn(name = "moveId")
     String movieId;
}
