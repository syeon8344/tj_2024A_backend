/*
    localStorage 활용
    방명록 : 방문내용 + 작성일


*/

let comment = [
]

printC();

function uploadC () {
    let cont = document.querySelector("#input").value;
    let date = new Date();
    let contDate = `${date.getFullYear()}-${date.getMonth()+1}-${date.getDate()}`

    let entry = {content : cont, date : contDate};

    comment = JSON.parse(localStorage.getItem("commentlist"));

    if (comment == null){comment = [];}

    comment.push(entry)

    localStorage.setItem("commentlist", JSON.stringify(comment))


    document.querySelector("#input").value = '';
    printC();
}

function printC () {
    let loc = document.querySelector('#comment')
    let html = ''
    let comment = JSON.parse(localStorage.getItem("commentlist"));
    if (comment == null) return;
    for (let i = 0; i < comment.length; i++) {
        html += `<div> ${comment[i].content} / ${comment[i].date} </div>`
    }

    loc.innerHTML = html
}