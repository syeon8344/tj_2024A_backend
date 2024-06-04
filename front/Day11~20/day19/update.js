/*

    회원 비밀번호 수정 페이지
        1. 현재 로그인된 회원의 비밀번호 수정 처리
        2. 현재 비밀번호, 새로운 비밀번호 두번
        3. 유효성 검사
            1. 현재 비밀번호 == 회원정보 비밀번호
            2. 새 비밀번호 == 새 비밀번호2
            3. 비밀번호 5글자 이상만 가능
            4. 수정완료시 로그아웃
*/
let memberList = [];
let accNo = 0;    
init();

function init(){
    let memList = JSON.parse(localStorage.getItem("mList"))
    if (memList == null) {memList = []}
    let acNo = sessionStorage.getItem("loginNo")
    if (acNo == null) {alert("로그인 후 접근가능한 페이지"); location.href="login.html"; return;}

    accNo = acNo
    memberList = memList

}

function memIndex(){

    let listIndex = 0;
    for (member of memberList){
        if (member.no == accNo) {listIndex = memberList.indexOf(member); break;}
    }

    return listIndex;
}

function update(){
    let passCheck = document.querySelector("#curPasswd").value
    let newPass = document.querySelector("#newPasswd").value
    let newPass2 = document.querySelector("#newPasswd2").value
    let indexNum = memIndex()

    if (memberList[indexNum].pw == passCheck) {
        if (newPass.length > 5 && newPass == newPass2) {
            memberList[indexNum].pw = newPass;
            localStorage.setItem("mList", JSON.stringify(memberList))
            alert("비밀번호 수정 완료"); logout();
            } else {alert("새 비밀번호를 다시 확인해주세요")}
    } else {alert("현재 비밀번호를 다시 확인해주세요")}
}

function goback(){
    location.href="info.html"
}