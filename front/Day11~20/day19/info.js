/*
    내 정보 페이지
        1. 현재 로그인 된 회원의 ID, 이름, 연락처, 회원번호 표시
        2. 회원탈퇴 -> confirm()으로 확인한 후 탈퇴처리
        * 로그인된 회원번호 : sessionStorage
        * 탈퇴시 로그아웃 + index.html
    {no : no, id : id, pw : pw, name : name, phone : phone}
*/
let memberList = [];
let accNo = 0;
init();


function init(){
    let memList = JSON.parse(localStorage.getItem("mList"))
    if (memList == null) {memList = []}
    let acNo = sessionStorage.getItem("loginNo")
    if (acNo == null) {acNo = 0; alert("로그인 후 접근가능한 페이지"); location.href="login.html"; return;}

    memberList = memList
    accNo = acNo
    showInfo();
}

function memIndex(){

    let listIndex = 0;
    for (member of memberList){
        if (member.no == accNo) {listIndex = memberList.indexOf(member); break;}
    }
    return listIndex;
}

function showInfo() {
    let memberNum = memIndex();
    document.querySelector("#accNo").innerHTML = memberList[memberNum].no
    document.querySelector("#id").innerHTML = memberList[memberNum].id
    document.querySelector("#name").innerHTML = memberList[memberNum].name
    document.querySelector("#phone").innerHTML = memberList[memberNum].phone
}

function delAccount(){
    let conf = confirm("정말 탈퇴하실건가요?")
    if (conf == true){
        memberList.splice(memIndex(), 1);
        localStorage.setItem("mList", JSON.stringify(memberList))
        alert("탈퇴가 완료되었습니다"); 
        logout(); location.href="info.html";}
}

function editPasswd(){
    location.href="update.html"


}

