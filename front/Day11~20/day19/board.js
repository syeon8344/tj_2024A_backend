/*
    1. 모든 글 출력 페이지 (board.html) 화면 구성

    글쓰기[버튼]
    번호 제목 작성자(아이디) 작성일 조회수 <--Table

    -> write.html
    {boardNo : brdNo, title : bTitle, userId : uId, bDate : writtenDate, bView : view, bContent : content}
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
    if (acNo == null) {acNo = 0;}
    let tContent = JSON.parse(localStorage.getItem("tContent"))
    if (tContent == null) {tContent = []}
    
    tableContent = tContent;
    memberList = memList
    accNo = acNo
}

function goWrite(){ //로그인 체크 후 write.html
    if (accNo == null) {alert("로그인이 필요한 기능입니다."); location.href="login.html";}
    else {location.href="write.html"}
}

function tablePrint(){ // 테이블 표시 //<td onclick="detail(${entries.boardNo})">${entries.title}
    let tableHTML = ''
    for (entries of tableContent) {
        tableHTML += `<tr><td>${entries.boardNo}</td><td><a href="view.html?no=${entries.boardNo}">${entries.title}</a></td><td>${entries.userId}</td><td>${entries.bDate}</td><td>${entries.bView}</td></tr>`
    }
    document.querySelector("#thead").innerHTML = `<tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th></tr>`
    document.querySelector("#gobackbtn").innerHTML = '';
    document.querySelector("#tbody").innerHTML = tableHTML;
}

function detail(boardNo){



/*    let showPost = tableContent[boardNo-1]
    showPost.bView ++;
    localStorage.setItem("tContent", JSON.stringify(tableContent))
    tableContent = JSON.parse(localStorage.getItem("tContent"))
    

    document.querySelector("#thead").innerHTML = `<tr><th>제목 : ${showPost.title}</th></tr>`
    document.querySelector("#tbody").innerHTML = `<tr><td>내용 : ${showPost.bContent}</td></tr>`;
    document.querySelector("#gobackbtn").innerHTML = `<button type="button" onclick="tablePrint()">돌아가기</button>`*/
}