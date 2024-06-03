/*
    1. 모든 글 출력 페이지 (board.html) 화면 구성

    글쓰기[버튼]
    번호 제목 작성자(아이디) 작성일 조회수 <--Table

    -> write.html
*/

let memberList = [];
let tableContent = [];
let accNo = 0;
init();
tablePrint();

function init(){
    let memList = JSON.parse(localStorage.getItem("mList"))
    if (memList == null) {memList = []}
    let acNo = sessionStorage.getItem("loginNo")

    memberList = memList
    accNo = acNo
}

function tablePrint(){ // 테이블 표시

}
function goWrite(){ //로그인 체크 후 write.html
    if (accNo == null) {alert("로그인이 필요한 기능입니다."); location.href="login.html";}
    else {location.href="write.html"}
}