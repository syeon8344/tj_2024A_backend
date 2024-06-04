/*

    게시물 상세 페이지
        - 전체출력 페이지에서 특정 제목 클릭시 <a> 이용한 상세페이지 이동
        - 어떤 게시물을 클릭했는지 식별? => 어떤 걸 클릭했는지 증거 남기기
            1. localStorage/sessionStorage 저장, 문자형식 지원
            2. JS 변수 저장? X [페이지 전환시 메모리 초기화]
            3. *URL 주소에 매개변수 넣기
                = 쿼리스트링 방식 > URL?변수명=데이터, 문자형식 지원
                    URL ? 변수명 = 데이터 & 변수명 = 데이터...
                    <a href="view.html?no=2"> 변수명 : no, 값 : 2

        - JS에서 URL 매개변수 호출하기
            - new URL() : 특정 URL 정보 호출하기
            1. let urlParams = new URL(location.href).searchParams; -> location.href : 현재 URL
            2. let value = urlParams.get("URL변수명");

    1. 현재 클릭된 게시물 번호 찾기
    2. 해당 게시물번호의 게시물 검색
    3. 검색된 결과를 HTML에 출력

*/
//1.
let tableContent = [];
tableContent = JSON.parse(localStorage.getItem("tContent"))
console.log( new URL(location.href).searchParams); // 쿼리스트링(? 뒤 매개변수들)
console.log( new URL(location.href).searchParams.get("no")) // .get('key')

let urlParams = new URL(location.href).searchParams;
let curNo = urlParams.get("no") //글번호

let accNo = 0; // 로그인 유저 번호
accNo = sessionStorage.getItem("loginNo")
if (accNo == null) {accNo = 0;}

let memberList = [];
memberList = JSON.parse(localStorage.getItem("mList"))
if (memberList == null) {memberList = []}

board();
//2. 페이지 열릴 때 출력하기
function board(){ // 어디에 무엇을 {boardNo : brdNo, title : bTitle, userId : uId, bDate : writtenDate, bView : view, bContent : content}
    let boardBox = document.querySelector("#boardBox")
    tableContent = JSON.parse(localStorage.getItem("tContent"))
    if (tableContent == null) { tableContent = [];}
    let divHTML = ''
    let foundItem = {}
    for (item of tableContent) {
        if (item.boardNo == curNo) {foundItem = item}
    }
    foundItem.bView ++
    localStorage.setItem('tContent', JSON.stringify(tableContent));
    divHTML += `<div class="row">글 번호 : ${foundItem.boardNo}</div>
            <div class="row">제목 : ${foundItem.title}</div>
            <div class="row">아이디 : ${foundItem.userId}</div>
            <div class="row">날짜 : ${foundItem.bDate}</div>
            <div class="row">조회수 : ${foundItem.bView}</div>
            <div class="row">내용 : ${foundItem.bContent}</div>
            `
    console.log(divHTML)
    document.querySelector("#boardBox").innerHTML = divHTML
}

//3. 삭제 : 현재 로그인된 회원과 작성자와 아이디가 같을때
function _delete(){
    let parity = checkParity();
    if (parity == false) {alert("권한이 없습니다"); return;}
    let loggedId = ''
    for (mem of memberList) { // 로그인된 유저 아이디
        if (mem.no == accNo) {loggedId = mem.id}
    }

    for (item of tableContent) {
        if (item.boardNo == curNo && item.userId == loggedId) {
            tableContent.splice(tableContent.indexOf(item), 1)
            localStorage.setItem('tContent', JSON.stringify(tableContent));
            alert("삭제성공"); location.href="board.html"; return;
        }
    }
}

function _edit(){
    let parity = checkParity();
    console.log("parity",parity)
    if (parity == true) {location.href="modify.html?no="+curNo; return;}
    alert("권한이 없습니다")
}

//유효성 체크 함수
function checkParity(){ console.log("checkparity")
    if (accNo < 1) {alert("권한이 없습니다"); return false;}
    let loggedId = ''
    for (mem of memberList) { // 로그인된 유저 아이디
        if (mem.no == accNo) {loggedId = mem.id}
    }

    for (item of tableContent) {
        if (item.boardNo == curNo && item.userId == loggedId) {
            return true;
        }
    }
    return false;
}
//http://192.168.30.186:5500/day19/index.html