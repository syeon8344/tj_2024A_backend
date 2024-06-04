/*
    수정페이지
    1. URL 매개변수/쿼리스트링인 게시물번호 호출
    2. 해당 게시물번호의 title,content 정보를 html에 대입
    3. 새로운 입력값 처리

*/


let itemNo = new URL(location.href).searchParams.get("no");

let tableContent = [];
tableContent = JSON.parse(localStorage.getItem("tContent"))
if (tableContent == null) { tableContent = [];}

let editItem = {}
for (item of tableContent) {
    if (item.boardNo == itemNo) {editItem = item}
}

document.querySelector("#titleInput").value = editItem.title
document.querySelector("#contentInput").value = editItem.bContent
function boardEdit(){
    editItem.title = document.querySelector("#titleInput").value
    editItem.bContent = document.querySelector("#contentInput").value
    localStorage.setItem("tContent", JSON.stringify(tableContent));
    alert("수정 완료"); location.href="view.html?no="+itemNo; return;
}