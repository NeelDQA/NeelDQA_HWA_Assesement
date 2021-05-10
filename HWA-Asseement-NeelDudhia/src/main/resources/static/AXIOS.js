'use strict';
const songName = document.querySelector("#title");
const artistName = document.querySelector("#artist");
const labelName = document.querySelector("#label");
const releaseYear = document.querySelector("#year");
const genre = document.querySelector("#genre");
const songKey = document.querySelector("#key");


const create = () => {

    const songName_VALUE = songName.value;
    const artistName_VALUE = artistName.value;
    const labelName_VALUE = labelName.value;
    const releaseYear_VALUE = releaseYear.value;
    const genre_VALUE = genre.value;
    const songKey_VALUE = songKey.value;

    let songObj = {
        songName: songName_VALUE,
        artistName: artistName_VALUE,
        labelName: labelName_VALUE,
        releaseYear: releaseYear_VALUE,
        genre: genre_VALUE,
        songKey: songKey_VALUE


    }
    axios.
        post("http://localhost:9092/create", songObj).
        then((response) => {
             console.log(response);
            // windows load refresh to refresh page 

        }).
        catch((err) => console.log(err));
}