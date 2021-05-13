drop table if exists song CASCADE;
CREATE TABLE song (
    id BIGINT AUTO_INCREMENT,
    artist_name VARCHAR(255),
    genre VARCHAR(255),
    label_name VARCHAR(255),
    release_year BIGINT,
    song_key VARCHAR(255),
    song_name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);