package com.bootcamp.demo.demo_restful_api.model;

import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter // Added for deserialization
@AllArgsConstructor
@NoArgsConstructor // CRITICAL: Needed for JSON deserialization
public class ShoppingMall {
  private String name;
  private double area;
  private Cinema cinema;
  private List<String> shopCategory;

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Cinema {
    private String name;

    @JsonFormat(pattern = "dd-MMM-yyyy") // Handle "01-JAN-2022" format
    private LocalDate openedDate;

    private List<ReleasedFilm> releasedFilms;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReleasedFilm {
      private String name;

      @JsonFormat(pattern = "dd-MMM-yyyy") // Handle "01-Jan-2022" format
      private LocalDate releaseDate;
    }
  }
}
