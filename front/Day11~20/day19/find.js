//1. 아이디찾기 <왼쪽박스> 이름과 전화번호 입력, 일치한 아이디를 특정 div에 출력
//2. 비밀번호찾기 <오른쪽> 아이디와 연락처 입력, 찾은 비밀번호를 특정 div에 출력
let memberList = [];
findInit();


function findInit(){ //memberList 불러오기
    let memList = JSON.parse(localStorage.getItem("mList"))
    if (memList == null) {memList = []}
    memberList = memList;
}

function findId(){
    let nameVal = document.querySelector("#findIdName").value
    let phoneVal = document.querySelector("#findIdPhone").value
    for (let i=0; i < memberList.length; i++){
        if (memberList[i].name == nameVal) {
            if (memberList[i].phone == phoneVal) {
                document.querySelector("#foundId").innerHTML = `아이디는 ${memberList[i].id}입니다`
            } else {alert("연락처를 다시 확인해주세요"); return;}
        } else {alert("이름을 다시 확인해주세요"); return;}
    }
}

function findPasswd(){
    let idVal = document.querySelector("#findPasswdId").value
    let phoneVal = document.querySelector("#findPasswdPhone").value
    for (let i=0; i < memberList.length; i++){
        if (memberList[i].id == idVal) {
            if (memberList[i].phone == phoneVal) {
                document.querySelector("#foundPassWd").innerHTML = `비밀번호는 ${memberList[i].pw}입니다`
            } else {alert("연락처를 다시 확인해주세요"); return;}
        } else {alert("아이디를 다시 확인해주세요"); return;}
    }
}