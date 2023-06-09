package com.winkly.entity;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(
    name = "user_table",
    indexes = {
      @Index(name = "table_symbol", columnList = "email", unique = true),
      @Index(name = "table_username", columnList = "username", unique = true),
      @Index(name = "table_name", columnList = "name ASC")
    },
    uniqueConstraints = {
      @UniqueConstraint(columnNames = "email"),
      @UniqueConstraint(columnNames = "username")
    })
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserEntity implements Serializable {

  private static final long serialVersionUID = -645834567897L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @NotBlank
  @Size(max = 50)
  @Email
  @Column(name = "email")
  private String email;

  @NotBlank
  @Size(max = 120)
  @Column(name = "username")
  private String username;

  @NotBlank
  @Size(max = 200)
  @Column(name = "name")
  private String name;

  @NotBlank
  @Size(max = 255)
  @Column(name = "bio")
  private String bio;

  @NotBlank
  @Size(max = 255)
  @Column(name = "age")
  private Integer age;

  @NotBlank
  @Size(max = 255)
  @Column(name = "location")
  private String location;

  @NotBlank
  @Size(max = 120)
  @Column(name = "password")
  private String password;

  @Column(name = "resetToken")
  @Nullable
  private String resetToken;

  @Column(name = "tokenCreationTime")
  @Nullable
  private LocalDateTime tokenCreationTime;

  @Column(name = "twitter_link")
  @Nullable
  private String twitterLink;

  @Column(name = "insta_link")
  @Nullable
  private String instaLink;

  @Column(name = "verified_status")
  @Nullable
  private String verifiedStatus;

  @Column(name = "liked_you")
  @ElementCollection
  @LazyCollection(LazyCollectionOption.FALSE)
  private List<Likes> likedYou = new ArrayList<>();

  @Column(name = "you_liked")
  @ElementCollection
  @LazyCollection(LazyCollectionOption.FALSE)
  private List<Likes> youLiked = new ArrayList<>();

  @Column(name = "matched")
  @ElementCollection
  @LazyCollection(LazyCollectionOption.FALSE)
  private List<String> matched = new ArrayList<>();

  @Column(name = "extra_links")
  @ElementCollection
  @LazyCollection(LazyCollectionOption.FALSE)
  private List<Links> extraLinks = new ArrayList<>();

  @Column(name = "problems")
  @ElementCollection
  @LazyCollection(LazyCollectionOption.FALSE)
  private List<Problems> problems = new ArrayList<>();

  @Column(name = "profile_picture")
  @Nullable
  private String profilePicture;

  public UserEntity(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public UserEntity(String email) {
    this.email = email;
  }

}
