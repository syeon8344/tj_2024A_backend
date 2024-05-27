/*
    비회원제 게시판 day13_1 복습


*/


let boardList = [];
let count = 0;

_allread()

function _create(){
    let title = document.querySelector('#titleInput').value;
    let content =  document.querySelector('#contentInput').value;
    let password = document.querySelector('#passwordInput').value;
    let num = count;
    let date = new Date;
    let month = date.getMonth();
    if (month < 9) {month = '0' + (month + 1)} else {month ++}
    boardList[num] = {번호 : num, 제목 : title, 내용 : content, 비밀번호 : password, 작성일 : `${date.getFullYear()}-${month}-${date.getDate()}`, 조회수 : 0}
    count ++;
    _allread()
}

function _allread(){
    let html=''
    for (i=0; i<boardList.length; i++){
        html+= `<tr>
                <td>${boardList[i].번호}</td>
                <td onclick="_read(${boardList[i].번호})">${boardList[i].제목}</td>
                <td>${boardList[i].내용}</td>
                <td>${boardList[i].작성일}</td>
                <td>${boardList[i].조회수}</td>
                </tr>`
    }
    document.querySelector("#tableBody").innerHTML = html;
}

function _read(x){
    let find = findIndex(x)
    if (find == -1) return;
    let viewPage = document.querySelector('#viewPage');
    let html = `<h3>상세 페이지</h3>
                <div>${boardList[find].제목}</div>
                <div>
                    <span>${boardList[find].작성일}</span>
                    <span>${boardList[find].조회수}</span>
                </div>
                <div>${boardList[find].내용}</div>
                <button type="button" onclick='_update(${boardList[find].번호})' >수정</button>
                <button type="button" onclick='_delete(${boardList[find].번호})' >삭제</button>`
    viewPage.innerHTML = html;
    _allread()
}

function _update(x){
    let find = findIndex(x)
    if (find == -1) return;
    else if (checkPass(find) == false) return;
    let uptdTitle = prompt('새 제목');
    let uptdContent = prompt('새 내용');
    boardList[find].제목 = uptdTitle;
    boardList[find].내용 = uptdContent;
    _allread()
    _read(find)
}

function _delete(x){
    let find = findIndex(x)
    if (find == -1) return;
    if (checkPass(find) == false) return;
    boardList.splice(find,1);
    _allread();
    document.querySelector('#viewPage').innerHTML = '';
}

function checkPass(x){
    let find = findIndex(x)
    if (find == -1) return;
    userPass = prompt('비밀번호를 입력하세요')
    if (userPass != boardList[find].비밀번호) {alert('비밀번호가 틀립니다'); return false;}
    return true;
}

function findIndex(x){ // 서버 환경에서 메모리 동기화 이슈
    let find = -1;
    for (i=0; i<boardList.length; i++) { 
        if (boardList[i].번호 == x) {find = i; return find;}
    }
    if (find == -1) {return -1;}
}