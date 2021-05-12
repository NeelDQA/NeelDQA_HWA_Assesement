'use strict';
const songName = document.querySelector("#title");
const artistName = document.querySelector("#artist");
const labelName = document.querySelector("#label");
const releaseYear = document.querySelector("#year");
const genre = document.querySelector("#genre");
const songKey = document.querySelector("#key");

const songTable = document.querySelector("#songTable");

const main = document.querySelector("#main")
const idHolder = document.querySelector("#modalId")
const titleHolder = document.querySelector("#modalTitle");
const artistHolder = document.querySelector("#modalArtist");
const labelHolder = document.querySelector("#modalLabel");
const yearHolder = document.querySelector("#modalYear");
const genreHolder = document.querySelector("#modalGenre");
const keyHolder = document.querySelector("#modalKey");



const readAll = () => {
    axios.get("http://localhost:9092/getAll")
        .then((repsonse) => {
            populateTable(songTable, repsonse.data);

        })
        .catch((err) => {
            console.log(err)
        });
}

const populateTable = (table, data) => {

    for (let element of data) {
        let row = table.insertRow();


        for (let key in element) {
            let cell = row.insertCell();

            let text = document.createTextNode(element[key]);
            cell.appendChild(text);



        }
        let editCell = row.insertCell();
        let editButton = document.createElement("button");
        editButton.className = "btn btn-link";
        editButton.setAttribute("data-bs-toggle", "modal");
        editButton.setAttribute("data-bs-target", "#updateModal");
        editButton.onclick = () => { populateModal(element) }


        // editButton.setAttribute("onclick","console.log(element.id)");
        editButton.innerText = "Update";
        // editButton.addEventListener("click", update());

        editCell.appendChild(editButton);

        let deletCell = row.insertCell();
        let deleteButton = document.createElement("button");
        deleteButton.className = "btn btn-link";
        deleteButton.style = "color: red";
        deleteButton.innerText = "Delete";
        deleteButton.onclick = () => { remove(element) };

        deletCell.appendChild(deleteButton);


    }
}

const populateModal = (modalSong) => {


    let id = modalSong.id;
    axios.get(`http://localhost:9092/getOne/${id}`)
        .then((response) => {
            console.log(response.data);
            let modalId = response.data.id;
            let modalTitle = response.data.songName;
            let modalArtist = response.data.artistName;
            let modalLabel = response.data.labelName;
            let modalYear = response.data.releaseYear;
            let modalGenre = response.data.genre;
            let modalKey = response.data.songKey

            idHolder.setAttribute('value', `${modalId}`);
            titleHolder.setAttribute('value', `${modalTitle}`);
            artistHolder.setAttribute('value', `${modalArtist}`);
            labelHolder.setAttribute('value', `${modalLabel}`);
            yearHolder.setAttribute('value', `${modalYear}`);
            genreHolder.setAttribute('value', `${modalGenre}`);
            keyHolder.setAttribute('value', `${modalKey}`);




        })
        .catch((err) => {
            console.log(err);
        })
}

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
            window.location.reload();

        }).
        catch((err) => console.log(err));
}


const update = () =>{

    const MODAL_ID_VALUE = idHolder.value;
    const MODAL_TITLE_VALUE = titleHolder.value;
    const MODAL_ARTIST_VALUE =artistHolder.value;
    const MODAL_LABEL_VALUE = labelHolder.value;
    const MODAL_YEAR_VALUE = yearHolder.value;
    const MODAL_GENRE_VALUE = genreHolder.value;
    const MODAL_KEY_VALUE = keyHolder.value;
   
    let songObj = {
        songName: MODAL_TITLE_VALUE,
        artistName: MODAL_ARTIST_VALUE,
        labelName: MODAL_LABEL_VALUE,
        releaseYear: MODAL_YEAR_VALUE,
        genre: MODAL_GENRE_VALUE,
        songKey: MODAL_KEY_VALUE
    }

    axios.
    put(`http://localhost:9092/update/${MODAL_ID_VALUE}`,songObj)
    .then((response) =>{
        console.log(response);
        window.location.reload();
    })
    .catch((err)=>{
        console.log(err);
    })


}

const remove = (item) => {
    let id = item.id;



    axios.delete(`http://localhost:9092/remove/${id}`)
        .then((response) => {
            console.log(response);
            window.location.reload();
        })
        .catch((err) => {
            console.log(err);
        })

}


readAll();