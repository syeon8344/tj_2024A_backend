/*

    board.html에서 글쓰기 버튼 클릭시 이동
    1. 비로그인 상태: 글쓰기 페이지 접근 제한하고 안내후 login.html
    2. 로그인 상태: '제목'과 '내용'입력받아 글쓰기 처리

    Create  : 저장  글쓰기  arr.push()                 |   .setItem('key', value)
    Read    : 호출  전체글/개별글출력   for(), arr[]    |   .getItem('key')
    Update  : 수정  글수정  arr.property = newValue
    Delete  : 삭제  글삭제  arr.splice(index,1)        |   .removeItem('key')

    tableContent = [{번호 제목 작성자(아이디) 작성일 조회수}]
*/
let accNo = 0;
let memberList = [];
let tableContent = [];
init()

function init(){
    let memList = JSON.parse(localStorage.getItem("mList"))
    if (memList == null) {memList = []}
    let acNo = sessionStorage.getItem("loginNo")
    if (acNo == null) {alert("로그인이 필요한 기능입니다."); location.href="login.html";}
    let tContent = JSON.parse(localStorage.getItem("tContent"))
    if (tContent == null) {tContent = []}
    
    memberList = memList;
    accNo = acNo;
    tableContent = tContent;

}

function boardWrite(){
    let bTitle = document.querySelector("#titleInput").value;
    let content = document.querySelector("#contentInput").value;

    let brdNo = tableContent.length == 0 ? 1 : tableContent[tableContent.length-1].boardNo + 1

    let accIndex = memIndex();
    let uId = memberList[accIndex].id;

    let date = new Date();
    let month = date.getMonth() + 1
    let writtenDate = `${date.getFullYear()}-${dform(month)}-${dform(date.getDate())} ${dform(date.getHours())}:${dform(date.getMinutes())}`

    let view = 0;

    let newBoard = {boardNo : brdNo, title : bTitle, userId : uId, bDate : writtenDate, bView : view, bContent : content}
    console.log(newBoard);
    tableContent.push(newBoard);
    localStorage.setItem("tContent", JSON.stringify(tableContent))
    alert("글 작성 완료"); location.href="board.html"
}

function memIndex(){ // 회원번호 인덱스 찾기

    let listIndex = 0;
    for (member of memberList){
        if (member.no == accNo) {listIndex = memberList.indexOf(member); break;}
    }

    return listIndex;
}

function dform(num){ //날짜 자릿수 확인/수정 (x<10일때 0 붙이기)
    if (num < 10) {num = "0" + num}
    return num;
}
