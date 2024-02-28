package fa.training.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
public class Movie implements Serializable {
    @Id
    @GeneratedValue(generator = "my_generator")
    @GenericGenerator(name = "my_generator", strategy = "fa.training.entities.Mygenerator")
   @Column(name = "MOVIE_ID", length = 10, unique = true)
    private String id;

    @Column(name = "ACTOR",nullable = false)
    private String actor;

    @Column(name = "CONTENT",nullable = false)
    private String content;

    @Column(name = "DIRECTOR",nullable = false)
    private String director;

  @Column(name = "DURATION", precision = 5, scale = 2,nullable = false)
  private BigDecimal duration;

  @Column(name = "FROM_DATE",nullable = false)
  private Date fromDate;

  @Column(name = "TO_DATE",nullable = false)
  private Date toDate;

  @Column(name = "MOVIE_PRODUCTION_COMPANY",nullable = false)
  private String movieProductionCompany;

  @Column(name = "VERSION",nullable = false)
  private String version;

  @Column(name = "MOVIE_NAME_ENG",nullable = false,unique = true)
  private String movieNameEng;

  @Column(name = "MOVIE_NAME_VN",nullable = false,unique = true)
  private String movieNameVn;

  @Column(name = "LARGE_IMAGE",nullable = false)
  private String largeImage;

  @Column(name = "SMALL_IMAGE",nullable = false)
  private String smallImage;

  @OneToMany(mappedBy = "movie")
  List<MovieType> movieTypes = new ArrayList<>();

  @Override
  public String toString() {
    return "Movie{" +
            "id='" + id + '\'' +
            ", actor='" + actor + '\'' +
            ", content='" + content + '\'' +
            ", director='" + director + '\'' +
            ", duration=" + duration +
            ", fromDate=" + fromDate +
            ", toDate=" + toDate +
            ", movieProductionCompany='" + movieProductionCompany + '\'' +
            ", version='" + version + '\'' +
            ", movieNameEng='" + movieNameEng + '\'' +
            ", movieNameVn='" + movieNameVn + '\'' +
            ", largeImage='" + largeImage + '\'' +
            ", smallImage='" + smallImage + '\'' +
            '}';
  }
}
